package com.example.bit603_assignment2_jasonnorton_5001428;

import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@androidx.room.Dao
public interface InventoryDao {
    @Insert
    public void addItem(Inventory item);
    @Query("Select * FROM Inventory") public List<Inventory>getItems();
    @Query("DELETE FROM Inventory") public void deleteInventoryItems();
}
