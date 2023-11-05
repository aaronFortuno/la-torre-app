package net.estemon.studio.latorre.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import net.estemon.studio.latorre.data.PlaceCategory
import net.estemon.studio.latorre.data.local.LocalLaTorreDataProvider
import net.estemon.studio.latorre.model.Place

class AppViewModel : ViewModel() {

    // backup private val
    private val _uiState = MutableStateFlow(AppUiState())
    val uiState: StateFlow<AppUiState> = _uiState

    init {
        initializeUIState()
    }

    private fun initializeUIState() {
        val categories: Map<PlaceCategory, List<Place>> =
            LocalLaTorreDataProvider.allPlaces.groupBy { it.category }
        _uiState.value =
            AppUiState(
                categories = categories,
                currentSelectedPlace = categories[PlaceCategory.Culture]?.get(0)
                    ?: LocalLaTorreDataProvider.defaultPlace
            )
    }

    fun updateDetailsScreenStates(place: Place) {
        _uiState.update {
            it.copy(
                currentSelectedPlace = place,
                isShowingHomepage = false
            )
        }
    }

    fun resetHomeScreenStates() {
        _uiState.update {
            it.copy(
                currentSelectedPlace = it.categories[it.currentCategory]?.get(0)
                    ?: LocalLaTorreDataProvider.defaultPlace,
                isShowingHomepage = true
            )
        }
    }

    fun updateCurrentCategory(category: PlaceCategory) {
        _uiState.update {
            it.copy(
                currentCategory = category
            )
        }
    }

}