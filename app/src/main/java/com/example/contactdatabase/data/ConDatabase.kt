package com.example.contactdatabase.data


import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ContactItem::class],
    version = 1
)
abstract class ConDatabase: RoomDatabase() {
    abstract fun contactDao():ContactDao

}