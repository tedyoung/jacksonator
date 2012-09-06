package com.jitterpig.demo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("State")
public class State extends TypeKeyImpl {

//  @JsonCreator
//  public static State fromCode(@JsonProperty("code") String code) {
//    System.out.println("Creating State from Code: " + code);
//    return new State(code, code);
//  }

  @JsonCreator
  public State(@JsonProperty("name") String name, @JsonProperty("code") String code, @JsonProperty("displayName") String displayName) {
    super(name, code, displayName);
    System.out.println("Creating State: name=" + name + ", code=" + code + ", displayName=" + displayName);
  }
}
