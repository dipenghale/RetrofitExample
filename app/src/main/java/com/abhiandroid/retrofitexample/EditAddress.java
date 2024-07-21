package com.abhiandroid.retrofitexample;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class EditAddress extends AppCompatActivity {
    String myid,myname,myemail,myphone,mycity,mystreet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_address);
        Intent intent = getIntent();
        final String a_id = intent.getStringExtra("id"); //if it's a string you stored.
        final String a_name = intent.getStringExtra("name"); //if it's a string you stored.
        final String a_email = intent.getStringExtra("email"); //if it's a string you stored.
        final String a_phone = intent.getStringExtra("phone"); //if it's a string you stored.
        final String a_city = intent.getStringExtra("city"); //if it's a string you stored.
        final String a_street = intent.getStringExtra("street"); //if it's a string you stored.
        final TextView id = findViewById(R.id.id);
        final EditText name = findViewById(R.id.name);
        final EditText email = findViewById(R.id.email);
        final EditText phone = findViewById(R.id.phone);
        final EditText city = findViewById(R.id.city);
        final EditText street = findViewById(R.id.street);

        id.setText(a_id);
        name.setText(a_name);
        email.setText(a_email);
        phone.setText(a_phone);
        city.setText(a_city);
        street.setText(a_street);
        //TextView updated_at = findViewById(R.id.updated_at);

        Button sa = findViewById(R.id.update_add);
        sa.setOnClickListener(v-> {

                myid = id.getText().toString();
                myname = name.getText().toString();
                myemail = email.getText().toString();
                myphone = phone.getText().toString();
                mycity = city.getText().toString();
                mystreet = street.getText().toString();
                ediAddress(createUpdateRequest());

        });

        Button del = findViewById(R.id.delete_add);
        del.setOnClickListener(v-> {

            myid = id.getText().toString();
            Api.getClient().delAdd(myid
                    , new Callback<UpdateAddress>() {
                        @Override
                        public void success(UpdateAddress updateAddress, Response response) {
                            // in this method we will get the response from API
                            // in this method we will get the response from API
                            //Toast.makeText(EditAddress.this, response.toString(), Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(EditAddress.this,MainActivity.class);
                            startActivity(intent);
                            finish();


                        }

                        @Override
                        public void failure(RetrofitError error) {
                            // if error occurs in network transaction then we can get the error in this method.
                            Toast.makeText(EditAddress.this, error.toString(), Toast.LENGTH_LONG).show();


                        }
                    });

        });




    }

    public UpdateAddress createUpdateRequest(){
        UpdateAddress UpdateAddress=new UpdateAddress();
        UpdateAddress.setId(myid);
        UpdateAddress.setName(myname);
        UpdateAddress.setEmail(myemail);
        UpdateAddress.setPhone(myphone);
        UpdateAddress.setCity(mycity);
        UpdateAddress.setStreet(mystreet);
        return UpdateAddress;

    }

    public void ediAddress(UpdateAddress update){

        Api.getClient().editAdd(update.getId(),update.getName(),
                update.getPhone(),update.getEmail(),update.getCity(),update.getStreet()
                , new Callback<UpdateAddress>() {
                    @Override
                    public void success(UpdateAddress updateAddress, Response response) {
                        // in this method we will get the response from API
                        // in this method we will get the response from API
                        //Toast.makeText(EditAddress.this, response.toString(), Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(EditAddress.this,MainActivity.class);
                        startActivity(intent);
                        finish();


                    }

                    @Override
                    public void failure(RetrofitError error) {
                        // if error occurs in network transaction then we can get the error in this method.
                        Toast.makeText(EditAddress.this, error.toString(), Toast.LENGTH_LONG).show();


                    }
                });

    }
}
