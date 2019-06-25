package net.koreate.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import net.koreate.util.MediaUtils;
import net.koreate.util.UploadFileUtils;

@Slf4j
@RestController
public class UploadController {
	
	@Resource(name = "uploadPath")
	String uploadPath;
	
	@Inject
	ServletContext context;
	
	@PostMapping(value = "/uploadAjax", produces = "text/plain;charset=utf-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file) {
		log.info("get uploadAjax view call!!!");
		ResponseEntity<String> entity = null;
		log.warn("file Name : " + file.getOriginalFilename());
		
		try { entity = new ResponseEntity<>(UploadFileUtils.uploadFile(file.getOriginalFilename(), context.getRealPath(File.separator + uploadPath), file.getBytes()), HttpStatus.CREATED); }
		catch (Exception e) { entity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); }
		
		return entity;
	}
	
	@RequestMapping("/displayFile")
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
			if (mType != null) headers.setContentType(mType);
			else {
				fileName = fileName.substring(fileName.indexOf("_") + 1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-disposition", "attachment;fileName=\""
							+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		}
		catch (Exception e) { e.printStackTrace(); }
		finally { in.close(); }
		return entity;
	}

	@PostMapping("/deleteFile")
	public ResponseEntity<String> deleteFile(String fileName) throws Exception {
		log.info("post deleteFile call!!!");
		
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
		MediaType mType = MediaUtils.getMediaType(formatName);
		
		if(mType != null) {
			String front = fileName.substring(0, 12);
			String end = fileName.substring(14);
			new File(uploadPath + (front + end).replace('/', File.separatorChar)).delete();
		}

		new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
		
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
	
}
