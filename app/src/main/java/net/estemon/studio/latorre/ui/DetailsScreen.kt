package net.estemon.studio.latorre.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import net.estemon.studio.latorre.R
import net.estemon.studio.latorre.data.PlaceCategory
import net.estemon.studio.latorre.model.Place

@Composable
fun AppDetailsScreen(
    appUiState: AppUiState,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
    isFullScreen: Boolean = false
) {
    BackHandler {
        onBackPressed()
    }
    Box(modifier = modifier) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.inverseOnSurface)
                .padding(top = dimensionResource(R.dimen.detail_card_list_padding_top))
        ) {
            item {
                if (isFullScreen) {
                    // TODO AppDetailsScreenTopBar
                }
                AppPlaceDetailsCard(
                    place = appUiState.currentSelectedPlace,
                    category = appUiState.currentCategory,
                    isFullScreen = isFullScreen,
                    modifier = if (isFullScreen) {
                        Modifier.padding(horizontal = dimensionResource(R.dimen.detail_card_outer_padding_horizontal))
                    } else {
                        Modifier.padding(end = dimensionResource(R.dimen.place_list_only_horizontal_padding))
                    }
                )
            }
        }
    }
}

@Composable
private fun AppPlaceDetailsCard(
    place: Place,
    category: PlaceCategory,
    isFullScreen: Boolean = false,
    modifier: Modifier = Modifier
) {

}