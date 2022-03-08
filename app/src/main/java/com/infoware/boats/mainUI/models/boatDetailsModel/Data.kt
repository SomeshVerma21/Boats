package com.infoware.boats.mainUI.models.boatDetailsModel


data class Data(
    val captain: Captain,
    val cruiseAmenities: String,
    val cruise_captain_id: String,
    val cruise_desc: String,
    val cruiseFishingTech: String,
    val cruiseFishingType: String,
    val cruiseGallery: List<Any>,
    val cruise_height: String,
    val cruise_large_img: String,
    val cruiseLiked: Boolean,
    val cruise_master_id: String,
    val cruiseMobileNumber: Int,
    val cruise_name: String,
    val cruiseOwnerAdminOwnerId: String,
    val cruise_pax_capacity: Int,
    val cruise_price: Int,
    val cruise_speed: String,
    val cruise_thumb_img: String,
    val cruise_width: String,
    val id: String,
    val is_active: Boolean,
    val isDiwaniyaExist: Boolean,
    val minimumBookingTime: String,
    val pickUp: PickUp,
    val ratingsList: List<Any>,
    val scrollBanners: List<ScrollBanner>
)