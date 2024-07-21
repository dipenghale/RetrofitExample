package com.abhiandroid.retrofitexample;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    Context context;
    List<UserListResponse> userListResponseData;

    public UsersAdapter(Context context, List<UserListResponse> userListResponseData) {
        this.userListResponseData = userListResponseData;
        this.context = context;
    }

    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.users_list_items, null);
        UsersViewHolder usersViewHolder = new UsersViewHolder(view);
        return usersViewHolder;
    }

    @Override
    public void onBindViewHolder(UsersViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        // set the data
        holder.id.setText("ID: " + userListResponseData.get(position).getId());
        holder.name.setText("Name: " + userListResponseData.get(position).getName());
        holder.email.setText("Email: " + userListResponseData.get(position).getEmail());
        // implement setONCLickListtener on itemView
        holder.itemView.setOnClickListener(v-> {

                // display a toast with user name
                Toast.makeText(context, "ID: "+userListResponseData.get(position).getId(), Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(context, UserDetail.class);
                myIntent.putExtra("address_id", userListResponseData.get(position).getId()); //Optional parameters
                myIntent.putExtra("name", userListResponseData.get(position).getName()); //Optional parameters
                myIntent.putExtra("email", userListResponseData.get(position).getEmail()); //Optional parameters
                myIntent.putExtra("city", userListResponseData.get(position).getCity()); //Optional parameters
                myIntent.putExtra("street", userListResponseData.get(position).getStreet()); //Optional parameters
                myIntent.putExtra("phone", userListResponseData.get(position).getPhone()); //Optional parameters
                myIntent.putExtra("updated_at", userListResponseData.get(position).getUpdated_date()); //Optional parameters
                context.startActivity(myIntent);


        });
    }

    @Override
    public int getItemCount() {
        return userListResponseData.size(); // size of the list items
    }

    class UsersViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView id, name, email;

        public UsersViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
        }
    }
}
