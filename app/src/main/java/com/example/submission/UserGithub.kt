package com.example.submission

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

data class UserGithub(
    val username: String,
    val name: String,
    val avatar: String,
    val company: String,
    val location:String,
    val repository: Int,
    val follower: Int,
    val following: Int
): Parcelable