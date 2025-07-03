package com.cpt.payments.controller;


import com.cpt.payments.dto.InitiatedPaymentReqDTO;
import com.cpt.payments.dto.InitiatedPaymentResDTO;
import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.dto.TransactionResponseDTO;
import com.cpt.payments.pojo.InitiatedPaymentReq;
import com.cpt.payments.pojo.InitiatedPaymentRes;
import com.cpt.payments.pojo.Transaction;
import com.cpt.payments.service.interfaces.PaymentService;
import com.cpt.payments.service.interfaces.PaymentStatusService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/payments")
public class PaymentController {
    @Autowired
    private PaymentStatusService paymentStatusService;
    @Autowired
    private PaymentService paymentService;
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
    //this api based on transaction id it will initiate payment request
    @PostMapping("{id}/initiate")
    public ResponseEntity<InitiatedPaymentRes> initiatePayment(@PathVariable int id, @RequestBody InitiatedPaymentReq initiatedPaymentReq){
        InitiatedPaymentReqDTO reqDTO=modelMapper.map(initiatedPaymentReq, InitiatedPaymentReqDTO.class);
        reqDTO.setId(id);
        InitiatedPaymentResDTO resDTO=paymentService.initiatePayment(reqDTO);
        InitiatedPaymentRes res=modelMapper.map(resDTO, InitiatedPaymentRes.class);

        return new ResponseEntity(res,HttpStatus.OK);
    }
}
