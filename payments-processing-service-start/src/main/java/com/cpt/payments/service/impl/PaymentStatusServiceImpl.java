package com.cpt.payments.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpt.payments.DTO.TransactionDTO;
import com.cpt.payments.constants.TransactionStatusEnum;
import com.cpt.payments.service.factory.PaymentStatusFactory;
import com.cpt.payments.service.interfaces.PaymentStatusHandler;
import com.cpt.payments.service.interfaces.PaymentStatusService;
@Service
public class PaymentStatusServiceImpl implements PaymentStatusService {
	@Autowired
	private PaymentStatusHandler paymentStatusHandler;
	@Autowired
	private PaymentStatusFactory paymentStatusFactory;

	@Override
	public String processStatus(TransactionDTO transaction) {
       String val= paymentStatusHandler.processStatus(transaction);
      TransactionStatusEnum statusEnum= TransactionStatusEnum.getById(transaction.getTxnStatusId());
      System.out.println("The value of statusENum"+statusEnum);
       
      PaymentStatusHandler getStatus= paymentStatusFactory.getStatusHandler(statusEnum);//here we can enum.getname()
      String statusValue=getStatus.processStatus(transaction);
       
		System.out.println("This is from service impl"+transaction+" "+"This is from PaymentStatusHandler "
       +paymentStatusHandler+" "+getStatus+" "+statusValue);
		return "returning from service impl";
	}
	

}
