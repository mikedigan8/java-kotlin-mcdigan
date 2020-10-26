package edu.coloradomesa.cs.climbingdocumentation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class ClimbInfo(
    var type: String,
    var name: String,
    var grade: String,
    var date: String
) : Parcelable

/*
class ClimbInfo : Serializable {
    constructor()
    var type: String = " "
        get() = field
        set(info: String) {
            field = info
        }
    var name: String = " "
        get() = field
        set(info: String) {
            field = info
        }
    var grade: String = " "
        get() = field
        set(info: String) {
            field = info
        }
    var date: String = " "
        get() = field
        set(info: String) {
            field= info
        }
}*/