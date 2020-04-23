package com.example.bit603_assignment2_jasonnorton_5001428;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        final String[] activeUser = User.getActiveUser();
        final EditText editText_username = findViewById(R.id.editText_username);
        final EditText editText_favouriteColour = findViewById(R.id.editText_favouriteColour);
        final Button button_getPassword = findViewById(R.id.button_getPassword);
        final TextView textView_password = findViewById(R.id.textView_password);

        // Handle button clicks
        button_getPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(User.securityQuestionCorrect(editText_username.getText().toString(), editText_favouriteColour.getText().toString())) {
                    textView_password.setText(activeUser[2]);
                }
                // else{}
            }
        });

    }// end onCreate method

    private void dialogBoxIncorrectSecurityQuestion() {
        // Create alert builder:
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Set custom layout for dialog box:
        LayoutInflater layoutInflater = getLayoutInflater();
        View incorrectSecurityQuestionDialogLayout = layoutInflater.inflate(R.layout.incorrect_security_question_dialog_box, null);
        builder.setView(incorrectSecurityQuestionDialogLayout);

        // Add buttons:
        final Button button_confirmSignOut = incorrectSecurityQuestionDialogLayout.findViewById(R.id.button_confirmSignOut);
        final Button button_cancelSignOut = incorrectSecurityQuestionDialogLayout.findViewById(R.id.button_cancelSignOut);

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

    private void dialogBoxShowPassword() {
        // Create alert builder:
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Set custom layout for dialog box:
        LayoutInflater layoutInflater = getLayoutInflater();
        View passwordResetDialogLayout = layoutInflater.inflate(R.layout.password_hint_dialog_box, null);
        builder.setView(passwordResetDialogLayout);

        // Add buttons:
        final Button button_confirmSignOut = passwordResetDialogLayout.findViewById(R.id.button_confirmSignOut);
        final Button button_cancelSignOut = passwordResetDialogLayout.findViewById(R.id.button_cancelSignOut);

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

    }// end dialogBoxShowPassword method

}// end ForgotPasswordActivity
