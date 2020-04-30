package com.bluestarsoftware.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	@GetMapping("sample/hello")
	public String sayHello() {
		return "hello4: " + System.currentTimeMillis();
	}
	
	
}
