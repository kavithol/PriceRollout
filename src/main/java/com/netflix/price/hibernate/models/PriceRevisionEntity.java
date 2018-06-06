package com.netflix.price.hibernate.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "PRICE_REVISION", schema = "nflx", catalog = "")
public class PriceRevisionEntity {
private int rolloutid;
private int revisionId;
private String countryid;
private BigDecimal oldprice;
private BigDecimal newprice;
private String planid;
private Timestamp updatedtime;

@Basic
@Column(name = "ROLLOUTID")
public int getRolloutid() {
    return rolloutid;
}

public void setRolloutid(int rolloutid) {
    this.rolloutid = rolloutid;
}

@Id
@Column(name = "REVISION_ID")
@GeneratedValue(strategy = GenerationType.IDENTITY)
public int getRevisionId() {
    return revisionId;
}

public void setRevisionId(int revisionId) {
    this.revisionId = revisionId;
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
@Column(name = "OLDPRICE")
public BigDecimal getOldprice() {
    return oldprice;
}

public void setOldprice(BigDecimal oldprice) {
    this.oldprice = oldprice;
}

@Basic
@Column(name = "NEWPRICE")
public BigDecimal getNewprice() {
    return newprice;
}

public void setNewprice(BigDecimal newprice) {
    this.newprice = newprice;
}

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PriceRevisionEntity that = (PriceRevisionEntity) o;

    if (rolloutid != that.rolloutid) return false;
    if (revisionId != that.revisionId) return false;
    if (countryid != null ? !countryid.equals(that.countryid) : that.countryid != null) return false;
    if (oldprice != null ? !oldprice.equals(that.oldprice) : that.oldprice != null) return false;
    if (newprice != null ? !newprice.equals(that.newprice) : that.newprice != null) return false;

    return true;
}

@Override
public int hashCode() {
    int result = rolloutid;
    result = 31 * result + revisionId;
    result = 31 * result + (countryid != null ? countryid.hashCode() : 0);
    result = 31 * result + (oldprice != null ? oldprice.hashCode() : 0);
    result = 31 * result + (newprice != null ? newprice.hashCode() : 0);
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

@Basic
@Column(name = "UPDATEDTIME")
public Timestamp getUpdatedtime() {
    return updatedtime;
}

public void setUpdatedtime(Timestamp updatedtime) {
    this.updatedtime = updatedtime;
}
}
