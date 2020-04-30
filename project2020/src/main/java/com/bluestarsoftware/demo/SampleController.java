package com.bluestarsoftware.demo;

import java.net.InetAddress;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	@GetMapping("sample/hello")
	public String sayHello() {
		String hostname = "Unknown";
		try {
			hostname = InetAddress.getLocalHost().getHostAddress()
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "From " + hostname + ", I say hello7: " + System.currentTimeMillis();
	}
	
	
}
