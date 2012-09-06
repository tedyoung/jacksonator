package com.jitterpig.demo;

/**
 *
 */
public interface Address {
  String getStreetAddress();

  String getCity();

  State getState();

  String getPostalCode();

  PolicyType getPolicyType();
}
