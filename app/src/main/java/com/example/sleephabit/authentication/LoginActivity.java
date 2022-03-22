package com.example.sleephabit.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sleephabit.R;
import com.example.sleephabit.model.Login;
import com.example.sleephabit.navigator.Navigator;


public class LoginActivity extends AppCompatActivity {
    Button loginbtn, register;
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginbtn = findViewById(R.id.login);
        register = findViewById(R.id.register);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        Login login = null;

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (email.getText().toString() == null || password.getText().toString() == null ) {
                        Toast.makeText(LoginActivity.this, "email or password is required", Toast.LENGTH_LONG).show();
                }
                else{
                    if(email.getText().toString() == login.getEmail() & password.getText().toString() == login.getPassword()){
                        Intent intent = new Intent(LoginActivity.this, Navigator.class);
                        startActivity(intent);

                    }else{
                        Toast.makeText(LoginActivity.this, "wrong eamil or password ",Toast.LENGTH_LONG).show();
                    }
                }

                Toast.makeText(LoginActivity.this, "email:" +email + "password:" + password, Toast.LENGTH_LONG).show();
            };
        });

        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
              int  page = 1;
                switch (page){
                    case 1:{

                        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                        startActivity(intent);
                        break;
                    }
                }
            }
        });





    }


}

