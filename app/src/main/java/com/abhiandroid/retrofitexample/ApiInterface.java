package com.abhiandroid.retrofitexample;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;


public interface ApiInterface {

    // API's endpoints
    @GET("/addressapi/getaddress.php")
    void getUsersList(
            Callback<List<UserListResponse>> callback);

/*
    //Callback<List<UserListResponse>> CreateAddress(@Body AddressRequest AddressRequest);
    @POST("/addressapi/createaddress.php")
    //@FormUrlEncoded
    void createnewadd(@Body Callback<List<UserListResponse>> addressRequest);

@Headers({

        "Content-type: application/json"

})
@POST("/addressapi/createaddress.php")
 void saveAdd(@Body Callback<AddressRequest> addressRequest); */
    @FormUrlEncoded
    @POST("/addressapi/createaddress.php")
    void saveAdd(@Field("name") String name,
                                    @Field("phone") String phone,
                                    @Field("email") String email,
                                       @Field("city") String city,
                                       @Field("street") String street, Callback<AddressRequest> callback);

    @FormUrlEncoded
    @POST("/addressapi/updateaddress.php")
    void editAdd(@Field("id") String id,
                 @Field("name") String name,
                 @Field("phone") String phone,
                 @Field("email") String email,
                 @Field("city") String city,
                 @Field("street") String street, Callback<UpdateAddress> callback);



    @GET("/addressapi/deleteaddress.php")
    void delAdd(@Query("id") String id,
            Callback<UpdateAddress> callback);
    //Callback<List<UserListResponse>> callback);

// UserListResponse is POJO class to get the data from API, In above method we use List<UserListResponse> because the data in our API is starting from JSONArray

}
