package com.cpt.payments.dao.impl;

import org.springframework.stereotype.Component;

import com.cpt.payments.DTO.TransactionDTO;
import com.cpt.payments.dao.interfaces.TransactionDao;
@Component
public class TransactionDaoImpl implements TransactionDao {

	@Override
	public String createTransaction(TransactionDTO txnDTO) {
		// TODO Auto-generated method stub
		
		System.out.println("This is from DAO Impl"+txnDTO);
		return "Returning from DAO";
	}

	

}
