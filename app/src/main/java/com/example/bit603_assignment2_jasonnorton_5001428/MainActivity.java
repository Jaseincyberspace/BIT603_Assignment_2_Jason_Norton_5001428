package com.example.bit603_assignment2_jasonnorton_5001428;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.icu.lang.UCharacterEnums;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

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
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle(R.string.login_incorrect_login_details);
        builder.setPositiveButton(R.string.login_try_again, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d(TAG, "User chose to try logging in again");
            }
        });
        builder.setNegativeButton(R.string.login_reset_password, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d(TAG, "User chose to reset password");
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}// end MainActivity

