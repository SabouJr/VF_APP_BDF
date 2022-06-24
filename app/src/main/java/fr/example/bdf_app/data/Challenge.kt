package fr.example.bdf_app.data

import androidx.annotation.DrawableRes
import fr.example.bdf_app.R

data class Challenge(
    val id: Int,
    @DrawableRes val firstPicto: Int = R.drawable.bg_radius_stoke_black,
    @DrawableRes val secondPicto: Int = R.drawable.ic_heart,
    val value: String
)