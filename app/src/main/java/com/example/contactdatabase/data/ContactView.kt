package com.example.contactdatabase.data

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contactdatabase.databinding.ActivityContactViewBinding

class ContactView : AppCompatActivity() {
    private lateinit var binding:ActivityContactViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityContactViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Firstname.text = intent.getStringExtra("first")
        binding.Surname.text = intent.getStringExtra("last")
        binding.phoneno.text = intent.getStringExtra("phone")
    }
}