package com.example.bit603_assignment2_jasonnorton_5001428;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class ResetPasswordActivity extends AppCompatActivity {

    // Override the Up button to go back to whichever activity you came from instead of going to the parent activity.
    // This is necessary because ResetPasswordActivity is accessed from MainActivity and from SettingsActivity.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

    }

}
