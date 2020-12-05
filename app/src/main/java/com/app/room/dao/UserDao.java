package com.app.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.app.room.model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM USERTABLE ORDER BY id DESC")
    List<User> getAllUser();

    @Query("SELECT * FROM USERTABLE WHERE id=:id")
    List<User> getUserById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    @Delete
    void deleteUser(User user);

    @Query("DELETE FROM USERTABLE WHERE id=:id")
    void deleteUserById(int id);

}
