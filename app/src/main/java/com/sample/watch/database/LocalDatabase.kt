package com.sample.watch.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sample.watch.model.Movie

@Database(entities = [ Movie::class ], version=1)
@TypeConverters(LocalTypeConverters::class)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun localDao(): LocalDao
}
