package com.example.springreactiveconsumer.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;
import lombok.Value;

@Data
public class CustomerModel {
    String customerId;
    String companyName;
    String companyEmail;
    String taxId;

    AddressModel billingAddress;
//    AddressModel shippingAddress;


    public CustomerModel() {
    }

    public CustomerModel(String customerId, String companyName, String companyEmail, String taxId, AddressModel billingAddress) {
        this.customerId = customerId;
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.taxId = taxId;
        this.billingAddress = billingAddress;
//        this.shippingAddress = shippingAddress;
    }
}
