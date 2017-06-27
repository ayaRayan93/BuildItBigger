package com.example.androidjokelib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class displayJoke extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        Intent i=this.getIntent();

            String value=i.getStringExtra("key");
            TextView textView=(TextView) findViewById(R.id.text);
            textView.setText(value);

    }
}
