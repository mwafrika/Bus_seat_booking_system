package com.delaroystudios.bus_seat_booking_system;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Main_activity_login extends AppCompatActivity {
    Button login;
    Button sign;
    LoginDataBaseAdapter loginDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
       /* final Button login;
        final Button sign;
        LoginDataBaseAdapter loginDataBaseAdapter;*/
        login = (Button)findViewById(R.id.log);
        final Spinner spinner = (Spinner)findViewById(R.id.spinner1);
         sign = (Button)findViewById(R.id.sgn);
       loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.roles_selection,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+ "Selected",Toast.LENGTH_LONG).show();
                ((TextView) parent.getChildAt(0)).setTextColor(Color.RED);//TO change the color of spinner items

              final Intent intent;
                switch (position)
                {
                    case 1:
                        logIn(view);
                        onDestroy();
                      break;
                    case 2:
                        intent = new Intent(Main_activity_login.this,pick_ticket.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(Main_activity_login.this,SignIn.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(Main_activity_login.this,View_Booking.class);
                        startActivity(intent);
                    default:
                        System.out.println("wrong");
                }
                 }

            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });

       /* login.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        // code for button one click
                        Intent intent = new Intent(Main_activity_login.this,DetailsLogin.class);  ??????????????????????????????????????????????????????????????????
                        startActivity(intent);

                    }

                }
        );*/
   sign.setOnClickListener(
   new View.OnClickListener(){
    @Override
   public void onClick(View view){
        Intent intent = new Intent(Main_activity_login.this,SignIn.class);
        startActivity(intent);
    }
   }
   );

    }
public void logIn(View v){
   /* final Dialog dialog = new Dialog(Main_activity_login.this);
    dialog.setContentView(R.layout.activity_main_login);//
    dialog.setTitle("Login");*/
    final EditText editUserName = (EditText)findViewById(R.id.EditLog);
    final EditText editPassword = (EditText)findViewById(R.id.Edit_menu2);
    Button btnLogin = (Button)findViewById(R.id.log);
    final String userName,password,storedPassword;

     btnLogin.setOnClickListener(
            new View.OnClickListener(){
          public void onClick(View v){
            String userName = editUserName.getText().toString();
              String password = editPassword.getText().toString();
             String storedPassword = loginDataBaseAdapter.getSingleEntry(userName);

              if (password.equals(storedPassword)){
                  Toast.makeText(Main_activity_login.this,"You made it!,Login successful",Toast.LENGTH_LONG).show();
                 // dialog.dismiss();
                  Intent intent = new Intent(Main_activity_login.this,DetailsLogin.class);
                  startActivity(intent);
              }
              else {
                  Toast.makeText(Main_activity_login.this,"User name or password does not match",Toast.LENGTH_LONG).show();
              }
          }
            }
    );
//dialog.show();
}
//////////////////////////////////////////////////////////////////////////////////////////////////
public void logIn_admin(View v){
    final Dialog dialog = new Dialog(Main_activity_login.this);
    dialog.setContentView(R.layout.activity_admin_login);//
    dialog.setTitle("Login");
    final EditText editUserName = (EditText)findViewById(R.id.EditLog);
    final EditText editPassword = (EditText)findViewById(R.id.Edit_pass);
    Button btnLogin = (Button)findViewById(R.id.log);
    final String userName,password,storedPassword;

    btnLogin.setOnClickListener(
            new View.OnClickListener(){
                public void onClick(View v){
                    String userName = editUserName.getText().toString();
                    String password = editPassword.getText().toString();
                    String storedPassword = loginDataBaseAdapter.getSingleEntry(userName);

                    if (password.equals(storedPassword)){
                        Toast.makeText(Main_activity_login.this,"You made it!,Login successful",Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                        Intent intent = new Intent(Main_activity_login.this,DetailsLogin.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(Main_activity_login.this,"User name or password does not match",Toast.LENGTH_LONG).show();
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


    /*public void startActivity() {
        Intent intent = new Intent(Main_activity_login.this,Bus_info_admin.class);
        startActivity(intent);
    }*/
 /*public void buttonLoginClick(View v){

        Intent intent = new Intent(v.getContext(),DetailsLogin.class);
        v.getContext().startActivity(intent);

    }

    */

    }


