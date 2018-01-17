package com.example.hadri_santos.androidnetworking;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hadri_santos.androidnetworking.models.User;
import com.example.hadri_santos.androidnetworking.rest.JsonPlaceHolderApiInterface;
import com.example.hadri_santos.androidnetworking.rest.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);

        final EditText user_id = findViewById(R.id.u_id);
        final TextView details = findViewById(R.id.user_data);
        ImageButton button = findViewById(R.id.search_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog dialog = ProgressDialog.show(SearchUser.this, "", "loading...");
                JsonPlaceHolderApiInterface service = RestClient.getClient();
                Call<User> call = service.getUserById(Integer.parseInt(user_id.getEditableText().toString()));

                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        dialog.dismiss();
                        if (response.isSuccessful()) {
                            User user = response.body();
                            details.setText(user.toString());
                        }
                    }
                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(SearchUser.this, "Error in request", Toast.LENGTH_LONG);
                    }
                });
            }
        });
    }
}
