package com.netflix.price.hibernate.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "LOCK_UPDATE_BY_COUNTRY_ID", schema = "nflx", catalog = "")
@IdClass(LockUpdateByCountryIdEntityPK.class)
public class LockUpdateByCountryIdEntity {
private String countryId;
private Timestamp lockedTime;
private int rolloutId;
private String planId;

@Id
@Column(name = "CountryID")
public String getCountryId() {
    return countryId;
}

public void setCountryId(String countryId) {
    this.countryId = countryId;
}

@Basic
@Column(name = "LOCKED_TIME")
public Timestamp getLockedTime() {
    return lockedTime;
}

public void setLockedTime(Timestamp lockedTime) {
    this.lockedTime = lockedTime;
}

@Basic
@Column(name = "ROLLOUT_ID")
public int getRolloutId() {
    return rolloutId;
}

public void setRolloutId(int rolloutId) {
    this.rolloutId = rolloutId;
}

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    LockUpdateByCountryIdEntity that = (LockUpdateByCountryIdEntity) o;

    if (rolloutId != that.rolloutId) return false;
    if (countryId != null ? !countryId.equals(that.countryId) : that.countryId != null) return false;
    if (lockedTime != null ? !lockedTime.equals(that.lockedTime) : that.lockedTime != null) return false;

    return true;
}

@Override
public int hashCode() {
    int result = countryId != null ? countryId.hashCode() : 0;
    result = 31 * result + (lockedTime != null ? lockedTime.hashCode() : 0);
    result = 31 * result + rolloutId;
    return result;
}

@Id
@Column(name = "planID")
public String getPlanId() {
    return planId;
}

public void setPlanId(String planId) {
    this.planId = planId;
}
}
