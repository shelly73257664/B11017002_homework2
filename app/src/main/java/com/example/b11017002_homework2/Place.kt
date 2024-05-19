// Place.kt
package com.example.b11017002_homework2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Place(
    val name: String,
    val imageResId: Int,
    val description: String,
    val buttonText: String,
    val latitude:Double,
    val longitude: Double
) : Parcelable
