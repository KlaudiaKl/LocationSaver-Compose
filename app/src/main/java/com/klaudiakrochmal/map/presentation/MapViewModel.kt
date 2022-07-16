package com.klaudiakrochmal.map.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.MapStyleOptions
import com.klaudiakrochmal.map.domain.model.Location
import com.klaudiakrochmal.map.domain.repository.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val repository: LocationRepository
) : ViewModel() {

    var state by mutableStateOf(MapMode())

    init {
        viewModelScope.launch {
            repository.getLocations().collectLatest {
                locations ->
                state = state.copy(
                    locations = locations
                )
            }
        }
    }

    fun onEvent(event: MapEvent) {
        when (event) {
            is MapEvent.TogglePinkMap -> {
                state = state.copy(
                    properties = state.properties.copy(
                        mapStyleOptions = if (state.isMapPink) {
                            null
                        } else MapStyleOptions(PinkMap.json)
                    ),
                    isMapPink = !state.isMapPink
                )}
                is MapEvent.OnMapLongClick ->{
                    viewModelScope.launch {
                        repository.insertLocation(Location(event.latLng.latitude, event.latLng.longitude))
                    }
                }
            is MapEvent.OnInfoWindowLongClick ->{
                viewModelScope.launch {
                    repository.deleteLocation(event.location)
                }
            }
        }
    }
}
