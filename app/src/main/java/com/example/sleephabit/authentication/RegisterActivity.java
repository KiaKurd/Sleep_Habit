package com.example.sleephabit.authentication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sleephabit.R;
import com.example.sleephabit.model.Login;

public class RegisterActivity extends AppCompatActivity {
    Button register;
    EditText username,email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Login login = new Login();

        register = findViewById(R.id.register);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);

        register.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v){
             login.setUsername(username.getText().toString());
             login.setPassword(password.getText().toString());
             login.setEmail(email.getText().toString());

             login.save();

               Toast.makeText(RegisterActivity.this, "email:" +email + "password:" + password, Toast.LENGTH_LONG).show();
           }
        });



    }
}