package com.delaroystudios.bus_seat_booking_system;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Contact_us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        Button search;
        search = (Button)findViewById(R.id.search_info);
        Spinner spinner = (Spinner)findViewById(R.id.spinner1);
        Spinner spinner1 = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.source,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.destination,android.R.layout.simple_spinner_item);//add
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {

                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+ "Selected",Toast.LENGTH_LONG).show();
                ((TextView) parent.getChildAt(0)).setTextColor(Color.GRAY);//TO change the color of spinner items
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {

                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+ "Selected",Toast.LENGTH_LONG).show();
                ((TextView) parent.getChildAt(0)).setTextColor(Color.DKGRAY);//TO change the color of spinner items
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });
        search.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent(Contact_us.this,Bus_Information.class);
                        startActivity(intent);
                    }
                }
        );

    }

}

