package com.abhiandroid.retrofitexample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserDetail extends AppCompatActivity {
    Button sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address_detail);
        Intent intent = getIntent();
        final String address_id = intent.getStringExtra("address_id"); //if it's a string you stored.
        final String a_name = intent.getStringExtra("name"); //if it's a string you stored.
        final String a_email = intent.getStringExtra("email"); //if it's a string you stored.
        final String a_phone = intent.getStringExtra("phone"); //if it's a string you stored.
        final String a_city = intent.getStringExtra("city"); //if it's a string you stored.
        final String a_street = intent.getStringExtra("street"); //if it's a string you stored.
        String up_ad = intent.getStringExtra("updated_at"); //if it's a string you stored.
        TextView id = findViewById(R.id.id);
        TextView name = findViewById(R.id.name);
        TextView email = findViewById(R.id.email);
        TextView phone = findViewById(R.id.phone);
        TextView city = findViewById(R.id.city);
        TextView street = findViewById(R.id.street);
        TextView updated_at = findViewById(R.id.updated_at);

        id.setText("ID: "+address_id);
        name.setText("Name: "+a_name);
        email.setText("Email: "+a_email);
        phone.setText("Phone: "+a_phone);
        city.setText("City: "+a_city);
        street.setText("Street: "+a_street);
        updated_at.setText("Updated At: "+up_ad);

        sa = findViewById(R.id.edit_add);
        sa.setOnClickListener(v-> {

                Intent myIntent = new Intent(UserDetail.this, EditAddress.class);
                myIntent.putExtra("id", address_id); //Optional parameters
                myIntent.putExtra("name", a_name); //Optional parameters
                myIntent.putExtra("email", a_email); //Optional parameters
                myIntent.putExtra("city", a_city); //Optional parameters
                myIntent.putExtra("street",a_street); //Optional parameters
                myIntent.putExtra("phone", a_phone); //Optional parameters
                startActivity(myIntent);
                finish();


        });


    }
}
