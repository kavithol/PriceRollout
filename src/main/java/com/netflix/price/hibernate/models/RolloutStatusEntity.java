package com.netflix.price.hibernate.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ROLLOUT_STATUS", schema = "nflx", catalog = "")
public class RolloutStatusEntity {
private int rolloutid;
private String status;
private String error;
private Timestamp updatedTime;

@Id
@Column(name = "ROLLOUTID")
@GeneratedValue(strategy = GenerationType.IDENTITY)
public int getRolloutid() {
    return rolloutid;
}

public void setRolloutid(int rolloutid) {
    this.rolloutid = rolloutid;
}

@Basic
@Column(name = "STATUS")
public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}

@Basic
@Column(name = "ERROR")
public String getError() {
    return error;
}

public void setError(String error) {
    this.error = error;
}

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    RolloutStatusEntity that = (RolloutStatusEntity) o;

    if (rolloutid != that.rolloutid) return false;
    if (status != null ? !status.equals(that.status) : that.status != null) return false;
    if (error != null ? !error.equals(that.error) : that.error != null) return false;

    return true;
}

@Override
public int hashCode() {
    int result = rolloutid;
    result = 31 * result + (status != null ? status.hashCode() : 0);
    result = 31 * result + (error != null ? error.hashCode() : 0);
    return result;
}

@Basic
@Column(name = "updatedTime")
public Timestamp getUpdatedTime() {
    return updatedTime;
}

public void setUpdatedTime(Timestamp updatedTime) {
    this.updatedTime = updatedTime;
}
}
