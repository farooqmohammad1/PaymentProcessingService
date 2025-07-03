package com.cpt.payments.service.Impl;

import com.cpt.payments.constants.ProviderEnum;
import com.cpt.payments.dao.impl.TransactionDaoImpl;
import com.cpt.payments.dao.interfaces.TransactionDao;
import com.cpt.payments.dto.InitiatedPaymentReqDTO;
import com.cpt.payments.dto.InitiatedPaymentResDTO;
import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.service.factory.ProviderHandlerFactory;
import com.cpt.payments.service.interfaces.PaymentService;
import com.cpt.payments.service.interfaces.ProviderHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.cpt.payments.constants.ProviderEnum.fromName;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    TransactionDao transactionDao;
    @Autowired
    ProviderHandlerFactory providerHandlerFactory;
    @Override
    public InitiatedPaymentResDTO initiatePayment(InitiatedPaymentReqDTO reqDTO) {
        //for now we have id and some other data
        //we need txnReference,provider etc.. so fetch from Dao
        //get TransactionDTO object by ID
        TransactionDTO txnObj= transactionDao.getTransactionById(reqDTO.getId());
        System.out.println("After fetching from DB"+txnObj);
        ProviderEnum provider=ProviderEnum.fromName(txnObj.getProviderName());
        System.out.println("Provider"+provider);
        ProviderHandler getProviderObj=providerHandlerFactory.getProviderHandler(provider);
        System.out.println("getProviderObk"+getProviderObj);
        getProviderObj.processPayment(txnObj,reqDTO);
        InitiatedPaymentResDTO responseDTO = new InitiatedPaymentResDTO();

        responseDTO.setUrl("SUCCESS"); // Or based on actual result

        return responseDTO;
    }
}
