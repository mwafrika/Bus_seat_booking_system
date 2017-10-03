package com.delaroystudios.bus_seat_booking_system;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DetailsLogin extends AppCompatActivity {
Button contact,ViewBooking,book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_login);
        contact = (Button) findViewById(R.id.contact);
        ViewBooking = (Button) findViewById(R.id.View_booking);
        book = (Button)findViewById(R.id.Book_ticket);
        contact.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                      /*  Intent intent = new Intent(v.getContext(),Contact_us.class);
                        v.getContext().startActivity(intent);*/
                      Intent intent = new Intent(DetailsLogin.this,Contact_us.class);
                        startActivity(intent);
                    }
                }
        );

       ViewBooking.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                      /*  Intent intent = new Intent(v.getContext(),Contact_us.class);
                        v.getContext().startActivity(intent);*/
                        Intent intent = new Intent(DetailsLogin.this,View_Booking.class);
                        startActivity(intent);
                    }
                }
        );
        book.setOnClickListener(
        new View.OnClickListener(){
         @Override
        public void onClick(View v){
          Intent intent = new Intent(DetailsLogin.this,Book_ticket.class);
             startActivity(intent);
         }
        }
        );
       /* Intent intent2 = new Intent(DetailsLogin.this,Contact_us.class);
        startActivity(intent2);*/
    }
    }

