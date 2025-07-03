package com.cpt.payments.service.factory;

import com.cpt.payments.constants.ProviderEnum;
import com.cpt.payments.service.Impl.provider.handler.StripeProviderHandler;
import com.cpt.payments.service.interfaces.ProviderHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ProviderHandlerFactory {
    @Autowired
    ApplicationContext app;

    public ProviderHandler getProviderHandler(ProviderEnum providerEnum){
        switch(providerEnum){
            case STRIPE -> {
                return app.getBean(StripeProviderHandler.class);
            }
            default ->{
                return null;
            }
        }


    }
}
