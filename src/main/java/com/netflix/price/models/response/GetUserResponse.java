package com.netflix.price.models.response;

import io.swagger.annotations.ApiModelProperty;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class GetUserResponse implements Serializable {
@ApiModelProperty(notes="User Id, database generated userid")
    int userId;
@ApiModelProperty(notes="Country Id")
    String countryId;
@ApiModelProperty(notes="Plan Id")
    String planId;
@ApiModelProperty(notes="Price in double")
    double price;

public int getUserId() {
    return userId;
}

public void setUserId(int userId) {
    this.userId = userId;
}

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

public double getPrice() {
    return price;
}

public void setPrice(double price) {
    this.price = price;
}
}
