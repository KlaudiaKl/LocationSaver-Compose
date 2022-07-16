package com.klaudiakrochmal.map.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LocationEntity(
    var lat: Double,
    var lng: Double,
    @PrimaryKey val id: Int? = null
)
