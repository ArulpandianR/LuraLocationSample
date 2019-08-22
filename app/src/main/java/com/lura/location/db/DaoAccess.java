package com.lura.location.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface DaoAccess {

    @Insert
    Long insertTask(LocationDetails locationDetail);

    @Query("SELECT * FROM LocationDetails ORDER BY created_at desc")
    List<LocationDetails> fetchAllDetails();

    @Query("DELETE FROM LocationDetails")
    void deleteAllDetails();
}
