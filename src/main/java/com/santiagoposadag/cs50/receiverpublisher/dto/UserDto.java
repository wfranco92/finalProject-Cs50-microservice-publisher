package com.santiagoposadag.cs50.receiverpublisher.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    private String nameUser;
    private String lastNameUser;
    private String DNIUser;
    private String routingKey;
}
