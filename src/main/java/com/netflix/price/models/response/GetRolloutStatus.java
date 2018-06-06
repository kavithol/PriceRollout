package com.netflix.price.models.response;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Timestamp;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class GetRolloutStatus implements Serializable {
    int rolloutid;
    String status;
    String error;
    Timestamp rolloutStatuUpdateTime;

public int getRolloutid() {
    return rolloutid;
}

public void setRolloutid(int rolloutid) {
    this.rolloutid = rolloutid;
}

public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}

public String getError() {
    return error;
}

public void setError(String error) {
    this.error = error;
}

public Timestamp getRolloutStatuUpdateTime() {
    return rolloutStatuUpdateTime;
}

public void setRolloutStatuUpdateTime(Timestamp rolloutStatuUpdateTime) {
    this.rolloutStatuUpdateTime = rolloutStatuUpdateTime;
}
}
