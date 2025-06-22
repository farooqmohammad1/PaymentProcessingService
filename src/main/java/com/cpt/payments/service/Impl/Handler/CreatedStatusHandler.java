package com.cpt.payments.service.Impl.Handler;


import com.cpt.payments.dao.interfaces.TransactionDao;
import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.service.interfaces.PaymentStatusHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreatedStatusHandler extends PaymentStatusHandler {
    @Autowired
    TransactionDao transactionDao;
    @Override
    public String processStatus(TransactionDTO payment) {
        System.out.println("CreatedStatusHandler"+payment);
       TransactionDTO res= transactionDao.createTransaction(payment);
       System.out.println("From Dao");
        return "This is from CreatedStatusHandler "+res;
    }
}
