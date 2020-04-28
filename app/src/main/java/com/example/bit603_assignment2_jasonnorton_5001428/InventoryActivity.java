package com.example.bit603_assignment2_jasonnorton_5001428;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
        // Initialize inventoryItems ArrayList:
        inventoryItems = populateInventory();

        // Lookup the recyclerview:
        // This code ensures that the most up to date data is displayed in the RecyclerView, even if the user moves to a different screen then returns
        RecyclerView recyclerView_Inventory = (RecyclerView) findViewById(R.id.recyclerView_Inventory);
        // Create adapter and pass in the inventory items:
        InventoryAdapter adapter = new InventoryAdapter(inventoryItems);
        // Attach the adapter to the RecyclerView:
        recyclerView_Inventory.setAdapter(adapter);
        // Set layout manager to position the items in RecyclerView:
        recyclerView_Inventory.setLayoutManager(new LinearLayoutManager(this));


        // Reset database (clears all values from it) *************************************************************************************** FOR TESTING ONLY
        // inventoryDatabase.inventoryDao().deleteInventoryItems();

        button_addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inventoryHashMap.put("An Item", 12);
                inventoryItems = populateInventory();

                // Update the RecyclerView so it displays the new item:
                // Lookup the recyclerview:
                RecyclerView recyclerView_Inventory = (RecyclerView) findViewById(R.id.recyclerView_Inventory);
                // Create adapter and pass in the inventory items:
                InventoryAdapter adapter = new InventoryAdapter(inventoryItems);
                // Attach the adapter to the RecyclerView:
                recyclerView_Inventory.setAdapter(adapter);
                // Set layout manager to position the items in RecyclerView:
                recyclerView_Inventory.setLayoutManager(new LinearLayoutManager(getParent()));
            }
        });

    }// End onCreate method

    // Populate inventory with testing data:
    public static ArrayList<Inventory> populateInventory() {

        inventoryHashMap.put("Another Item", 2);

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
    } // End ArrayList

}// End Class
