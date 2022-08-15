package com.code.truck.gps.types.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tipos")
public class TypeResource {

	@GetMapping
	public ResponseEntity<String> test() {
		String message = "Hello World";
		return ResponseEntity.ok(message);
	}
}
