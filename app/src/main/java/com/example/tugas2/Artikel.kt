package com.example.tugas2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Artikel(
    val name: String,
    val description: String,
    val photo: Int,
    val publish: String,
    val writer: String,
) : Parcelable
