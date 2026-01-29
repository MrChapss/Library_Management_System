package lms.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/LMS")
public class Main_Controller {
	
	@GetMapping
	public String hello(@RequestParam String str) {
		return "Hello " + str;
	}
}
