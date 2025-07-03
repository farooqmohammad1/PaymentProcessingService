package com.cpt.payments.pojo;

import lombok.Data;

import java.util.List;

@Data
public class InitiatedPaymentReq {

    //this comes from client
   private List<LineItem> lineItemList;
   private String successUrl;
   private String cancelUrl;
}
