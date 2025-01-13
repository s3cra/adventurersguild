package ru.adventurersguild.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;

import api.GuildAPI;
import api.Retro;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.adventurersguild.R;
import ru.adventurersguild.stuff.User;

public class SigninActivity extends AppCompatActivity {
    GuildAPI api = Retro.api;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_page);

    }

    public void validateUserData(View view) {
        TextInputEditText loginHolder = findViewById(R.id.login);
        TextInputEditText passwordHolder = findViewById(R.id.password);
        String login = loginHolder.getText().toString();
        String password = passwordHolder.getText().toString();
        Retro.user = new User(login, password);
        api.signIn(Retro.user).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                 if(response.body() != null) {
                     try {
                         Retro.token = response.body().string();
                         System.out.println(Retro.token);
                         toHome(findViewById(android.R.id.content));
                     } catch (IOException e) {
                         throw new RuntimeException(e);
                     }
                 } else {
                     Snackbar.make(findViewById(android.R.id.content), "Wrong login or password.", Snackbar.LENGTH_LONG).show();
                 }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                Snackbar.make(findViewById(android.R.id.content), "Connection issue.", Snackbar.LENGTH_LONG).show();
            }
        });

    }

    public void toHome(View view){
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }
}
