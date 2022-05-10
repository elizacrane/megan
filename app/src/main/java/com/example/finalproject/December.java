package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class December extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_december);

        Intent intent = getIntent();
        String stone = intent.getStringExtra(MainActivity.EXTRA_STONE);
        String i = intent.getStringExtra(MainActivity.EXTRA_I);

        int ii = Integer.parseInt(i);

        TextView textView1 = (TextView) findViewById(R.id.stoneName);
        textView1.setText(stone);

        String[] blurb1 = WriteUp.blurb;
        String information = blurb1[ii];

        TextView textView2 = (TextView) findViewById(R.id.stoneBlurb);
        textView2.setText(information);
    }
}