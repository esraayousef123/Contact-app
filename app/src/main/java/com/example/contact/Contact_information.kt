package com.example.contact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Contact_information : AppCompatActivity() {
    lateinit var Name : TextView
    lateinit var Photo : ImageView
    lateinit var Number : TextView
    lateinit var Description : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_information)
        Name = findViewById(R.id.name)
        Photo = findViewById(R.id.photo)
        Number = findViewById(R.id.numberFiled)
        Description = findViewById(R.id.description_field)
        val intent = intent
        if (intent != null) {
            // get data from intent
            val name = intent.getStringExtra("name")
            val photo = intent.getIntExtra("photo" ,0)
            val number =intent.getStringExtra("number")
            val description = intent.getStringExtra("description")
            Name.text = name
            Photo.setImageResource(photo)
            Number.text = number
            Description.text = description






        }
    }
}