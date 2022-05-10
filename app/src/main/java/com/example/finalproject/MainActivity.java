package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation;
import android.app.NotificationChannel;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "com.example.finalproject.EXTRA_NAME";
    public static final String EXTRA_MONTH = "com.example.finalproject.EXTRA_MONTH";
    public static final String EXTRA_STONE = "com.example.finalproject.EXTRA_STONE";
    public static final String EXTRA_I = "com.example.finalproject.EXTRA_I";
    public Button button;
    EditText name, month;
    public String birthstone;
    public int i;
    public Animation shake;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.call:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:111-111-111"));
                startActivity(intent);

                return true;

            case R.id.email:
                Intent msg = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));

                msg.putExtra(Intent.EXTRA_EMAIL, new String[]{"birthstoneinfo@gmail.com"});
                msg.putExtra(Intent.EXTRA_SUBJECT, "Contact Help Center");
                startActivity(msg);

                return true;

            case R.id.text:
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO,
                        Uri.parse("sms:1111111111"));
                smsIntent.putExtra("sms_body", "Request More Info!");
                startActivity(smsIntent);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.goButton);


        //attach animation scripts
        shake = AnimationUtils.loadAnimation(this, R.anim.shake);

        //set button listeners
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                button.startAnimation(shake);
            }
        });


        name = findViewById(R.id.nameID);
        month = findViewById(R.id.monthID);
        button = (Button) findViewById(R.id.goButton);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameEntered = name.getText().toString();
                String monthEntered = month.getText().toString();

                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "My Notification");
                builder.setContentTitle("Title");
                builder.setContentText("Body");
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(1, builder.build());





                if (nameEntered.isEmpty() && nameEntered.equals("")){
                    Toast.makeText(MainActivity.this, "Please enter a name.", Toast.LENGTH_SHORT).show();
                }
                if (monthEntered.isEmpty() && monthEntered.equals("")){
                    Toast.makeText(MainActivity.this, "Please enter a month.", Toast.LENGTH_SHORT).show();
                }
                else{
                    EditText name  = (EditText) findViewById(R.id.nameID); // set name equal to nameID edittext
                    String finalName = name.getText().toString(); // set finalName as text from

                    EditText month = (EditText) findViewById(R.id.monthID);
                    String finalMonth = month.getText().toString();


                    finalMonth = finalMonth.toLowerCase();

                    switch(finalMonth){
                        case "january":
                            birthstone = "Garnet";
                            i = 0;
                            break;
                        case "february":
                            birthstone = "Amethyst";
                            i=1;
                            break;
                        case "march":
                            birthstone = "Aquamarine";
                            i=2;
                            break;
                        case "april":
                            birthstone = "Diamond";
                            i=3;
                            break;
                        case "may":
                            birthstone = "Emerald";
                            i=4;
                            break;
                        case "june":
                            birthstone = "Pearl";
                            i=5;
                            break;
                        case "july":
                            birthstone = "Ruby";
                            i=6;
                            break;
                        case "august":
                            birthstone = "Peridot";
                            i=7;
                            break;
                        case "september":
                            birthstone = "Sapphire";
                            i=8;
                            break;
                        case "october":
                            birthstone = "Opal";
                            i=9;
                            break;
                        case "novemeber":
                            birthstone = "Topaz";
                            i=10;
                            break;
                        case "december":
                            birthstone = "Turquoise";
                            i=11;
                            break;
                    }

                    Intent intent = new Intent(MainActivity.this, InformationActivity.class);
                    intent.putExtra(EXTRA_NAME, finalName);
                    intent.putExtra(EXTRA_MONTH, finalMonth);
                    intent.putExtra(EXTRA_STONE, birthstone);
                    intent.putExtra(EXTRA_I, new Integer(i).toString());



                    startActivity(intent);
                }




            }

        });
    }
}