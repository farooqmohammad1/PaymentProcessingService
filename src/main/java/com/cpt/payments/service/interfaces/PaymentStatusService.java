package com.cpt.payments.service.interfaces;

//import com.cpt.payments.pojo.Payment;

import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.dto.TransactionResponseDTO;

public interface PaymentStatusService {
    public TransactionResponseDTO processStatus(TransactionDTO payment);

}
