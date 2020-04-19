package com.example.bit603_assignment2_jasonnorton_5001428;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    // Global variables:
    public String TAG = "loginScreenLOGS";
    public static UserDatabase userDatabase;
    public static InventoryDatabase inventoryDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate the userDatabse which is used for login details. It has the following fields: id, username, password, favourite colour.
        userDatabase = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "userDB").allowMainThreadQueries().build();

        // Add supplied list of users: *** Only needs to be done once then this code can be commented out.
        User user = new User();
        user.setUsername("Jason");
        user.setPassword("Sword");
        user.setFavouriteColour("Red");
        userDatabase.userDao().addUser(user);

        // Instantiate the inventoryDatabase which holds all of the inventory items:
        inventoryDatabase = Room.databaseBuilder(getApplicationContext(), InventoryDatabase.class, "inventoryDB").allowMainThreadQueries().build();

        // Reset database (clears all values from it) *************************************************************************************** FOR TESTING ONLY
        inventoryDatabase.inventoryDao().deleteInventoryItems();

        // Add default items to the inventoryDatabase (used for testing purposes):
        Inventory item = new Inventory();
        item.setItem("Flour");
        item.setQuantity(12);
        inventoryDatabase.inventoryDao().addItem(item);

        final TextView forgotPassword = findViewById(R.id.textView_forgotPassword);
        final EditText username = findViewById(R.id.editText_username);
        final EditText password = findViewById(R.id.editText_password);
        final Button button_login = findViewById(R.id.button_login);

        // display a string in the username field populated by the items and quantities in the inventoryDatabase: **************************** FOR TESTING ONLY
        List<Inventory>inventoryList = inventoryDatabase.inventoryDao().getItems();
        String inventoryItems = "";
        for(Inventory inventoryItem : inventoryList) {
            inventoryItems += " " + inventoryItem.getItem() + " " + inventoryItem.getQuantity();
        }
        username.setText(inventoryItems);

        // display a string in the username field populated by the list of users: *********************************************************** FOR TESTING ONLY
        List<User>userList = userDatabase.userDao().getUsers();
        String listOfUsers = "";
        for(User users : userList) {
            listOfUsers += " " + users.getUsername() + " " + users.getPassword() + " " + users.getFavouriteColour();
        }
        username.setText(listOfUsers);

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

