package com.cpt.payments.service.interfaces;

import com.cpt.payments.dto.InitiatedPaymentReqDTO;
import com.cpt.payments.dto.TransactionDTO;

public interface ProviderHandler {
    public String processPayment(TransactionDTO txn, InitiatedPaymentReqDTO req);
}
