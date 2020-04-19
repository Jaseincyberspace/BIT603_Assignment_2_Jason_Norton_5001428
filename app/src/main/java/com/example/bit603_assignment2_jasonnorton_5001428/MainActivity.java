package com.example.bit603_assignment2_jasonnorton_5001428;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public String TAG = "loginScreenLOGS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView forgotPassword = findViewById(R.id.textView_forgotPassword);
        final EditText username = findViewById(R.id.editText_username);
        final EditText password = findViewById(R.id.editText_password);
        final Button button_login = findViewById(R.id.button_login);

        // Deal with button clicks:
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Forgot Password");
            }
        });

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBoxLoginFailed();
            }
        });

    }// end onCreate method

    private void dialogBoxLoginFailed() {
        // Create alert builder:
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Set custom layout for dialog box:
        LayoutInflater layoutInflater = getLayoutInflater();
        View loginFailedDialogLayout = layoutInflater.inflate(R.layout.login_failed_dialog_box, null);
        builder.setView(loginFailedDialogLayout);

        // Add buttons:
        final Button button_tryAgain = loginFailedDialogLayout.findViewById(R.id.button_tryAgain);
        final Button button_resetPassword = loginFailedDialogLayout.findViewById(R.id.button_resetPassword);

        // Create dialog box and display it on screen:
        final AlertDialog dialog = builder.create();

        // Deal with button clicks:
        button_tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        button_resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "User would like to reset their password. **** Programmer needs to add code to switch to the Reset Password Activity");
            }
        });

        // Show dialog box on screen:
        dialog.show();

    }// end dialogBoxLoginFailed method

}// end MainActivity

