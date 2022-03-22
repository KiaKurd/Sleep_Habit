package com.example.sleephabit.model;


import com.orm.SugarRecord;

public class Login extends SugarRecord {
    private String email;
    private String username;
    private String password;



    public Login() {
    }

    public Login(String username, String password, String email){
        this.username = username;
        this.password=password;
        this.email=email;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() { return password; }
    public void setPassword(String password){ this.password = password; }


    public String getUsername() { return username; }
    public void setUsername(String username){ this.username = username; }

}



