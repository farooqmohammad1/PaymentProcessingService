package com.cpt.payments.service.factory;

import com.cpt.payments.constants.TransactionStatusEnum;
import com.cpt.payments.service.Impl.Handler.CreatedStatusHandler;
import com.cpt.payments.service.interfaces.PaymentStatusHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class PaymentStatusFactory {

    @Autowired
    private ApplicationContext ctx;

    public PaymentStatusHandler getHandler(TransactionStatusEnum status) {
        switch (status) {
            case CREATED -> {
                return ctx.getBean("createdStatusHandler", CreatedStatusHandler.class);
            }
            // You can add more cases for other statuses later
            default -> {
                return null;
            }
        }
    }
}
