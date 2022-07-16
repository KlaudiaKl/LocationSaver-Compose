package com.klaudiakrochmal.map.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ToggleOff
import androidx.compose.material.icons.filled.ToggleOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.launch

@Composable
fun MapScreen(
    viewModel: MapViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val scope = rememberCoroutineScope()
    val poland = LatLng(51.9194, 19.1451)
    val defaultCameraPosition = CameraPosition.fromLatLngZoom(poland, 4f)
    val cameraPositionState = rememberCameraPositionState {
        position = defaultCameraPosition
    }
    val scaffoldState = rememberScaffoldState()
    val uiSettings = remember {
        MapUiSettings(zoomControlsEnabled = false)
    }

    Scaffold(scaffoldState = scaffoldState,

        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.onEvent(MapEvent.TogglePinkMap)
            }) {
                Icon(
                    tint = Color.Magenta,
                    imageVector = if (viewModel.state.isMapPink) {
                        Icons.Default.ToggleOff
                    } else Icons.Default.ToggleOn, contentDescription = "Pink Map"
                )
            }
        },
        topBar = {
            AppBar(onNavigationIconClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            })
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            DrawerHeader()
            DrawerBody(
                items = viewModel.state.locations,
                onItemClick = {
                    println("Clicked on ${it.id}")
                    scope.launch {
                        val cameraPosition =
                            CameraPosition.fromLatLngZoom(LatLng(it.lat, it.lng), 16f)
                        cameraPositionState.animate(
                            CameraUpdateFactory.newCameraPosition(
                                cameraPosition
                            )
                        )
                    }
                })
        }
    ) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            properties = viewModel.state.properties,
            uiSettings = uiSettings,
            cameraPositionState = cameraPositionState,
            onMapClick = {
                viewModel.onEvent(MapEvent.OnMapLongClick(it))
            }
        ) {
            viewModel.state.locations.forEach { location ->
                Marker(
                    position = LatLng(location.lat, location.lng),
                    title = "Location: ${location.lat}, ${location.lng}",
                    snippet = "Click to delete",
                    onInfoWindowClick = {
                        viewModel.onEvent(MapEvent.OnInfoWindowLongClick(location))

                    },
                    onClick = {
                        it.showInfoWindow()
                        true
                    },
                    icon = BitmapDescriptorFactory.defaultMarker(
                        BitmapDescriptorFactory.HUE_ROSE
                    )
                )
            }
        }
    }
}