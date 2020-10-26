package edu.coloradomesa.cs.climbingdocumentation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ClimbInfo(
    var type: String,
    var name: String,
    var grade: String,
    var date: String
) : Parcelable