package com.example.bit603_assignment2_jasonnorton_5001428;

import androidx.room.Insert;

@androidx.room.Dao
public interface InventoryDao {
    @Insert
    public void addItem(Inventory item);
}
