package com.sample.watch.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sample.watch.model.Movie

@Database(entities = [ Movie::class ], version=1)
@TypeConverters(TypeConverters::class)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun localDao(): LocalDao
}
