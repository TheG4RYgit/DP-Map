package com.example.manue.dpmap;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class Main_Menu extends AppCompatActivity {

    public Main_Menu() {
        add_button = (Button) findViewById(R.id.add_button);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main__menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main__menu, menu);
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


    Button back_button = (Button) findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener()

    {
        public void onClick (View v){
        // Perform action on click
    }
    });
    Button add_button;
        add_button.setOnClickListener(new View.OnClickListener()

    {
        public void onClick (View v){
        // Perform action on click
    }
    });
    Button remove_button = (Button) findViewById(R.id.minus_button);
        remove_button.setOnClickListener(new View.OnClickListener()

    {
        public void onClick (View v){
        // Perform action on click
    }
    });
    Button home_button = (Button) findViewById(R.id.unt_logo_button);
        home_button.setOnClickListener(new View.OnClickListener()

    {
        public void onClick (View v){
        // Perform action on click
    }
    });
    Button options_button = (Button) findViewById(R.id.options_button);
         options_button.setOnClickListener(new View.OnClickListener()

    {
        public void onClick (View v){
        // Perform action on click
    }
    });
}
