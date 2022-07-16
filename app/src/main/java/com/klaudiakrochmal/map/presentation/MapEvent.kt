package com.klaudiakrochmal.map.presentation

import com.google.android.gms.maps.model.LatLng
import com.klaudiakrochmal.map.domain.model.Location

sealed class MapEvent {
    object TogglePinkMap: MapEvent()
    data class OnMapLongClick(val latLng: LatLng): MapEvent()
    data class OnInfoWindowLongClick(val location: Location): MapEvent()
}