package com.example.hadri_santos.androidnetworking;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hadri_santos.androidnetworking.models.User;
import com.example.hadri_santos.androidnetworking.rest.JsonPlaceHolderApiInterface;
import com.example.hadri_santos.androidnetworking.rest.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        final EditText user_id = findViewById(R.id.user_id);
        EditText user_new_email = findViewById(R.id.email);
        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog dialog = ProgressDialog.show(EditUser.this, "", "loading...");
                JsonPlaceHolderApiInterface service = RestClient.getClient();

                Call<User> call = service.updateUser(Integer.parseInt(user_id.getEditableText().toString()), new User());

                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        dialog.dismiss();
                        if (response.isSuccessful()) {
                            Toast.makeText(EditUser.this, "User successfully updated", Toast.LENGTH_LONG);
                        }
                    }
                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(EditUser.this, "Error in request", Toast.LENGTH_LONG);
                    }
                });
            }
        });

    }
}
