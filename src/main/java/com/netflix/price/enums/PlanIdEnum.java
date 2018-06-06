package com.netflix.price.enums;

public enum PlanIdEnum {

    Plan1("1S"),
    Plan2("2S"),
    Plan3("3S");
String name;
        PlanIdEnum(String name){
        this.name = name;
        }
        public String getName(){
            return this.name;
        }
public static PlanIdEnum fromValue(String value) {
    for (PlanIdEnum identifier : PlanIdEnum.values()) {
        if (identifier != null && identifier.getName().equals(value)) {
            return identifier;
        }
    }
    return null;
}
}
