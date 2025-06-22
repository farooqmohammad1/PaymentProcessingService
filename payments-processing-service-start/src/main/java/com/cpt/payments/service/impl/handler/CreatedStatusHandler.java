package com.cpt.payments.service.impl.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cpt.payments.DTO.TransactionDTO;
import com.cpt.payments.dao.impl.TransactionDaoImpl;
import com.cpt.payments.service.interfaces.PaymentStatusHandler;

@Component
public class CreatedStatusHandler extends PaymentStatusHandler {
	
	@Autowired
	private TransactionDaoImpl txnDao;

	@Override
	public String processStatus(TransactionDTO payment) {
	
		System.out.println("This is from CreatedstatusHandler child"+payment);
		String txnCreatedResponse=txnDao.createTransaction(payment);
		System.out.println("Returning from TransactionDao Impl"+txnCreatedResponse);
		return "Returning from Created Status Handler"+txnDao;
	}

}
