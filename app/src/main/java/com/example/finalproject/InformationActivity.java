package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Locale;


public class InformationActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Class[] classes = {January.class, February.class, March.class, April.class, May.class, June.class, July.class, August.class, September.class, October.class, November.class, December.class};

        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.EXTRA_NAME);
        String month = intent.getStringExtra(MainActivity.EXTRA_MONTH);
        String stone = intent.getStringExtra(MainActivity.EXTRA_STONE);
        String i = intent.getStringExtra(MainActivity.EXTRA_I);



        int ii = Integer.parseInt(i);

        TextView textView1 = (TextView) findViewById(R.id.name);



        String message = "Hello " + name + ", \n your birthstone is \n" + stone + "!";
        textView1.setText(message);




        Button infobutton = (Button) findViewById(R.id.infoButton);
        infobutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(InformationActivity.this, classes[ii]);
                intent.putExtra(MainActivity.EXTRA_I, i);
                intent.putExtra(MainActivity.EXTRA_STONE, stone);
                startActivity(intent);
            }

        });

        Button callbutton = (Button) findViewById(R.id.callButton);
        callbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:111-111-111"));
                startActivity(intent);
            }
        });

        Button emailbutton = (Button) findViewById(R.id.emailButton);
        emailbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                    Intent msg = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));

                    msg.putExtra(Intent.EXTRA_EMAIL, new String[] {"birthstoneinfo@gmail.com"});
                    msg.putExtra(Intent.EXTRA_SUBJECT, "Contact Help Center");
                    startActivity(msg);
            }
        } );

        Button textbutton = (Button) findViewById(R.id.smsButton);
        textbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO,
                        Uri.parse("sms:1111111111"));
                smsIntent.putExtra("sms_body", "Request More Info!");
                startActivity(smsIntent);
            }
        } );



    }}

