package com.example.monkeymealproject.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.monkeymealproject.CustomerInfo;

@Database(entities ={CustomerInfo.class}, version = 1,exportSchema = false)
public abstract class customerInfoDB extends RoomDatabase {

    public abstract customerDao infoDao();

    //variable : In order to return DB Instance to Activity
    private static customerInfoDB INSTANCE = null;

    //return Instance of DB
    public static customerInfoDB getInstance(Context context){

        if (INSTANCE == null) {

            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    customerInfoDB.class, "cutomerInfoDB.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();

        }

        return INSTANCE;

    }

    public static void destroyInstance(){

        INSTANCE = null;

    }

}
