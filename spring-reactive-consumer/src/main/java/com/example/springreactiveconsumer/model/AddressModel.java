package com.example.springreactiveconsumer.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Value;

@Data
public class AddressModel {
    String addressLine;
    String postalCode;
    String city;

    public AddressModel() {
    }

    public AddressModel(
            @JsonProperty("addressLine") String addressLine,
            @JsonProperty("postalCode") String postalCode,
            @JsonProperty("city") String city) {
        this.addressLine = addressLine;
        this.postalCode = postalCode;
        this.city = city;
    }
}
