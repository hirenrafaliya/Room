package com.app.room.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.app.room.dao.UserDao;
import com.app.room.model.User;

@Database(entities = {User.class}, exportSchema = false, version = 1)
public abstract class UserDatabase extends RoomDatabase{

    public static UserDatabase userDatabase;

    public static UserDatabase getInstance(Context context) {
        if (userDatabase == null) {
            userDatabase = Room.databaseBuilder(context, UserDatabase.class, "UserDB")
                    .build();
        }
        return userDatabase;
    }

    public abstract UserDao userDao();

}
