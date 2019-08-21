package examples.aaronhoskins.com.kotlinintroduction

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class Car(
    @SerializedName("make")
    var make : String,
    @SerializedName("model")
    var model :String,
    @SerializedName("engine")
    var engineSize : String,
    @SerializedName("transmission")
    var transmission : String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "")

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(make)
        parcel.writeString(model)
        parcel.writeString(engineSize)
        parcel.writeString(transmission)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Car> {
        override fun createFromParcel(parcel: Parcel): Car = Car(parcel)
        override fun newArray(size: Int): Array<Car?> = arrayOfNulls(size)
    }
}