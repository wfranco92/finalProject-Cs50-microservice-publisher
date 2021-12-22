package com.santiagoposadag.cs50.receiverpublisher.helpers.enums;

public enum EnumTypeOfActions {
    BUY("BUY"),
    SELL("SELL");

    private String type;

    EnumTypeOfActions(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
