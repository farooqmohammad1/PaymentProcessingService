package com.cpt.payments.service.Impl;


import com.cpt.payments.constants.TransactionStatusEnum;
import com.cpt.payments.dao.interfaces.TransactionDao;
import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.dto.TransactionResponseDTO;
import com.cpt.payments.service.factory.PaymentStatusFactory;
import com.cpt.payments.service.interfaces.PaymentStatusHandler;
import com.cpt.payments.service.interfaces.PaymentStatusService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PaymentStatusServiceImpl implements PaymentStatusService {
    @Autowired
    PaymentStatusFactory pf;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    TransactionDao transactionDao;


    @Override
    public TransactionResponseDTO processStatus(TransactionDTO payment) {

        TransactionStatusEnum transactionStatusEnum=TransactionStatusEnum.fromName(payment.getTxnStatus());
        PaymentStatusHandler p= pf.getHandler(transactionStatusEnum);
        String res= p.processStatus(payment);
        TransactionDTO savedDto=transactionDao.createTransaction(payment);
        return new TransactionResponseDTO(savedDto.getId(),savedDto.getTxnStatus());
    }
}
