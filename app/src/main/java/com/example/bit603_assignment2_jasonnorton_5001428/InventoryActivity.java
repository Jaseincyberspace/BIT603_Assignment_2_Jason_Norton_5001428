package com.example.bit603_assignment2_jasonnorton_5001428;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class InventoryActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        final TextView textView_displayUsername = findViewById(R.id.textView_displayUsername);

        // Customise welcome message to show username
        String[] activeUser = User.getActiveUser();
        String username = activeUser[1];
        textView_displayUsername.setText(textView_displayUsername.getText() + " " + username);

    }
}
