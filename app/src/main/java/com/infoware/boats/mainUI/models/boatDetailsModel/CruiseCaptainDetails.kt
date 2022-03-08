package com.infoware.boats.mainUI.models.boatDetailsModel


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CruiseCaptainDetails(
    @Json(name = "capt_about")
    val captAbout: Any?,
    @Json(name = "capt_age")
    val captAge: Any?,
    @Json(name = "capt_desc")
    val captDesc: Any?,
    @Json(name = "capt_since")
    val captSince: Any?,
    @Json(name = "id")
    val id: String,
    @Json(name = "is_active")
    val isActive: Boolean,
    @Json(name = "user_id")
    val userId: String
)