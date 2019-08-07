package com.palani.springmongo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.palani.springmongo.service.SalesService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@AllArgsConstructor
public class SalesController {
	
	private SalesService salesService;
	
	 @GetMapping("/sales")
	    public ResponseEntity<Object> getSales() {
	        return ResponseEntity.ok(salesService.getSales());
	    }
	
	

}
