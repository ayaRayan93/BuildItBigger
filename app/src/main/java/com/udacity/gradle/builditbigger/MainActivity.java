package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.androidjokelib.displayJoke;
import com.example.javaLibJokes;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, "ca-app-pub-1266428039068299~1512693161");
        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

        Toast.makeText(this,javaLibJokes.getJoke(), Toast.LENGTH_SHORT).show();
        Intent itemintent = null;

        try {

            itemintent = new Intent(this, displayJoke.class);//Ex com.example.test.Activity
        } catch (Exception e) {
            e.printStackTrace();
        }

        itemintent.putExtra("key", javaLibJokes.getJoke());

        startActivity(itemintent);

    }
    public void tellJokeGCE(View view)
    {
        String str= new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Manfred")).toString();
        Toast.makeText(this,str, Toast.LENGTH_SHORT).show();
    }

}
