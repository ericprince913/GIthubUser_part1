package com.example.aplikasigithubuser

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hero(
    val Avatar: Int,
    val Name: String,
    val Username: String,
    val Follower: String,
    val Following: String,
    val Company: String,
    val Location: String,
    val Repository: String
) :Parcelable
