package com.proj.gps.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tipos")
public class TipoResource {

	@GetMapping
	public ResponseEntity<String> test() {
		String message = "Hello World";
		return ResponseEntity.ok(message);
	}
}
