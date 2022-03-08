package com.infoware.boats.mainUI.databaseUtils

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "boatdatabase")
data class BoatsEntity(
    @PrimaryKey(autoGenerate = true)
    val uid:Int?,

    @ColumnInfo(name = "boatId")
    val boatId:String,

    @ColumnInfo(name = "price")
    val boatPrice:Int,

    @ColumnInfo(name = "imgUrl")
    val imgUrl:String,

    @ColumnInfo(name = "name")
    val name:String
)
