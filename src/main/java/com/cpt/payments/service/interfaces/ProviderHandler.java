package com.cpt.payments.service.interfaces;

import com.cpt.payments.dto.InitiatedPaymentReqDTO;
import com.cpt.payments.dto.InitiatedPaymentResDTO;
import com.cpt.payments.dto.TransactionDTO;

public interface ProviderHandler {
    public InitiatedPaymentResDTO processPayment(TransactionDTO txn, InitiatedPaymentReqDTO req);
}
