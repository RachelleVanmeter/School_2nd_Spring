package net.koreate.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@GetMapping("/testJavascript")
	public String testJavascript() {
		return "javascript";
	}

	@GetMapping("/ajaxTest")
	public String ajaxTest() {
		return "ajaxTest";
	}

}
