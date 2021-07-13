package com.example.contactdatabase.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class ContactViewModel: ViewModel() {

    fun addContactItem(
        contactItem: ContactItem,
        database: ConDatabase){
        database.contactDao().addcontactItem(contactItem)
    }

    fun getAllContactItems(database: ConDatabase)
            : LiveData<List<ContactItem>> {
        return database.contactDao().getAllContactItems()
    }
}