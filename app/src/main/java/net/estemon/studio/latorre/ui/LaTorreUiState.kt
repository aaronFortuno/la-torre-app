package net.estemon.studio.latorre.ui

import net.estemon.studio.latorre.data.PlaceCategory
import net.estemon.studio.latorre.data.local.LocalLaTorreDataProvider
import net.estemon.studio.latorre.model.Place

data class LaTorreUiState(
    val categories: Map<PlaceCategory, List<Place>> = emptyMap(),
    val currentCategory: PlaceCategory = PlaceCategory.Culture,
    val currentSelectedPlace: Place = LocalLaTorreDataProvider.defaultPlace,
    val isShowingHomepage: Boolean = true
) {
    val currentCategoryPlaces: List<Place> by lazy {
        categories[currentCategory]!!
    }
}