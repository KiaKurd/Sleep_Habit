package com.example.sleephabit.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sleephabit.R;
import com.example.sleephabit.model.User;
import com.example.sleephabit.navigator.BottomNav;
import com.example.sleephabit.retrofit.RetrofitService;
import com.example.sleephabit.retrofit.UserApi;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initializeComponents();
    }


    private void initializeComponents(){

        Button login, register;
        EditText inputEmail, inputPassword;

        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        inputEmail = findViewById(R.id.email);
        inputPassword = findViewById(R.id.password);

        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);

        login.setOnClickListener(view -> {
            if (checkDataEntered(inputEmail, inputPassword)) {

            String email = String.valueOf(inputEmail.getText());
            String password = String.valueOf(inputPassword.getText());

            User user = new User();
            String checkEmail = user.getEmail();
            String checkPassword = user.getPassword();

            if (checkPassword == password && checkEmail == email){
                Intent intent = new Intent(LoginActivity.this, BottomNav.class );
                startActivity(intent);
                Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(LoginActivity.this, "Email or Password is wrong", Toast.LENGTH_SHORT).show();
            }
        }});

        register.setOnClickListener(View ->{
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    private Boolean checkDataEntered(EditText email,EditText password){
        Boolean boo;
        if ( TextUtils.isEmpty(email.getText().toString()) || !(Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) ) {
            Toast.makeText(LoginActivity.this, "Unvalid Email", Toast.LENGTH_SHORT).show();
            boo = false;
        }else if (TextUtils.isEmpty(password.getText().toString())){
            Toast.makeText(LoginActivity.this, "password is required", Toast.LENGTH_SHORT).show();
            boo = false;
        }else boo = true;

        return boo;
    }
}

