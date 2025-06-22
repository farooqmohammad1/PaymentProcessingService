package com.cpt.payments.service.factory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.cpt.payments.constants.TransactionStatusEnum;
import com.cpt.payments.service.impl.handler.CreatedStatusHandler;
import com.cpt.payments.service.interfaces.PaymentStatusHandler;
@Component
public class PaymentStatusFactory {
	@Autowired
	private ApplicationContext ctx;
	
	public PaymentStatusHandler getStatusHandler(TransactionStatusEnum statusEnum) {
		switch(statusEnum) {
		case CREATED:
			System.out.println("This is from created");
			CreatedStatusHandler createdStatusHandler=ctx.getBean(CreatedStatusHandler.class);
			return createdStatusHandler;
		default:	
			System.out.println("Unable to find handler");
			return null;
			
		}
		
		
		
	}

}
