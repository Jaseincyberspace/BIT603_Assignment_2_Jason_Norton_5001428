package com.example.bit603_assignment2_jasonnorton_5001428;

import android.util.Log;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.HashMap;

@Entity(tableName = "Inventory")
public class Inventory {

    // Database Fields with 'id' as primary key:
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private int id;

    @ColumnInfo(name ="Item")
    private String itemName;

    @ColumnInfo(name = "Quantity")
    private int quantity;

    // Getters and Setters:
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addToQuantity() {this.quantity += 1;}

    public void removeFromQuantity() {this.quantity -= 1;}

} //  End class
