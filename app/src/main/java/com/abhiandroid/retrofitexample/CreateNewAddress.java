package com.abhiandroid.retrofitexample;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class CreateNewAddress extends AppCompatActivity {
    TextView name,email,phone,city,street;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_address);
        TextView n = findViewById(R.id.name);
        TextView e = findViewById(R.id.email);
        TextView p = findViewById(R.id.phone);
        TextView c = findViewById(R.id.city);
        TextView s = findViewById(R.id.street);
        name = n;
        email = e;
        phone = p;
        city = c;
        street = s;
        //TextView updated_at = findViewById(R.id.updated_at);
        Button sa = findViewById(R.id.saveadd);
        sa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveAddress(createRequest());

            }
        });


    }

    public AddressRequest createRequest(){
        AddressRequest AddressRequest=new AddressRequest();
        AddressRequest.setName(name.getText().toString());
        AddressRequest.setEmail(email.getText().toString());
        AddressRequest.setPhone(phone.getText().toString());
        AddressRequest.setCity(city.getText().toString());
        AddressRequest.setStreet(street.getText().toString());
        return AddressRequest;

    }

    public void saveAddress(AddressRequest request){

        Api.getClient().saveAdd(request.getName(),
                request.getPhone(),request.getEmail(),request.getCity(),request.getStreet()
                , new Callback<AddressRequest>() {
                    @Override
                    public void success(AddressRequest addressRequest, Response response) {
                        // in this method we will get the response from API
                        // in this method we will get the response from API
                        Intent intent = new Intent(CreateNewAddress.this,MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        // if error occurs in network transaction then we can get the error in this method.
                        Toast.makeText(CreateNewAddress.this, error.toString(), Toast.LENGTH_LONG).show();


                    }
                });
        /*

        Api.getClient().saveAdd(new Callback<AddressRequest>() {

            @Override
            public void success(AddressRequest addressRequest, Response response) {
                // in this method we will get the response from API
                Intent intent = new Intent(CreateNewAddress.this,MainActivity.class);
                startActivity(intent);

            }

            @Override
            public void failure(RetrofitError error) {
                // if error occurs in network transaction then we can get the error in this method.
                Toast.makeText(CreateNewAddress.this, error.toString(), Toast.LENGTH_LONG).show();

            }
        });*/
    }
}
