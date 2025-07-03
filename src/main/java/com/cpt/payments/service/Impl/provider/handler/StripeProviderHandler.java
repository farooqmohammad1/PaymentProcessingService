package com.cpt.payments.service.Impl.provider.handler;

import com.cpt.payments.dto.InitiatedPaymentReqDTO;
import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.service.http.HttpClientService;
import com.cpt.payments.service.interfaces.ProviderHandler;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class StripeProviderHandler implements ProviderHandler {

    private final HttpClientService httpClientService;

    public StripeProviderHandler(HttpClientService httpClientService) {
        this.httpClientService = httpClientService;
    }

    @Override
    public String processPayment(TransactionDTO txn, InitiatedPaymentReqDTO req) {
        //here we make HTTP call to Stripe service which calls Stripe Provider
        String url = "v1/payments"+txn.getId()+"/initiate";

        return httpClientService.sendRequest(
                "http://localhost:8082",  // base URL
                url,                      // endpoint
                HttpMethod.POST,          // method
                req,                      // request payload
                String.class              // response expected
        );
    }
}
