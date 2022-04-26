package com.example.sleephabit.authentication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sleephabit.R;
import com.example.sleephabit.model.User;
import com.example.sleephabit.retrofit.RetrofitService;
import com.example.sleephabit.retrofit.UserApi;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    Button register;
    EditText inputUserName,inputEmail,inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initializeComponents();

    }

    private void initializeComponents() {

        register = findViewById(R.id.register);
        inputUserName = findViewById(R.id.username);
        inputPassword = findViewById(R.id.password);
        inputEmail = findViewById(R.id.email);

        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);

        register.setOnClickListener(view -> {
              String username = String.valueOf(inputUserName.getText());
              String email = String.valueOf(inputEmail.getText());
              String password = String.valueOf(inputPassword.getText());

              User user = new User();
              user.setUserName(username);
              user.setPassword(password);
              user.setEmail(email);

              userApi.save(user)
                      .enqueue(new Callback<User>() {
                          @Override
                          public void onResponse(Call<User> call, Response<User> response){
                              Toast.makeText(RegisterActivity.this, "Save Successfull!", Toast.LENGTH_SHORT).show();
                          }

                          @Override
                          public void onFailure(Call<User> call, Throwable t ){
                              Toast.makeText(RegisterActivity.this, "Save Failed!", Toast.LENGTH_SHORT).show();
                              Logger.getLogger(RegisterActivity.class.getName()).log(Level.SEVERE, "Error occurred", t);
                          }

                      });
        });
    }
}