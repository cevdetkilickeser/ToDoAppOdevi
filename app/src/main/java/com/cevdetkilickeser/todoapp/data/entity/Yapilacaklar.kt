package com.cevdetkilickeser.todoapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable
@Entity(tableName = "yapilacaklar")
class Yapilacaklar (@PrimaryKey(autoGenerate = true)
                    @ColumnInfo("yapilacak_id") @NotNull var yapilacak_id:Int,
                    @ColumnInfo("yapilacak_ad") @NotNull var yapilacak_ad:String) : Serializable {
}