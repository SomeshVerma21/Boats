package com.infoware.boats.mainUI.databaseUtils

import androidx.room.*

@Dao
interface DatabaseDao {

    @Query("SELECT * FROM boatdatabase")
    fun getALl():List<BoatsEntity>

    @Insert
    fun addToCollection(boat:BoatsEntity)

    @Query("SELECT * FROM boatdatabase where boatId = :boatId")
    fun checkBoatInfo(boatId:String):List<BoatsEntity>
}