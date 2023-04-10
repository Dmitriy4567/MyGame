package com.example.mygame

import android.os.Parcel
import android.os.Parcelable

data class DataSelectPerson(val Photo: Int,val name: String, val RazmerRuki: String, val Sila: String, val Lovkost: String, val Intelekt: String, val opisanie: String ): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(Photo)
        parcel.writeString(name)
        parcel.writeString(RazmerRuki)
        parcel.writeString(Sila)
        parcel.writeString(Lovkost)
        parcel.writeString(Intelekt)
        parcel.writeString(opisanie)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataSelectPerson> {
        override fun createFromParcel(parcel: Parcel): DataSelectPerson {
            return DataSelectPerson(parcel)
        }

        override fun newArray(size: Int): Array<DataSelectPerson?> {
            return arrayOfNulls(size)
        }
    }
}
