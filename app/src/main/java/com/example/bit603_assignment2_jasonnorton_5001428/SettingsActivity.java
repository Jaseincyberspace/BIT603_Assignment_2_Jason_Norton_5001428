package com.example.bit603_assignment2_jasonnorton_5001428;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button button_resetPassword = findViewById(R.id.button_resetPassword);
        Button button_signOut = findViewById(R.id.button_signOut);

        button_resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ResetPasswordActivity.class);
                startActivity(i);
            }
        });

        button_signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBoxSignOut();
            }
        });
    }// end onCreate Method

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

}// end SettingsActivity
