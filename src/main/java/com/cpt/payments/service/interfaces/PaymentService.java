package com.cpt.payments.service.interfaces;

import com.cpt.payments.dto.InitiatedPaymentReqDTO;
import com.cpt.payments.dto.InitiatedPaymentResDTO;
import org.springframework.stereotype.Service;


public interface PaymentService {
    public InitiatedPaymentResDTO initiatePayment(InitiatedPaymentReqDTO reqDTO);

}
