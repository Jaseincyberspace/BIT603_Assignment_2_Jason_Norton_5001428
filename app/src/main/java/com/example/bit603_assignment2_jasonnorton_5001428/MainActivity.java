package com.example.bit603_assignment2_jasonnorton_5001428;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    // Global variables:
    public String TAG = "loginScreenLOGS";
    public static InventoryDatabase inventoryDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView forgotPassword = findViewById(R.id.textView_forgotPassword);
        final EditText username = findViewById(R.id.editText_username);
        final EditText password = findViewById(R.id.editText_password);
        final Button button_login = findViewById(R.id.button_login);

        // Create a ListArray of users from a 2 dimensional StringArray held in User.java:
        User.setUsers();

        // Instantiate the inventoryDatabase which holds all of the inventory items:
        inventoryDatabase = Room.databaseBuilder(getApplicationContext(), InventoryDatabase.class, "inventoryDB").allowMainThreadQueries().build();

        // Reset database (clears all values from it) *************************************************************************************** FOR TESTING ONLY
        inventoryDatabase.inventoryDao().deleteInventoryItems();
        // userDatabase.userDao().deleteUsers();

        // Add default items to the inventoryDatabase (used for testing purposes):
        Inventory item = new Inventory();
        item.setItem("Flour");
        item.setQuantity(12);
        inventoryDatabase.inventoryDao().addItem(item);

        // display a string in the username field populated by the items and quantities in the inventoryDatabase: **************************** FOR TESTING ONLY
        List<Inventory>inventoryList = inventoryDatabase.inventoryDao().getItems();
        String inventoryItems = "";
        for(Inventory inventoryItem : inventoryList) {
            inventoryItems += " " + inventoryItem.getItem() + " " + inventoryItem.getQuantity();
        }
        //username.setText(inventoryItems);
        username.setText("Jason");
        password.setText("Sword");

        // Deal with button clicks:
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ForgotPasswordActivity.class);
                startActivity(i);
            }
        });

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Verify login details:
                if(User.credentialsVerified(username.getText().toString(), password.getText().toString())) {
                    Intent i = new Intent(getApplicationContext(), MainMenuActivity.class);
                    startActivity(i);
                }
                else {
                    dialogBoxLoginFailed();
                }
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
        final Button button_resetPassword = loginFailedDialogLayout.findViewById(R.id.button_getPassword);

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
                Intent i = new Intent(getApplicationContext(), ForgotPasswordActivity.class);
                startActivity(i);
            }
        });

        // Show dialog box on screen:
        dialog.show();

    }// end dialogBoxLoginFailed method

}// end MainActivity

