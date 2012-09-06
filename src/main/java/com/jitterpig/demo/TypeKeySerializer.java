package com.jitterpig.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class TypeKeySerializer {
  public static void main(String[] args) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();

    PolicyType policyType = new PolicyType("name", "code", "display name");

    PolicyType[] policyTypes = new PolicyType[2];
    policyTypes[0] = policyType;
    policyTypes[1] = policyType;

    String json = objectMapper.writeValueAsString(policyTypes);
    System.out.println("Using array: " + json);

    List<PolicyType> policyTypeList = Arrays.asList(policyTypes);
    json = objectMapper.writeValueAsString(policyTypeList);
    System.out.println("Using generified List: " + json);

    CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, PolicyType.class);
    json = objectMapper.writerWithType(collectionType).writeValueAsString(policyTypeList);
    System.out.println("Using TypeFactory.constructCollectionType: " + json);

    json = objectMapper.writerWithType(new TypeReference<List<PolicyType>>() {
    }).writeValueAsString(policyTypeList);
    System.out.println("using TypeReference: " + json);

    PolicyTypesWrapper policyTypesWrapper = new PolicyTypesWrapper(policyTypeList);
    json = objectMapper.writeValueAsString(policyTypesWrapper);
    System.out.println("Using type wrapper: " + json);
  }

  static class PolicyTypesWrapper {
    private List<PolicyType> _policyTypes;

    PolicyTypesWrapper(@JsonProperty("policyTypes") List<PolicyType> policyTypes) {
      _policyTypes = policyTypes;
    }

    @JsonUnwrapped
    public List<PolicyType> getPolicyTypes() {
      return _policyTypes;
    }
  }

}
