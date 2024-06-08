package com.example.contact

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val dataList: MutableList<Contact_details>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(viewItem : View):RecyclerView.ViewHolder (viewItem){
        val contactPhoto : ImageView = viewItem.findViewById(R.id.contant_image)
        val contactName : TextView = viewItem.findViewById(R.id.contant_name)
        val PhoneNumber : TextView = viewItem.findViewById(R.id.phone_number)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val contactItem = LayoutInflater.from(parent.context).inflate(R.layout.contact_item,parent , false)
        return MyViewHolder(contactItem)

    }

    override fun getItemCount(): Int =  dataList.size



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val contactItemFromList = dataList[position]
        holder.contactName.text= contactItemFromList.Name
        holder.contactPhoto.setImageResource(contactItemFromList.Photo)
        holder.PhoneNumber.text = contactItemFromList.Number
        if(onItemClickListener!= null)
        {
            holder.itemView.setOnClickListener{
                onItemClickListener?.onItemClick(position ,dataList[position] )
            }
        }


    }
    var onItemClickListener : OnItemClickListener?= null
   fun interface OnItemClickListener{
        fun onItemClick(position: Int , item :Contact_details )
    }
}