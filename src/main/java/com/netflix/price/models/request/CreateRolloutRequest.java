package com.netflix.price.models.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


public class CreateRolloutRequest implements Serializable {
@ApiModelProperty(notes = "Country Id for the price rollout")
    String countryId;
@ApiModelProperty(notes = "Plan Id for the price rollout")
    String planId;
@ApiModelProperty(notes = "Price in double for the price rollout")
    Double price;

public String getCountryId() {
    return countryId;
}

public void setCountryId(String countryId) {
    this.countryId = countryId;
}

public String getPlanId() {
    return planId;
}

public void setPlanId(String planId) {
    this.planId = planId;
}

public Double getPrice() {
    return price;
}

public void setPrice(Double price) {
    this.price = price;
}
}
