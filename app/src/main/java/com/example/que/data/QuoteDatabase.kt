package com.example.que.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.que.data.model.Quote

@TypeConverters(Converters::class)
@Database(entities = [Quote::class], version = 2)
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun quoteDao(): QuoteDao

}