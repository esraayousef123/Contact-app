package com.example.contact

import android.os.Parcel
import android.os.Parcelable

data class Contact_details(val Name: String, val Number: String, val Photo: Int = R.drawable.contact_avatarphoto, val Description: String?) :
    Parcelable {
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Name)
        parcel.writeString(Number)
        parcel.writeInt(Photo)
        parcel.writeString(Description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Contact_details> {
        override fun createFromParcel(parcel: Parcel): Contact_details {
            val name = parcel.readString()
            val number = parcel.readString()
            val photo = parcel.readInt()
            val description = parcel.readString()

            return Contact_details(name ?: "", number ?: "", photo, description)
        }

        override fun newArray(size: Int): Array<Contact_details?> {
            return arrayOfNulls(size)
        }
    }
}