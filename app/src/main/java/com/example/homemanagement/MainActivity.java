package com.example.homemanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toolbar mainToolbar;
    private ImageView grocery,gardner,electriian,plumber,babysitter,mechanic;
    private MenuItem addItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grocery = (ImageView) findViewById(R.id.groceries);
        gardner = (ImageView) findViewById(R.id.gardner);
        electriian = (ImageView) findViewById(R.id.electrician);
        plumber = (ImageView) findViewById(R.id.plumber);
        babysitter = (ImageView) findViewById(R.id.babysitter);
        mechanic = (ImageView) findViewById(R.id.mechanic);
        addItems = (MenuItem) findViewById(R.id.mainmenu);

        mainToolbar = (Toolbar) findViewById(R.id.main_Toolbar);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle("Menu");


        grocery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GroceryListItem.class);
                startActivity(intent);
            }
        });
        gardner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GardnerListItem.class);
                startActivity(intent);
            }
        });
        babysitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BabySitterListItem.class);
                startActivity(intent);
            }
        });
        mechanic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MechanicListItem.class);
                startActivity(intent);
            }
        });
        plumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PlumberListItem.class);
                startActivity(intent);
            }
        });
        electriian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ElectricianListItem.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.addItems :
                Intent intent = new Intent(getApplicationContext(),AddItem.class);
                startActivity(intent);
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }
}
