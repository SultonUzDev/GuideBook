package com.uzdev.guidebook.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(
    val endDate: String,
    val icon: String,
    val name: String,
    val startDate: String,
    val url: String
) : Parcelable