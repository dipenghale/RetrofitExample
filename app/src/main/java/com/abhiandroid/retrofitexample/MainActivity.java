package com.abhiandroid.retrofitexample;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<UserListResponse> userListResponseData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        getUserListData(); // call a method in which we have implemented our GET type web API
        Button ca = findViewById(R.id.createadd);
        ca.setOnClickListener(v-> {
                Intent intent = new Intent(MainActivity.this,CreateNewAddress.class);
                startActivity(intent);
        });
    }

    private void getUserListData() {

        // Api is a class in which we define a method getClient() that returns the API Interface class object
        // getUsersList() is a method in API Interface class, in this method we define our API sub url
        Api.getClient().getUsersList(new Callback<List<UserListResponse>>() {
            @Override
            public void success(List<UserListResponse> userListResponses, Response response) {
                // in this method we will get the response from API
                userListResponseData = userListResponses;
                setDataInRecyclerView(); // call this method to set the data in adapter
            }

            @Override
            public void failure(RetrofitError error) {
                // if error occurs in network transaction then we can get the error in this method.
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();


            }
        });
    }

    private void setDataInRecyclerView() {
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        // call the constructor of UsersAdapter to send the reference and data to Adapter
        UsersAdapter usersAdapter = new UsersAdapter(MainActivity.this, userListResponseData);
        recyclerView.setAdapter(usersAdapter); // set the Adapter to RecyclerView
    }
}
