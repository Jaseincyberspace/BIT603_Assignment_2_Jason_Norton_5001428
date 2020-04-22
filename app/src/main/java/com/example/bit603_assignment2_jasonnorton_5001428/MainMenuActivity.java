package com.example.bit603_assignment2_jasonnorton_5001428;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        final TextView textView_displayUsername = findViewById(R.id.textView_displayUsername);
        final Button button_viewInventory = findViewById(R.id.button_viewInventory);
        final Button button_viewStocktakeReport = findViewById(R.id.button_viewStocktakeReport);
        final Button button_settings = findViewById(R.id.button_settings);
        final Button button_signOut = findViewById(R.id.button_signOut);

        //Deal with button clicks:
        button_viewInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), InventoryActivity.class);
                startActivity(i);
            }
        });

        button_viewStocktakeReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TO DO: ADD CODE TO LINK TO STOCKTAKEREPORT ACTIVITY
            }
        });

        button_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(i);
            }
        });

        button_signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });



    }// end OnCreate method
}
