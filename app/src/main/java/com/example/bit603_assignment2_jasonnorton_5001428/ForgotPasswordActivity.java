package com.example.bit603_assignment2_jasonnorton_5001428;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
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
                else{
                    dialogBoxIncorrectUserCredentials();
                }
            }
        });

    }// end onCreate method

    private void dialogBoxIncorrectUserCredentials() {
        // Create alert builder:
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Set custom layout for dialog box:
        LayoutInflater layoutInflater = getLayoutInflater();
        View incorrectUserCredentialsDialogLayout = layoutInflater.inflate(R.layout.incorrect_user_credentials_dialog_box, null);
        builder.setView(incorrectUserCredentialsDialogLayout);

        // Add buttons:
        final Button button_tryAgain = incorrectUserCredentialsDialogLayout.findViewById(R.id.button_tryAgain);

        // Create dialog box and display it on screen:
        final AlertDialog dialog = builder.create();

        button_tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        // Show dialog box on screen:
        dialog.show();

    }// end dialogBoxSignOut method

}// end ForgotPasswordActivity
