package com.infoware.boats.mainUI.databaseUtils

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BoatsEntity::class], version = 1)
abstract class BoatDatabase : RoomDatabase(){
    abstract val taskDatabaseDao:DatabaseDao

    companion object{
        @Volatile
        private var INSTANCE:BoatDatabase?=null
        fun getInstance(context: Context):BoatDatabase{
            synchronized(this){
                var instance = INSTANCE
                if (instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BoatDatabase::class.java,
                        "boatdatabase"
                    ).fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}