package com.cpt.payments.service.interfaces;

import com.cpt.payments.DTO.TransactionDTO;

public abstract class PaymentStatusHandler {
	public abstract String processStatus(TransactionDTO transaction);

}
