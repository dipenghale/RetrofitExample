package com.abhiandroid.retrofitexample;
import java.util.HashMap;
import java.util.Map;

public class AddressRequest {

   // @SerializedName("name")
   // @Expose
    private String name;
   // @SerializedName("email")
   // @Expose
    private String email;
    //@SerializedName("phone")
    //@Expose
    private String phone;
   // @SerializedName("city")
   // @Expose
    private String city;
   // @SerializedName("street")
   // @Expose
    private String street;
   // private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }



/*

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
*/
    /*
    @Override
    public String toString() {
        return "Post{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", city=" + city +
                ", street=" + street +
                '}';
    }*/
}

