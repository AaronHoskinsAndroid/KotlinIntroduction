package examples.aaronhoskins.com.kotlinintroduction

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class CarTwo : Parcelable {
    @SerializedName("make")
    var make: String? = null
    @SerializedName("model")
    var model: String? = null
    @SerializedName("engine")
    var engineSize: String? = null
    @SerializedName("transmission")
    var transmission: String? = null

    constructor(make: String, model: String, engineSize: String, transmission: String) {
        this.make = make
        this.model = model
        this.engineSize = engineSize
        this.transmission = transmission
    }

    protected constructor(`in`: Parcel) {
        make = `in`.readString()
        model = `in`.readString()
        engineSize = `in`.readString()
        transmission = `in`.readString()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(make)
        parcel.writeString(model)
        parcel.writeString(engineSize)
        parcel.writeString(transmission)
        MainActivity.returnValue()
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<CarTwo> = object : Parcelable.Creator<CarTwo> {
            override fun createFromParcel(`in`: Parcel): CarTwo {
                return CarTwo(`in`)
            }

            override fun newArray(size: Int): Array<CarTwo?> {
                return arrayOfNulls(size)
            }
        }
    }
}
