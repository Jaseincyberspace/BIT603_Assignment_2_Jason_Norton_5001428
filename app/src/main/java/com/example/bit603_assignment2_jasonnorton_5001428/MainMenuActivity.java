package com.example.bit603_assignment2_jasonnorton_5001428;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        final TextView textView_helloUsername = findViewById(R.id.textView_helloUsername);
        final Button button_viewInventory = findViewById(R.id.button_viewInventory);
        final Button button_viewStocktakeReport = findViewById(R.id.button_viewStocktakeReport);
        final Button button_signOut = findViewById(R.id.button_signOut);

        // Customise welcome message to show username
        String[] activeUser = User.getActiveUser();
        textView_helloUsername.setText(getString(R.string.hi) + " " + activeUser[1]);

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

        button_signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBoxSignOut();
            }
        });

    }// end OnCreate method

    private void dialogBoxSignOut() {
        // Create alert builder:
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Set custom layout for dialog box:
        LayoutInflater layoutInflater = getLayoutInflater();
        View signOutDialogLayout = layoutInflater.inflate(R.layout.sign_out_dialog_box, null);
        builder.setView(signOutDialogLayout);

        // Add buttons:
        final Button button_confirmSignOut = signOutDialogLayout.findViewById(R.id.button_confirmSignOut);
        final Button button_cancelSignOut = signOutDialogLayout.findViewById(R.id.button_cancelSignOut);

        // Create dialog box and display it on screen:
        final AlertDialog dialog = builder.create();

        // Deal with button clicks:
        button_confirmSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        button_cancelSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        // Show dialog box on screen:
        dialog.show();

    }// end dialogBoxSignOut method

}// end MainMenuActivity
