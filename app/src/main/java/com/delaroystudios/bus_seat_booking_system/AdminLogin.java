package com.delaroystudios.bus_seat_booking_system;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
    LoginDataBaseAdapter loginDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);}

        //Main_activity_login de = new Main_activity_login();
    public void log_admin(View v){
        final Dialog dialog = new Dialog(AdminLogin.this);
        dialog.setContentView(R.layout.activity_admin_login);//
        dialog.setTitle("Login");
        final EditText editUserName = (EditText)findViewById(R.id.EditLog);
        final EditText editPassword = (EditText)findViewById(R.id.Edit_pass);
        //final EditText editConfpass = (EditText)findViewById(R.id.conf_pass);
        Button btnLogin = (Button)findViewById(R.id.admin_login);
        final String userName,password,storedPassword;

        btnLogin.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        String userName = editUserName.getText().toString();
                        String password = editPassword.getText().toString();
                      //  String confpassword = editConfpass.getText().toString();
                        String storedPassword = loginDataBaseAdapter.getSingleEntry(userName);

                        if (password.equals(storedPassword)){
                            Toast.makeText(AdminLogin.this,"You made it!,Login successful",Toast.LENGTH_LONG).show();
                            dialog.dismiss();
                            Intent intent = new Intent(AdminLogin.this,DetailsLogin.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(AdminLogin.this,"User name or password does not match",Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
        dialog.show();
    }
    @Override
    protected  void onDestroy(){
        super.onDestroy();
        loginDataBaseAdapter.close();
    }
    }

