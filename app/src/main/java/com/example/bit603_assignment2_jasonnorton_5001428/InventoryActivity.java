package com.example.bit603_assignment2_jasonnorton_5001428;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InventoryActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    public static InventoryDatabase inventoryDatabase;
    List<Inventory> inventoryList;
    public static String TAG = "inventoryActivityLogs";
    private static HashMap <String, Integer> inventoryHashMap = new HashMap<>();
    ArrayList<Inventory> inventoryItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        Button button_addItem = findViewById(R.id.button_addItem);
        TextView textView_InventoryListItem = findViewById(R.id.textView_InventoryListItem);
        TextView textView_InventoryListQuantity = findViewById(R.id.textView_InventoryListQuantity);

        // Instantiate the inventoryDatabase which holds all of the inventory items:
        inventoryDatabase = Room.databaseBuilder(getApplicationContext(), InventoryDatabase.class, "inventoryDB").allowMainThreadQueries().build();

        // Initialize inventoryItems ArrayList and display it in the RecyclerView:
        inventoryItems = populateInventory();
        updateRecyclerView();

        // Reset database (clears all values from it) *************************************************************************************** FOR TESTING ONLY
        // inventoryDatabase.inventoryDao().deleteInventoryItems();

        button_addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBoxAddItem();
            }
        });

    }// End onCreate method

    private void dialogBoxAddItem() {
        // Create alert builder:
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Set custom layout for dialog box:
        LayoutInflater layoutInflater = getLayoutInflater();
        View addItemDialogLayout = layoutInflater.inflate(R.layout.add_item_dialog_box, null);
        builder.setView(addItemDialogLayout);

        // Add views:
        final EditText editText_itemName =  addItemDialogLayout.findViewById(R.id.editText_itemName);
        final EditText editText_addQuantity = addItemDialogLayout.findViewById(R.id.editText_addQuantity);
        final TextView textView_errorMessage = addItemDialogLayout.findViewById(R.id.textView_errorMessage);
        final Button button_confirmAddItem = addItemDialogLayout.findViewById(R.id.button_confirmAddItem);
        final Button button_cancelAddItem = addItemDialogLayout.findViewById(R.id.button_cancelAddItem);

        // Create dialog box and display it on screen:
        final AlertDialog dialog = builder.create();

        // Deal with button clicks:
        button_cancelAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        button_confirmAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check user has entered an item name and quantity:
                if(!editText_itemName.getText().toString().equals("")) {
                    if(isInt(editText_addQuantity.getText().toString())) {
                        inventoryHashMap.put(editText_itemName.getText().toString(), Integer.parseInt(editText_addQuantity.getText().toString()));
                        inventoryItems = populateInventory();
                        updateRecyclerView();
                        dialog.dismiss();
                    }
                    else {
                        textView_errorMessage.setText("Please enter a quantity");
                    }
                }
                else {
                    textView_errorMessage.setText("Please enter item name");
                }

            }
        });

        // Show dialog box on screen:
        dialog.show();

    }// end dialogBoxAddItem method

    // Populate inventory with data:
    public static ArrayList<Inventory> populateInventory() {
        ArrayList<Inventory> inventoryItems = new ArrayList<>();
        String key = "";
        int value;
        for(String k: inventoryHashMap.keySet()) {
            key = k;
            value = Integer.parseInt(inventoryHashMap.get(key).toString());
            Inventory item = new Inventory();
            item.setItemName(key);
            item.setQuantity(value);
            inventoryItems.add(item);
        }
        return inventoryItems;
    } // End populateInventory method

    public void updateRecyclerView() {
        // Update the RecyclerView so it displays the new item:
        // Lookup the recyclerview:
        RecyclerView recyclerView_Inventory = findViewById(R.id.recyclerView_Inventory);
        // Create adapter and pass in the inventory items:
        InventoryAdapter adapter = new InventoryAdapter(inventoryItems);
        // Attach the adapter to the RecyclerView:
        recyclerView_Inventory.setAdapter(adapter);
        // Set layout manager to position the items in RecyclerView:
        recyclerView_Inventory.setLayoutManager(new LinearLayoutManager(getParent()));
    }// End updateRecyclerView method

    public Boolean isInt(String quantity) {
        try{
            Integer.parseInt(quantity);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

}// End Class
