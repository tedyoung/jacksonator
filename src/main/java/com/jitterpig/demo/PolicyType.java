package com.jitterpig.demo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("PolicyType")
public class PolicyType extends TypeKeyImpl {
  @JsonCreator
  public PolicyType(@JsonProperty("name") String name, @JsonProperty("code") String code, @JsonProperty("displayName") String displayName) {
    super(name, code, displayName);
  }
}
