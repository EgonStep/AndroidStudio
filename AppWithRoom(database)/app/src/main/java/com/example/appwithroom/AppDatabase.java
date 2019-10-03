package com.example.appwithroom;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Item.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ItemDAO itemDAO();
    private static AppDatabase INSTANCE;

    public static synchronized AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class,
                    "purchase-db")
                    .allowMainThreadQueries() // It's not recommended for a more complex app
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
}