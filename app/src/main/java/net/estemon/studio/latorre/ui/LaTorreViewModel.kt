package net.estemon.studio.latorre.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import net.estemon.studio.latorre.data.PlaceCategory
import net.estemon.studio.latorre.data.local.LocalLaTorreDataProvider
import net.estemon.studio.latorre.model.Place

class LaTorreViewModel : ViewModel() {

    // backup private val
    private val _uiState = MutableStateFlow(LaTorreUiState())
    val uiState: StateFlow<LaTorreUiState> = _uiState

    init {
        initializeUIState()
    }

    private fun initializeUIState() {
        val categories: Map<PlaceCategory, List<Place>> =
            LocalLaTorreDataProvider.allPlaces.groupBy { it.category }
        _uiState.value =
            LaTorreUiState(
                categories = categories,
                currentSelectedPlace = categories[PlaceCategory.Cultural]?.get(0)
                    ?: LocalLaTorreDataProvider.defaultPlace
            )
    }
}