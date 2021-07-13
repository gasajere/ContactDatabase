package com.example.contactdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDao {
    @Insert
    fun addcontactItem(contactItem: ContactItem)

    @Query("SELECT* FROM user_table")
    fun getAllContactItems(): LiveData<List<ContactItem>>

    @Delete
    fun delete(contactItem: ContactItem)

}