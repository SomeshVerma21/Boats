package com.infoware.boats.mainUI.models.boatDetailsModel


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PickUp(
    @Json(name = "cruise_id")
    val cruiseId: String,
    @Json(name = "id")
    val id: String,
    @Json(name = "pick_id")
    val pickId: String,
    @Json(name = "pickup_address")
    val pickupAddress: String,
    @Json(name = "pickup_desc")
    val pickupDesc: String,
    @Json(name = "pickup_lat")
    val pickupLat: String,
    @Json(name = "pickup_long")
    val pickupLong: String,
    @Json(name = "pickup_map")
    val pickupMap: String,
    @Json(name = "pickup_other_detail")
    val pickupOtherDetail: String
)