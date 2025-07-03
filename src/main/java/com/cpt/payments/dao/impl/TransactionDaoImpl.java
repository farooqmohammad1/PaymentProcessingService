package com.cpt.payments.dao.impl;

import com.cpt.payments.dao.interfaces.TransactionDao;
import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.entity.TransactionEntity;
import com.cpt.payments.repository.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionDaoImpl implements TransactionDao {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public TransactionDTO createTransaction(TransactionDTO txnDTO) {

        TransactionEntity entity = modelMapper.map(txnDTO, TransactionEntity.class);
        System.out.println(entity);
        TransactionEntity savedEntity = transactionRepository.save(entity);


        return modelMapper.map(savedEntity, TransactionDTO.class);

    }

    @Override
    public TransactionDTO getTransactionById(int id) {
       TransactionEntity entity= transactionRepository.findById(id)
                             .orElseThrow(()->new RuntimeException("Transaction not found"));


        return modelMapper.map(entity, TransactionDTO.class);
    }
}
