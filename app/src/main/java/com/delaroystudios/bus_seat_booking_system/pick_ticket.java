package com.delaroystudios.bus_seat_booking_system;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pick_ticket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_ticket);

        Button ab;
        ab = (Button) findViewById(R.id.button8);

        ab.setOnClickListener(
        new  View.OnClickListener(){
            @Override
   public void onClick(View v){
                Intent intent = new Intent(pick_ticket.this,button_ticket.class);
                startActivity(intent);
            }
        }
        );


    }}
