package com.example.contact

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var contactrecyclarview: RecyclerView
    lateinit var addContactButton: Button
    var myObjectList: MutableList<Contact_details> = mutableListOf()
    lateinit var adapter :MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        contactrecyclarview = findViewById(R.id.rv_contact)
        addContactButton = findViewById(R.id.bt_add_contact)
        adapter =  MyAdapter(myObjectList)

        var saveContactLauncher: ActivityResultLauncher<Intent> = // to get data from the next activity
            registerForActivityResult( //to get data from the next activity
                ActivityResultContracts.StartActivityForResult()
            ) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val data = result.data!!
                    val newContact = data.getParcelableExtra<Contact_details>("newContact")
                    newContact?.let {
                        myObjectList.add(it) // إضافة الرقم الجديد إلى القائمة
                        updateAdapter()
                    }


                }
            }
        adapter.onItemClickListener =
            MyAdapter.OnItemClickListener { position, item ->
                val intent = Intent(this , Contact_information::class.java)
                intent.putExtra("name", item.Name)
                intent.putExtra("photo", item.Photo)
                intent.putExtra("number", item.Number)
                intent.putExtra("description", item.Description)

                startActivity(intent)
            }

        addContactButton.setOnClickListener() {
            val createContact_intent = Intent(this, CreateContact::class.java)
            saveContactLauncher.launch(createContact_intent)

        }


    }

    private fun updateAdapter() {

        contactrecyclarview.adapter = adapter
    }


}
