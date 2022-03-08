package com.infoware.boats.mainUI.models.boatDetailsModel


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ScrollBanner(
    @Json(name = "cruise_banner_img")
    val cruiseBannerImg: String,
    @Json(name = "cruise_banner_name")
    val cruiseBannerName: String,
    @Json(name = "cruise_banner_thumb")
    val cruiseBannerThumb: String,
    @Json(name = "id")
    val id: String
)