package com.example.sleephabit.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sleephabit.R;
import com.example.sleephabit.model.login;


public class LoginActivity extends AppCompatActivity {
    Button login, register;
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        login log = new login(email,password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (email.getText().toString() == null || password.getText().toString() == null ){
                        Toast.makeText(LoginActivity.this, "email or password is required", Toast.LENGTH_LONG).show();
                }else{
                    if(email.getText().toString() == log.email & password.getText().toString() == log.password){
//                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                        startActivity(intent);

                    }else{
                        Toast.makeText(LoginActivity.this, "wrong eamil or password ",Toast.LENGTH_LONG).show();
                    }
                }
                email.getText().toString();
                password.getText().toString();
                Toast.makeText(LoginActivity.this, "email:" +email + "password:" + password, Toast.LENGTH_LONG).show();

            };
        });

        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });



    }


}

