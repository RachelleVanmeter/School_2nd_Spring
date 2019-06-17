package net.koreate.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.koreate.vo.SampleVO;

@RestController
public class ResponseBodyController {

	@RequestMapping("/hello")
	public String hello() {
		return "This is message";
	}

	@GetMapping("/sendVO")
	public SampleVO sendVO() {
		SampleVO sample = new SampleVO();
		sample.setName("홍길동");
		sample.setAge(30);
		return sample;
	}

	@GetMapping("/sampleList")
	public List<SampleVO> sendSampleList() {
		List<SampleVO> list = new ArrayList<>();
		SampleVO sample = new SampleVO();
		sample.setName("홍길동");
		sample.setAge(30);
		list.add(sample);
		sample = new SampleVO();
		sample.setName("이순신");
		sample.setAge(60);
		list.add(sample);
		return list;
	}

	@GetMapping("/sendMap")
	public Map<Integer, SampleVO> sendMap() {
		Map<Integer, SampleVO> map = new HashMap<>();
		for (int i = 0; i < 50; i++) {
			SampleVO sample = new SampleVO();
			sample.setName("홍길동" + i);
			sample.setAge(i);
			map.put(i, sample);
		}
		return map;
	}

	@GetMapping("/sendErrorAuth")
	public ResponseEntity<SampleVO> sendSampleAuth() {
		SampleVO sample = new SampleVO();
		sample.setName("홍길동");
		sample.setAge(500);
		// return new ResponseEntity<>(sample,HttpStatus.BAD_REQUEST);
		// return new ResponseEntity<>(sample,HttpStatus.NOT_FOUND);
		// return new ResponseEntity<>(sample,HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(sample, HttpStatus.OK);
	}

}
