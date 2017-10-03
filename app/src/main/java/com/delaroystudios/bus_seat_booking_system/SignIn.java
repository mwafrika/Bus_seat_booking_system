package com.delaroystudios.bus_seat_booking_system;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {  //AppCompatActivity
    EditText editUserName,editPassword,editConfirmPassword,editUserId,editPhone,editEmail ;
    Button btnCreateAccount,btn;
    Context context = this;
    LoginDataBaseAdapter loginDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

loginDataBaseAdapter = new LoginDataBaseAdapter(this);
 loginDataBaseAdapter = loginDataBaseAdapter.open();
 editUserName =(EditText)findViewById(R.id.id_name);
 editUserId = (EditText)findViewById(R.id.id_user);
 editPassword = (EditText)findViewById(R.id.password);
        editConfirmPassword = (EditText)findViewById(R.id.conf_pass);
        editPhone = (EditText)findViewById(R.id.phone);
        btnCreateAccount = (Button)findViewById(R.id.register) ;
        editEmail = (EditText)findViewById(R.id.email);

        btnCreateAccount.setOnClickListener(
                new View.OnClickListener(){
      public  void onClick(View v){
     String userName = editUserName.getText().toString();
     String password = editPassword.getText().toString();
          String UserId = editUserId.getText().toString();
     String confirmPassword = editConfirmPassword.getText().toString();
          String phone = editPhone.getText().toString();
          String email = editEmail.getText().toString();

     if (userName.equals("")||password.equals("")||confirmPassword.equals("")||phone.equals("")||UserId.equals("")||email.equals("")){
         Toast.makeText(getApplicationContext(),"Field Vacant",Toast.LENGTH_LONG).show();
return;
     }
     if (!password.equals(confirmPassword)){
    Toast.makeText(getApplicationContext(),"Password does not match",Toast.LENGTH_LONG).show();
     return;
     }
     else {
 loginDataBaseAdapter.insertEntry(userName,password);
 Toast.makeText(getApplicationContext(),"Account Successfully created",Toast.LENGTH_LONG).show();
     Intent i = new Intent(SignIn.this,Main_activity_login.class);
         startActivity(i);
         finish();
     }
      }
  }
        );

   /*btn.setOnClickListener(
   new View.OnClickListener(){
   @Override
  public void onClick(View view){
       Intent intent = new Intent(SignIn.this,Main_activity_login.class);
       startActivity(intent);
   }
   }/??????????????????????????????????????????????????????????????????????????????????
   );*/


    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        loginDataBaseAdapter.close();
    }

}
