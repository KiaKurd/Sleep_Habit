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

import java.util.logging.Level;
import java.util.logging.Logger;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));

        initializeComponents();

    }

    private void initializeComponents() {

        Button register;
        EditText inputUserName, inputEmail, inputPassword, inputConfirmPassword;

        register = findViewById(R.id.register);
        inputUserName = findViewById(R.id.username);
        inputPassword = findViewById(R.id.password);
        inputConfirmPassword = findViewById(R.id.confirmPassword);
        inputEmail = findViewById(R.id.email);

        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);

        register.setOnClickListener(view -> {

            if (checkDataEntered(inputUserName, inputEmail, inputPassword, inputConfirmPassword)){
              String username = String.valueOf(inputUserName.getText());
              String email = String.valueOf(inputEmail.getText());
              String password = String.valueOf(inputPassword.getText());

              User user = new User();
              user.setUserName(username);
              user.setPassword(password);
              user.setEmail(email);


              userApi.register(user)
                      .enqueue(new Callback<User>() {
                          @Override
                          public void onResponse(Call<User> call, Response<User> response){
                              Toast.makeText(RegisterActivity.this, "Register Successfull!", Toast.LENGTH_SHORT).show();
                              Intent intent = new Intent(RegisterActivity.this, BottomNav.class);
                              startActivity(intent);
                          }

                          @Override
                          public void onFailure(Call<User> call, Throwable t ){
                              Toast.makeText(RegisterActivity.this, "Register Failed!", Toast.LENGTH_SHORT).show();
                              Logger.getLogger(RegisterActivity.class.getName()).log(Level.SEVERE, "Error occurred", t);
                          }

                      });
        } });
    }

   private Boolean checkDataEntered(EditText userName,EditText email,EditText password, EditText confirmPassword){

        if ( TextUtils.isEmpty(email.getText().toString()) || !(Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) ) {
            email.setError("Unvalid Email");
            return false;
        }else if (TextUtils.isEmpty(password.getText().toString())){
            password.setError("password is required");
            return false;
        }else if (TextUtils.isEmpty(confirmPassword.getText().toString()) || (confirmPassword.getText().toString() == password.getText().toString())) {
            confirmPassword.setError("your passwords does not match");
            return false;
        }
        else return true;
    }


    public void onFailure(Call<ResponseBody> call, Throwable t){
        Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
    }

}