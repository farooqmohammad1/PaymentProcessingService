package com.cpt.payments.service.interfaces;

//import com.cpt.payments.pojo.Payment;

import com.cpt.payments.dto.TransactionDTO;
import org.springframework.stereotype.Service;


public abstract class PaymentStatusHandler {
    public abstract String processStatus(TransactionDTO payment);
}
