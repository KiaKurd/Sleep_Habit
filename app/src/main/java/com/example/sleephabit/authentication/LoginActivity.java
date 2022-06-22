package com.example.sleephabit.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sleephabit.ExceptionHandler.ExceptionHandler;
import com.example.sleephabit.R;
import com.example.sleephabit.model.User;
import com.example.sleephabit.navigator.BottomNav;
import com.example.sleephabit.retrofit.RetrofitService;
import com.example.sleephabit.retrofit.UserApi;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));


        initializeComponents();
    }


    private void initializeComponents(){

        Button login, register;

        login = findViewById(R.id.login);
        register = findViewById(R.id.register);


        login.setOnClickListener(view -> {
            loginUser();
           });

        register.setOnClickListener(View ->{
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    private void loginUser(){

        EditText inputEmail, inputPassword;

        inputEmail = findViewById(R.id.email);
        inputPassword = findViewById(R.id.password);


        if (checkDataEntered(inputEmail, inputPassword)) {

            String email = String.valueOf(inputEmail);
            String password =String.valueOf(inputPassword);

            RetrofitService retrofitService = new RetrofitService();
            UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);
            userApi.getAllUsers().enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                    List<User> users = response.body();
//                    User user
                }

                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {

                }
            });

            User user = new User();
            String checkEmail = user.getEmail();
            String checkPassword = user.getPassword();

            if (checkPassword == password && checkEmail == email){
                Intent intent = new Intent(LoginActivity.this, BottomNav.class );
                startActivity(intent);
                Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(LoginActivity.this, "Email or Password is wrong", Toast.LENGTH_SHORT).show();
            } }
    }


    private boolean isEmailRight(EditText email) {
        if ( TextUtils.isEmpty(email.getText().toString()) || !(Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) ) {
            email.setError("Email is required");
            email.requestFocus();
            return false;
        }else return true;
    }

    private boolean isPasswordRight(EditText password){
        if (TextUtils.isEmpty(password.getText().toString())){
            Toast.makeText(LoginActivity.this, "password is required", Toast.LENGTH_SHORT).show();
           return false;}else return true;
    }

    private Boolean checkDataEntered(EditText email,EditText password){
        if (!(isEmailRight(email))){
           return false;
        }else return isPasswordRight(password);
    }


    public void onFailure(Call<ResponseBody> call, Throwable t){
        Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
    }

}

