package com.jitterpig.demo;

/**
 *
 */
public class AddressImpl implements Address {
  private String _streetAddress;
  private String _city;
  private State _state;
  private String _postalCode;
  private PolicyType _policyType;

  public AddressImpl() {
  }

  public AddressImpl(String city, String postalCode, State state, String streetAddress, PolicyType policyType) {
    _city = city;
    _postalCode = postalCode;
    _state = state;
    _streetAddress = streetAddress;
    _policyType = policyType;
  }

  public String getCity() {
    return _city;
  }

  public String getPostalCode() {
    return _postalCode;
  }

  public State getState() {
    return _state;
  }

  public String getStreetAddress() {
    return _streetAddress;
  }

  public void setCity(String city) {
    _city = city;
  }

  public void setPostalCode(String postalCode) {
    _postalCode = postalCode;
  }

  public void setState(State state) {
    _state = state;
  }

  public void setStreetAddress(String streetAddress) {
    _streetAddress = streetAddress;
  }

  public PolicyType getPolicyType() {
    return _policyType;
  }

  public void setPolicyType(PolicyType policyType) {
    _policyType = policyType;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("AddressImpl: ");
    sb.append("{city='").append(_city).append('\'');
    sb.append(", streetAddress='").append(_streetAddress).append('\'');
    sb.append(", state=").append(_state);
    sb.append(", postalCode='").append(_postalCode).append('\'');
    sb.append(", policyType=").append(_policyType);
    sb.append('}');
    return sb.toString();
  }
}
