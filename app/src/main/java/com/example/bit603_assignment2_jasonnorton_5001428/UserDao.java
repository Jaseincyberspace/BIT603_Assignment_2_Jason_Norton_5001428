package com.example.bit603_assignment2_jasonnorton_5001428;

import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@androidx.room.Dao
public interface UserDao {
    @Insert
    public void addUser(User user);
    @Query("SELECT * FROM User") public List<User>getUsers();
    @Query("DELETE FROM User") public void deleteUsers();
}
