/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demos.data;

import java.util.Objects;

/**
 *
 * @author chaks
 */
public class User {

  private String firstName;
  private String lastName;
  private Integer age;
  private String uid;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 97 * hash + Objects.hashCode(this.firstName);
    hash = 97 * hash + Objects.hashCode(this.lastName);
    hash = 97 * hash + Objects.hashCode(this.age);
    hash = 97 * hash + Objects.hashCode(this.uid);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final User other = (User) obj;
    if (!Objects.equals(this.firstName, other.firstName)) {
      return false;
    }
    if (!Objects.equals(this.lastName, other.lastName)) {
      return false;
    }
    if (!Objects.equals(this.uid, other.uid)) {
      return false;
    }
    if (!Objects.equals(this.age, other.age)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "User{" + "firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", uid=" + uid + '}';
  }

}
