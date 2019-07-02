package net.koreate.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import net.koreate.util.MediaUtils;
import net.koreate.util.UploadFileUtils;

@Slf4j
@Controller
public class UploadController {

	@Resource(name = "uploadPath")
	String uploadPath;

	@GetMapping("/")
	public String home() {
		log.info("get home view call!!!");
		return "home";
	}

	@GetMapping("/uploadForm")
	public void uploadForm() {
		log.info("get uploadForm view call!!!");
		log.warn("uploadPath : " + uploadPath);
		File file = new File(uploadPath);
		if (!file.exists())
			file.mkdirs();
	}

	@PostMapping("/uploadForm")
	public String uploadForm(MultipartFile file, Model model) throws IOException {
		log.info("post file upload call!!!");
		log.info("file name : " + file.getOriginalFilename());
		log.info("file size : " + file.getSize());
		log.info("file type : " + file.getContentType());

		String savedName = UploadFileUtils.uploadFile(file.getOriginalFilename(), uploadPath, file.getBytes());
		model.addAttribute("savedName", savedName);
		return "uploadResult";
	}

	@PostMapping("/uploadForm1")
	public String uploadForm(MultipartFile[] file, Model model) throws IOException {
		log.info("post files upload call!!!");
		List<String> savedNames = new ArrayList<>();

		for (int i = 0; i < file.length; i++) {
			log.info("file name : " + file[i].getOriginalFilename());
			log.info("file size : " + file[i].getSize());
			log.info("file type : " + file[i].getContentType());

			String savedName = UploadFileUtils.uploadFile(file[i].getOriginalFilename(), uploadPath,
					file[i].getBytes());
			savedNames.add(savedName);
		}

		model.addAttribute("savedNames", savedNames);
		return "uploadResult";
	}

	@PostMapping("/uploadForm2")
	public String uploadForm(MultipartHttpServletRequest request, Model model) throws IOException {
		log.info("post files upload call!!!");
		String auth = request.getParameter("auth");
		log.info("auth : " + auth);
		MultipartFile file = request.getFile("file");
		MultipartFile file1 = request.getFile("file1");

		String OriginalFile = file.getOriginalFilename();
		String OriginalFile1 = file1.getOriginalFilename();

		String[] savedNames = new String[2];
		savedNames[0] = UploadFileUtils.uploadFile(OriginalFile, uploadPath, file.getBytes());
		savedNames[1] = UploadFileUtils.uploadFile(OriginalFile1, uploadPath, file1.getBytes());
		model.addAttribute("savedNames2", savedNames);
		return "uploadResult";
	}

	@PostMapping("/uploadForm3")
	public String uploadForm3(MultipartHttpServletRequest request, Model model) throws IOException {
		log.info("post files upload call!!!");
		String auth = request.getParameter("auth");
		log.info("auth : " + auth);
		MultipartFile file1 = request.getFile("file1");
		List<MultipartFile> fileList = request.getFiles("file");

		String[] savedName = new String[fileList.size() + 1];
		for (int i = 0; i < fileList.size(); i++) {
			MultipartFile file = fileList.get(i);
			savedName[i] = UploadFileUtils.uploadFile(file.getOriginalFilename(), uploadPath, file.getBytes());
		}
		savedName[savedName.length - 1] = UploadFileUtils.uploadFile(file1.getOriginalFilename(), uploadPath,
				file1.getBytes());
		model.addAttribute("savedName3", savedName);
		return "uploadResult";
	}

	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		log.info("get uploadAjax view call!!!");
	}

	@PostMapping(value = "/uploadAjax", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public ResponseEntity<String> uploadAjax(MultipartFile file) {
		log.info("get uploadAjax view call!!!");
		ResponseEntity<String> entity = null;
		log.warn("file Name : " + file.getOriginalFilename());

		try {
			entity = new ResponseEntity<>(
					UploadFileUtils.uploadFile(file.getOriginalFilename(), uploadPath, file.getBytes()),
					HttpStatus.CREATED);
		} catch (Exception e) {
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return entity;
	}

	@RequestMapping("/displayFile")
	@ResponseBody
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {
		log.info("get displayFile call!!!");
		ResponseEntity<byte[]> entity = null;
		InputStream in = null;

		System.out.println(fileName);

		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
			System.out.println(formatName);

			MediaType mType = MediaUtils.getMediaType(formatName);
			HttpHeaders headers = new HttpHeaders();

			in = new FileInputStream(uploadPath + fileName);
			if (mType != null)
				headers.setContentType(mType);
			else {
				fileName = fileName.substring(fileName.indexOf("_") + 1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-disposition",
						"attachment;fileName=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
		return entity;
	}

	@PostMapping("/deleteFile")
	public ResponseEntity<String> deleteFile(String fileName) throws Exception {
		log.info("post deleteFile call!!!");

		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
		MediaType mType = MediaUtils.getMediaType(formatName);

		if (mType != null) {
			String front = fileName.substring(0, 12);
			String end = fileName.substring(14);
			new File(uploadPath + (front + end).replace('/', File.separatorChar)).delete();
		}

		new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();

		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}

}
