package com.santiagoposadag.cs50.receiverpublisher.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CryptoCurrencyDto {

    private String cryptoCurrencyName;
    private double price;
    private String dateOfAction;
    private String typeOfAction;
    private double quantity;
    private String userId;
}
