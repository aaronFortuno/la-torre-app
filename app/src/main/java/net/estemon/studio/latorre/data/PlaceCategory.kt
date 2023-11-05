package net.estemon.studio.latorre.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmarks
import androidx.compose.material.icons.filled.EscalatorWarning
import androidx.compose.material.icons.filled.Forest
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.TheaterComedy

enum class PlaceCategory {
    Nature, Culture, Restaurant, Shopping, Family
}

val iconNature = Icons.Default.Forest
val iconCulture = Icons.Default.TheaterComedy
val iconRestaurant = Icons.Default.Restaurant
val iconShopping = Icons.Default.ShoppingBag
val iconFamily = Icons.Default.EscalatorWarning
val iconBookmarked = Icons.Default.Bookmarks