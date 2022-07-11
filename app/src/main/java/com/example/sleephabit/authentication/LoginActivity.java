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
import com.example.sleephabit.navigator.BottomNav;

import okhttp3.ResponseBody;
import retrofit2.Call;


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
        register = findViewById(R.id.toRegister);


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

        inputEmail = findViewById(R.id.loginEmail);
        inputPassword = findViewById(R.id.loginPassword);

        Intent intent = new Intent(LoginActivity.this, BottomNav.class );
                startActivity(intent);
//
//        if (checkDataEntered(inputEmail, inputPassword)) {
//
//            String email = inputEmail.getText().toString();
//            String password = inputPassword.getText().toString();
//
//            RetrofitService retrofitService = new RetrofitService();
//            UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);
//
//            User user = new User();
//            user.setUserName(email);
//            user.setPassword(password);
////            userApi.login(user)
////                    .enqueue(new Callback<User>() {
////                        @Override
////                        public void onResponse(Call<User> call, Response<User> response) {
////                            if (true){
////                                Intent intent = new Intent(LoginActivity.this, BottomNav.class );
////                                startActivity(intent);
////                                Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
////                            }
////                        }
////
////                        @Override
////                        public void onFailure(Call<User> call, Throwable t) {
////                            Toast.makeText(LoginActivity.this, "Connection to server Failed!", Toast.LENGTH_SHORT).show();
////                            Logger.getLogger(RegisterActivity.class.getName()).log(Level.SEVERE, "Error occurred", t);
////                        }
////                    });
//            }
//        }
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
           password.setError("password is required");
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

