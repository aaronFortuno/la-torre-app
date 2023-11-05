package net.estemon.studio.latorre.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import net.estemon.studio.latorre.R
import net.estemon.studio.latorre.model.Place

@Composable
fun AppListOnlyContent(
    appUiState: AppUiState,
    onPlaceCardPressed: (Place) -> Unit,
    modifier: Modifier = Modifier
) {
    val places = appUiState.currentCategoryPlaces

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(
            dimensionResource(R.dimen.place_list_item_vertical_spacing)
        )
    ) {
        item {
            AppHomeTopBar(
                modifier
                    .fillMaxWidth()
                    .padding(vertical = dimensionResource(R.dimen.topbar_padding_vertical))
            )
        }
        items(places, key = { place -> place.id }) {place ->
            AppListItem(
                place = place,
                selected = appUiState.currentSelectedPlace.id == place.id,
                onCardClick = {
                    onPlaceCardPressed(place)
                }
            )
        }
    }
}

@Composable
fun AppListAndDetailHorizontalContent(
    appUiState: AppUiState,
    onPlaceCardPressed: (Place) -> Unit,
    modifier: Modifier = Modifier
) {
    val places = appUiState.currentCategoryPlaces
    Row(modifier = modifier) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(
                    end = dimensionResource(R.dimen.list_and_detail_list_padding_end),
                    top = dimensionResource(R.dimen.list_and_detail_list_padding_top)
                ),
            verticalArrangement = Arrangement.spacedBy(
                dimensionResource(R.dimen.place_list_item_vertical_spacing)
            )
        ) {
            items(places, key = { place -> place.id }) {place ->
                AppListItem(
                    place = place,
                    selected = appUiState.currentSelectedPlace.id == place.id,
                    onCardClick = {
                        onPlaceCardPressed(place)
                    }
                )
            }
        }
        AppDetailsScreen(
            appUiState = appUiState,
            onBackPressed = {},
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun AppListAndDetailVerticalContent(
    appUiState: AppUiState,
    onPlaceCardPressed: (Place) -> Unit,
    modifier: Modifier = Modifier
) {
    val places = appUiState.currentCategoryPlaces

}

// TODO card title
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppListItem(
    place: Place,
    selected: Boolean,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = if (selected) {
                MaterialTheme.colorScheme.primaryContainer
            } else {
                MaterialTheme.colorScheme.secondaryContainer
            }
        ),
        onClick = onCardClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.place_list_item_inner_padding))
        ) {
            Text(
                text = stringResource(place.titleResourceId),
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .padding(
                        top = dimensionResource(R.dimen.place_list_item_title_subtitle_spacing),
                        bottom = dimensionResource(R.dimen.place_list_item_subtitle_content_spacing)
                    )
            )
            Text(
                text = stringResource(place.detailsResourceId),
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

// TODO logo and profile image
@Composable
private fun AppHomeTopBar(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {

    }
}