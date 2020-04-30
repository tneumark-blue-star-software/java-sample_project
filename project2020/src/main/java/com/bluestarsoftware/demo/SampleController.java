package com.bluestarsoftware.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SampleController {
	public static final String API = "http://169.254.169.254/latest/meta-data/instance-id";
	
	@GetMapping("sample/hello")
	public String sayHello() {
		return "InstanceID=" + getInstanceId() + ", Message Version 8 =" + System.currentTimeMillis();
	}

	private String getInstanceId() {
		String instanceId = "unknown";
		try {
			RestTemplate template = new RestTemplate();
			instanceId = template.getForObject(API, String.class);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return instanceId;
	}
	
	
}
