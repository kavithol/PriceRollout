package com.netflix.price.models.response;

import io.swagger.annotations.ApiModelProperty;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class CreateRolloutResponse implements Serializable {
@ApiModelProperty(notes = "Rollout Id created for the price rollout")
    int rolloutId;
@ApiModelProperty(notes="Errors, if not null then the rollout is not successful")
    List<String> error;
@ApiModelProperty(notes="Warnings, if not null then the rollout is created successfully, but the request had some fixable issues")
    List<String> warnings;

public int getRolloutId() {
    return rolloutId;
}

public void setRolloutId(int rolloutId) {
    this.rolloutId = rolloutId;
}

public List<String> getError() {
    return error;
}

public void setError(List<String> error) {
    this.error = error;
}

public List<String> getWarnings() {
    return warnings;
}

public void setWarnings(List<String> warnings) {
    this.warnings = warnings;
}
}
