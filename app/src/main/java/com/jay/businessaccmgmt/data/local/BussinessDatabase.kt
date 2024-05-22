package com.jay.businessaccmgmt.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jay.businessaccmgmt.data.local.dao.ProductDao
import androidx.room.TypeConverters

@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class BusinessDatabase :RoomDatabase() {
    abstract fun ProductDao(): ProductDao

}