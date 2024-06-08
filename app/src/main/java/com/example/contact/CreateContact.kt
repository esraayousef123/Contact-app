package com.example.contact

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CreateContact : AppCompatActivity() {
    val TAG = "hi"
    lateinit var edt_name: EditText
    lateinit var edt_phoneNumber: EditText
    lateinit var edt_description: EditText
    lateinit var btn_save: Button
    val MIN_NAME_LENGTH = 3
    val EXPECTED_PHONE_NUMBER_LENGTH = 11


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_contact)
        edt_name = findViewById(R.id.edt_contactname)
        edt_phoneNumber = findViewById(R.id.edt_phone_number)
        edt_description = findViewById(R.id.edt_description)
        btn_save = findViewById(R.id.bt_save)

        btn_save.setOnClickListener() {
            val name = edt_name.text.toString()
            val phoneNumber = edt_phoneNumber.text.toString()
            val description = edt_description.text.toString()
            if (name.length < MIN_NAME_LENGTH) {
                Toast.makeText(this, "Name should be at least 3 characters", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (phoneNumber.length != EXPECTED_PHONE_NUMBER_LENGTH) {
                Toast.makeText(this, "Phone number should be 11 digits", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            Toast.makeText(this, "Contact saved", Toast.LENGTH_SHORT).show()

            val newContact = Contact_details(Name = name , Number = phoneNumber, Description = description)
            setResult(Activity.RESULT_OK, Intent().apply {
                putExtra("newContact", newContact)
            })
            finish()



        }


    }




}


