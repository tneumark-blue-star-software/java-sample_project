package com.bluestarsoftware.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SampleController {
	
	@GetMapping("sample/hello")
	public String sayHello() {
		return "Message Version 8 =" + System.currentTimeMillis() + "<br>" +
			   "Instance Metadata = " + getInstanceMetadata();
	}

	private String getInstanceMetadata() {
		String API = System.getenv("ECS_CONTAINER_METADATA_URI_V4");
		String metadata = "Unavailable";
		try {
			RestTemplate template = new RestTemplate();
			metadata = template.getForObject(API, String.class);
		}
		catch (Exception e) {
			e.printStackTrace();
			metadata = e.getMessage();
		}
		return metadata;
	}
	
	
}
