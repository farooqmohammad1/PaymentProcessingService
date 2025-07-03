package com.cpt.payments.stripeprovider;

import com.cpt.payments.pojo.LineItem;
import lombok.Data;

import java.util.List;

@Data
public class CreatePaymentReq {
    //this is coming from validation
    private String txnRef;
    //this comes from client
   private List<LineItem> lineItemList;
   private String successUrl;
   private String cancelUrl;
}
