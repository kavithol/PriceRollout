package com.netflix.price.enums;

public enum CountryIdEnum {

    US("US"),
    UK("UK"),
    IN("IN"),
    DE("DE"),
    AU("AU");
String name;
        CountryIdEnum(String name){
        this.name = name;
        }
        public String getName(){
            return this.name;
        }
public static CountryIdEnum fromValue(String value) {
    for (CountryIdEnum identifier : CountryIdEnum.values()) {
        if (identifier != null && identifier.getName().equals(value)) {
            return identifier;
        }
    }
    return null;
}
}
