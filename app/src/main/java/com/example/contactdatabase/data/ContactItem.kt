package com.example.contactdatabase.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class ContactItem(
    @PrimaryKey
    val firstname:String, val lastname:String, val phone1:String
)