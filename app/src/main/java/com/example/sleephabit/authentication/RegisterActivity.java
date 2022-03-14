package com.example.sleephabit.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sleephabit.R;
import com.example.sleephabit.model.login;

public class RegisterActivity extends AppCompatActivity {
    Button register;
    EditText username,email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        login log = new login(email, password, username);

        register = findViewById(R.id.register);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);

        register.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v){
             log.username = username.getText().toString();
             log.password = password.getText().toString();
             log.email = email.getText().toString();

               Toast.makeText(RegisterActivity.this, "email:" +email + "password:" + password, Toast.LENGTH_LONG).show();
           }
        });



    }
}