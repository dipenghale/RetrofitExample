
package com.abhiandroid.retrofitexample;

import java.util.HashMap;
import java.util.Map;

public class UserListResponse {

    // POJO class to get the data from web api
private String id;
private String name;
private String email;
private String phone;
private String city;
private String street;
private String status;
private String updated_date;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getPhone() {
return phone;
}

public void setPhone(String phone) {
this.phone = phone;
}

public String getCity() {
return city;
}

public void setCity(String city) {
this.city = city;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public String getStreet() {
return street;
}

public void setStreet(String street) {
this.street = street;
}

public String getUpdated_date() {
return updated_date;
}

public void setUpdated_date(String updated_date) {
this.updated_date = updated_date;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}