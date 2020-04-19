package com.example.bit603_assignment2_jasonnorton_5001428;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version=1)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
