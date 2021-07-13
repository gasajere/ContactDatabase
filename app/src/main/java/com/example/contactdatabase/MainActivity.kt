package com.example.contactdatabase

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.contactdatabase.data.*
import com.example.contactdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myContactAdapter: ContactAdapter
    private lateinit var myContactlist:MutableList<ContactItem>
    private lateinit var viewModel: ContactViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[ContactViewModel::class.java]
        myContactlist= mutableListOf()
        myContactAdapter= ContactAdapter(myContactlist){
            val intent = Intent(this, ContactView::class.java)
            intent.putExtra("first", it.firstname)
            intent.putExtra("last", it.lastname)
            intent.putExtra("phone", it.phone1)
            startActivity(intent)
        }
        binding.recyclerView.adapter = myContactAdapter

        val db = Room.databaseBuilder(
            applicationContext,
            ConDatabase::class.java, "contact-database"
        ).allowMainThreadQueries().build()


        viewModel.getAllContactItems(db).observe(this) { it ->
            myContactAdapter = ContactAdapter(it) {
                val intent = Intent(this, ContactView::class.java)
                intent.putExtra("first", it.firstname)
                intent.putExtra("last", it.lastname)
                intent.putExtra("phone", it.phone1)
                startActivity(intent)
            }
            binding.recyclerView.adapter = myContactAdapter
            myContactAdapter.notifyDataSetChanged()
        }
        binding.button.setOnClickListener {
            val firstname : String = binding.eT.text.toString()
            val lastname : String = binding.eT2.text.toString()
            val phonenumber : String = binding.eT3.text.toString()





            val contactItem = ContactItem(firstname,lastname,phonenumber)
            viewModel.addContactItem(contactItem, db)


            myContactAdapter.notifyDataSetChanged()
        }
    }

}