package com.cpt.payments.controller;


import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.dto.TransactionResponseDTO;
import com.cpt.payments.pojo.Transaction;
import com.cpt.payments.service.interfaces.PaymentStatusService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/payments")
public class PaymentController {
    @Autowired
    private PaymentStatusService paymentStatusService;
    @Autowired
    ModelMapper modelMapper;
    @PostMapping({"/",""})
    public ResponseEntity<TransactionResponseDTO> createStatus(@RequestBody Transaction payment){
       TransactionDTO transactionDTO= modelMapper.map(payment, TransactionDTO.class);
       System.out.println(transactionDTO);
       TransactionResponseDTO p= paymentStatusService.processStatus(transactionDTO);
       System.out.println("This is from controller"+p);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }
}
