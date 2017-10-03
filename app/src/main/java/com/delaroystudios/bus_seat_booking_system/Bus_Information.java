package com.delaroystudios.bus_seat_booking_system;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Bus_Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus__information);

        Button ticket;
        ticket = (Button)findViewById(R.id.buton8);
       ticket.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent(Bus_Information.this,pick_ticket.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
