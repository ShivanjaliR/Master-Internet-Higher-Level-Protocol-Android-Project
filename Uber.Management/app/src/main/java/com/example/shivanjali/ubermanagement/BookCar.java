package com.example.shivanjali.ubermanagement;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BookCar extends Activity implements View.OnClickListener
{
    Button bBook;
    DataHandler myDB;
    EditText etSource,etDestination,etCabType,etDate,etTime;
    String source,destination,cabtype,date,time,method;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_car);

        bBook = (Button) findViewById(R.id.bBook);
        bBook.setOnClickListener(this);
    }


        @Override
        public void onClick (View v)
        {
            switch (v.getId()) {
                case R.id.bBook:
                    etSource = (EditText) findViewById(R.id.etSource);
                    etDestination = (EditText) findViewById(R.id.etDestination);
                    etCabType = (EditText) findViewById(R.id.etCabType);
                    etDate = (EditText) findViewById(R.id.etDate);
                    etTime = (EditText) findViewById(R.id.etTime);
                    source = etSource.getText().toString();
                    System.out.println("Source:" + source);
                    destination = etDestination.getText().toString();
                    System.out.println("Destination:" + destination);
                    cabtype = etCabType.getText().toString();
                    System.out.println("CabType:" + cabtype);
                    date = etDate.getText().toString();
                    System.out.println("Date"+date);
                    time = etTime.getText().toString();
                    System.out.println("Time:" + time);
                    method = "Add_Location";
                    Background b = new Background(this);
                    b.execute(method, source,destination,cabtype,date,time);

                    break;
            }//end of switch
        }//end of onClick
    }//end of class


