package com.netflix.price.hibernate.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "USER_PLAN", schema = "nflx", catalog = "")
public class UserPlanEntity {
private int userid;
private String countryid;
private BigDecimal price;
private String planid;

@Id
@Column(name = "USERID")
@GeneratedValue(strategy = GenerationType.IDENTITY)
public int getUserid() {
    return userid;
}

public void setUserid(int userid) {
    this.userid = userid;
}

@Basic
@Column(name = "COUNTRYID")
public String getCountryid() {
    return countryid;
}

public void setCountryid(String countryid) {
    this.countryid = countryid;
}

@Basic
@Column(name = "PRICE")
public BigDecimal getPrice() {
    return price;
}

public void setPrice(BigDecimal price) {
    this.price = price;
}

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserPlanEntity that = (UserPlanEntity) o;

    if (userid != that.userid) return false;
    if (countryid != null ? !countryid.equals(that.countryid) : that.countryid != null) return false;
    if (price != null ? !price.equals(that.price) : that.price != null) return false;

    return true;
}

@Override
public int hashCode() {
    int result = userid;
    result = 31 * result + (countryid != null ? countryid.hashCode() : 0);
    result = 31 * result + (price != null ? price.hashCode() : 0);
    return result;
}

@Basic
@Column(name = "PLANID")
public String getPlanid() {
    return planid;
}

public void setPlanid(String planid) {
    this.planid = planid;
}
}
