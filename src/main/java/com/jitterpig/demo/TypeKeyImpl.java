package com.jitterpig.demo;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
//@JsonSubTypes({@JsonSubTypes.Type(State.class), @JsonSubTypes.Type(PolicyType.class)})
public class TypeKeyImpl implements TypeKey {
  String _name;
  String _displayName;
  String _code;

  public TypeKeyImpl(String name, String code, String displayName) {
    System.out.println("Creating TypeKeyImpl: name=" + name + ", code=" + code);
    _name = name;
    _displayName = displayName;
    _code = code;
  }

  public String getCode() {
    return _code;
  }

  public void setCode(String code) {
    _code = code;
  }

  public String getDisplayName() {
    return _displayName;
  }

  public void setDisplayName(String displayName) {
    _displayName = displayName;
  }

  public String getName() {
    return _name;
  }

  public void setName(String name) {
    _name = name;
  }

  @Override
  public String toString() {
    return getDisplayName();
  }
}
