package com.example.sp20_bse_026_assgn2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView = null ;
    int counter = 1; // to keep track of how many time the password is entered.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //textview element
        textView = (TextView) findViewById(R.id.textView);

        //looping over & getting the reference of all the digits
        //and adding click listener, for this to work ids of the button needs to make sense e.g btn1,btn2
        for (int i = 0; i <= 9; i++) {
            findViewById(getResources().getIdentifier("btn"+i , "id", getPackageName()))
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            textView.append(((Button) v).getText());
                        }});
        }

        //open button,
        // if incorrect password is entered 3 times app will close.
        // if password matched Activity2 will be launched.
        // if password is wrong msg will be displayed.
        findViewById(R.id.btnopen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(counter >3)
                    finish();
                else if(textView.getText().toString().trim().equals("0000")){
                    counter=0; //resetting the counter.
                    startActivity(new Intent(MainActivity.this, Activity2.class));
                }
                else
                    Toast.makeText(MainActivity.this, "Wrong password, counter: "+counter , Toast.LENGTH_SHORT).show();

                counter++;
            }
        });

        //delete button, it will delete the last entry
        findViewById(R.id.btndlt).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           String textViewString = textView.getText().toString().trim();
           //checking if the field is empty
            if(textViewString.equals(""))
                return;
            //removing the last element
            textView.setText(textViewString.substring(0,textViewString.length()-1));
        }
        });

    }//end onCreate Method

}//end mainActivity