package com.example.appwithroom;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ItemDAO {

    @Query("SELECT * FROM item")
    List<Item> getAll();

    @Insert
    long insert(Item item);
}
