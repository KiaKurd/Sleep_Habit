package com.example.sleephabit.model;


import android.widget.EditText;
import com.orm.SugarRecord;

public class login extends SugarRecord {
    public String email;
    public String username;
    public String password;



    public login(EditText email, EditText password) {
    }

    public login(String username,String password,String email){
        this.username = username;
        this.password=password;
        this.email=email;
    }


    public login(EditText email, EditText password, EditText username) {
    }
}



