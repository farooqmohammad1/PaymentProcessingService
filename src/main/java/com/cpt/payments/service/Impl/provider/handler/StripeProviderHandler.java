package com.cpt.payments.service.Impl.provider.handler;

import com.cpt.payments.dto.InitiatedPaymentReqDTO;
import com.cpt.payments.dto.InitiatedPaymentResDTO;
import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.service.http.HttpClientService;
import com.cpt.payments.service.interfaces.ProviderHandler;
import com.cpt.payments.stripeprovider.CreatePaymentReq;
import com.cpt.payments.stripeprovider.CreatePaymentRes;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class StripeProviderHandler implements ProviderHandler {

    private final HttpClientService httpClientService;
    @Autowired
    private ModelMapper modelMapper;
    @Value("${stripe.payment.url}")
    private String stripePaymentUrl;
    @Autowired
    private Gson gson;

    public StripeProviderHandler(HttpClientService httpClientService) {
        this.httpClientService = httpClientService;
    }

    @Override
    public InitiatedPaymentResDTO processPayment(TransactionDTO txn, InitiatedPaymentReqDTO req) {
        //here we make HTTP call to Stripe service which calls Stripe Provider

        CreatePaymentReq paymentReqreq= modelMapper.map(req,CreatePaymentReq.class);
        paymentReqreq.setTxnRef(txn.getTxnReference());
        String response= httpClientService.sendRequest(
                stripePaymentUrl,  // base URL
                "",                      // endpoint
                HttpMethod.POST,          // method
                paymentReqreq,                      // request payload
                String.class);
       System.out.println("Repsonse after stripe api call"+response);
       CreatePaymentRes resObj = gson.fromJson(response, CreatePaymentRes.class);
       InitiatedPaymentResDTO resDTO=modelMapper.map(resObj, InitiatedPaymentResDTO.class);
       resDTO.setTxnReference(txn.getTxnReference());



       return resDTO;
    }
}
