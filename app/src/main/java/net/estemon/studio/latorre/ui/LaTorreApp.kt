package net.estemon.studio.latorre.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import net.estemon.studio.latorre.data.PlaceCategory
import net.estemon.studio.latorre.model.Place
import net.estemon.studio.latorre.ui.utils.AppContentType
import net.estemon.studio.latorre.ui.utils.AppNavigationType

@Composable
fun LaTorreApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
) {
    val navigationType: AppNavigationType
    val viewModel: AppViewModel = viewModel()
    val laTorreUiState = viewModel.uiState.collectAsState().value
    val contentType: AppContentType

    when (windowSize) {
        WindowWidthSizeClass.Compact -> { // /* TODO test if it works only with else */
            navigationType = AppNavigationType.BOTTOM_NAVIGATION
            contentType = AppContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Medium -> {
            navigationType = AppNavigationType.NAVIGATION_RAIL
            contentType = AppContentType.LIST_AND_DETAIL_VERTICAL
        }
        WindowWidthSizeClass.Expanded -> {
            navigationType = AppNavigationType.PERMANENT_NAVIGATION_DRAWER
            contentType = AppContentType.LIST_AND_DETAIL_HORIZONTAL
        }
        else -> {
            navigationType = AppNavigationType.BOTTOM_NAVIGATION
            contentType = AppContentType.LIST_ONLY
        }
    }

    LaTorreHomeScreen(
        navigationType = navigationType,
        contentType = contentType,
        appUiState = laTorreUiState,
        onTabPressed = { placeCategory: PlaceCategory ->
            viewModel.updateCurrentCategory(category = placeCategory)
            viewModel.resetHomeScreenStates()
        },
        onPlaceCardPressed = { place: Place ->
            viewModel.updateDetailsScreenStates(
                place = place
            )
        },
        onDetailScreenBackPressed = {
            viewModel.resetHomeScreenStates()
        },
        modifier = modifier
    )
}