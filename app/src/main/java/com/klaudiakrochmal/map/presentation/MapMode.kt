package com.klaudiakrochmal.map.presentation

import com.google.maps.android.compose.MapProperties
import com.klaudiakrochmal.map.domain.model.Location

data class MapMode(
    val properties: MapProperties = MapProperties(isMyLocationEnabled = true),
    val locations: List<Location> = emptyList(),
    val isMapPink: Boolean = false
)
