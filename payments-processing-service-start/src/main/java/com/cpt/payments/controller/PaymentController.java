package com.cpt.payments.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpt.payments.DTO.TransactionDTO;
import com.cpt.payments.constants.EndPoints;
import com.cpt.payments.service.interfaces.PaymentStatusService;

@RestController
@RequestMapping(EndPoints.V1_PAYMENTS)
public class PaymentController {
	@Autowired
	private PaymentStatusService service;
	@Autowired 
	private ModelMapper modelMapper;
	
	@PostMapping({EndPoints.EMPTY_STRING,EndPoints.SLASH})
	public String createPayment(@RequestBody Transaction payment) {
		//Incoming Transaction to TransactionDTO
		TransactionDTO mappedDTO=modelMapper.map(payment, TransactionDTO.class);//type of class
		System.out.println("Converted from Transaction incoming POJO to DTO "+mappedDTO);
		
		String serviceVal=service.processStatus(mappedDTO);
		
		System.out.println("This is from payment"+payment+" and valservice"+serviceVal);
		
		
		return "123"+serviceVal;
		
	}

}
