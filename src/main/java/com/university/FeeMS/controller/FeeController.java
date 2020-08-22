package com.university.FeeMS.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.university.FeeMS.dto.FeeDTO;

import com.university.FeeMS.entity.Fee;
import com.university.FeeMS.service.FeeService;



@RestController
@CrossOrigin
//@RequestMapping(value="/api")
public class FeeController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	FeeService feeService;
	
	@GetMapping(value = "/fee/{studentid}")
	public FeeDTO viewBills(@PathVariable Integer studentid) {
		return feeService.getBills(studentid);
	}
	
	@PostMapping(value = "/fee/add")
	public String addBill(@RequestBody FeeDTO fdto) {
		
		return feeService.add(fdto);
		
	}
	
	@PostMapping(value="/fee/{studentid}/pay")
	public String payFee(@PathVariable Integer studentid) {
		
		
		
		return feeService.payBill(studentid);
	}
	
	
	
	
	
	}

