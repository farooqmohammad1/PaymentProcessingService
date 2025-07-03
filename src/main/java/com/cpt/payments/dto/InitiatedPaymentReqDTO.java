package com.cpt.payments.dto;

import com.cpt.payments.pojo.LineItem;
import lombok.Data;

import java.util.List;

@Data
public class InitiatedPaymentReqDTO {
    //in request we do not have id explicitly set in controller
    private int id;
    //this comes from client
   private List<LineItemDTO> lineItemList;
   private String successUrl;
   private String cancelUrl;
}
