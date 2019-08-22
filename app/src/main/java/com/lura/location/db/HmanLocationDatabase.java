package com.lura.location.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {LocationDetails.class}, version = 1, exportSchema = false)
public abstract class HmanLocationDatabase extends RoomDatabase {

    private static final String DB_NAME = "locationDatabase.db";
    private static volatile HmanLocationDatabase instance;

    public static synchronized HmanLocationDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static HmanLocationDatabase create(final Context context) {
        return Room.databaseBuilder(context, HmanLocationDatabase.class, DB_NAME).build();
    }

    public abstract DaoAccess daoAccess();

}
