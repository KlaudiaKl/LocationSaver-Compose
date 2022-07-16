package com.klaudiakrochmal.map.presentation

import android.view.MenuItem
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.klaudiakrochmal.map.domain.model.Location
import androidx.compose.foundation.lazy.items as items

@Composable
fun DrawerHeader() {
    Box(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 64.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Locations", fontSize = 60.sp)
    }
}

@Composable
fun DrawerBody(
    items: List<Location>,
    modifier: Modifier = Modifier,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick: (Location) -> Unit
) {
    LazyColumn(modifier) {
        items(items) { item ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onItemClick(item)
                }
                .padding(16.dp)) {
                Icon(imageVector = Icons.Default.MyLocation, contentDescription = "location")
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "${item.id.toString()}.) ${item.lat.toString()}, ${item.lng.toString()}",
                    style = itemTextStyle,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}