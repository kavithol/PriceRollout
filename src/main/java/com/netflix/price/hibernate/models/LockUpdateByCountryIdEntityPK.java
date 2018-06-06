package com.netflix.price.hibernate.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class LockUpdateByCountryIdEntityPK implements Serializable {
private String countryId;
private String planId;

@Column(name = "CountryID")
@Id
public String getCountryId() {
    return countryId;
}

public void setCountryId(String countryId) {
    this.countryId = countryId;
}

@Column(name = "planID")
@Id
public String getPlanId() {
    return planId;
}

public void setPlanId(String planId) {
    this.planId = planId;
}

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    LockUpdateByCountryIdEntityPK that = (LockUpdateByCountryIdEntityPK) o;

    if (countryId != null ? !countryId.equals(that.countryId) : that.countryId != null) return false;
    if (planId != null ? !planId.equals(that.planId) : that.planId != null) return false;

    return true;
}

@Override
public int hashCode() {
    int result = countryId != null ? countryId.hashCode() : 0;
    result = 31 * result + (planId != null ? planId.hashCode() : 0);
    return result;
}
}
