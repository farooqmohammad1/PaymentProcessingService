package com.cpt.payments.service.interfaces;

import com.cpt.payments.DTO.TransactionDTO;

public interface PaymentStatusService {
	public String processStatus(TransactionDTO mappedDTO);

}
