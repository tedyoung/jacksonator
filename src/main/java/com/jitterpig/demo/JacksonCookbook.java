package com.jitterpig.demo;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

/**
 *
 */
/*
{"title":"The Jackson Cookbook","subtitle":"JSON Recipes in Java",
"author":{"name":{"first":"Ted","middle":"M","last":"Young"},
"twitterId":"@jitterted","website":"http://about.me/tedmyoung"},
"url":"https://leanpub.com/jacksoncookbook","language":"English",
"version":"0.1"}
*/
interface Book {
  public Author getAuthor();

  public String getLanguage();

  public String getSubtitle();

  public String getTitle();

  public String getUrl();

  public String getVersion();
}

class JacksonCookbook implements Book {

  public static void main(String[] args) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

    Address address = new AddressImpl("Foster City", "94404", new State("California", "CA", "California"), "1001 E. Hillsdale Blvd.", new PolicyType("Personal Auto", "PersonalAuto", "Personal Auto Line"));
    String addressJson = objectMapper.writeValueAsString(address);
    System.out.println(addressJson);

    System.out.println("\nDeserializing Address from JSON:");
    AddressImpl addressFromJson = objectMapper.readValue(addressJson, AddressImpl.class);
    System.out.println(addressFromJson);
  }

  public class ModifiedPrettyPrinter extends DefaultPrettyPrinter {
    @Override
    public void writeObjectFieldValueSeparator(JsonGenerator jg)
            throws IOException {
      if (_spacesInObjectEntries) {
        jg.writeRaw(": ");
      } else {
        jg.writeRaw(':');
      }
    }
  }


  private String title = "The Jackson Cookbook";
  private String subtitle = "JSON Recipes in Java";
  private Author author = new Author();
  private String url = "https://leanpub.com/jacksoncookbook";
  private String language = "English";
  private String version = "0.1";

  public Author getAuthor() {
    return author;
  }

  public String getLanguage() {
    return language;
  }

  public String getSubtitle() {
    return subtitle;
  }

  public String getTitle() {
    return title;
  }

  public String getUrl() {
    return url;
  }

  public String getVersion() {
    return version;
  }
}

class Author {
  public Name name = new Name();
  public String twitterId = "@jitterted";
  public String website = "http://about.me/tedmyoung";
}

class Name {
  public String first = "Ted";
  public String middle = "M";
  public String last = "Young";
}

