package net.estemon.studio.latorre.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import net.estemon.studio.latorre.data.PlaceCategory
import net.estemon.studio.latorre.model.Place
import net.estemon.studio.latorre.ui.utils.LaTorreContentType
import net.estemon.studio.latorre.ui.utils.LaTorreNavigationType

@Composable
fun LaTorreApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
) {
    val navigationType: LaTorreNavigationType
    val viewModel: LaTorreViewModel = viewModel()
    val laTorreUiState = viewModel.uiState.collectAsState().value
    val contentType: LaTorreContentType

    when (windowSize) {
        WindowWidthSizeClass.Compact -> { // /* TODO test if it works only with else */
            navigationType = LaTorreNavigationType.BOTTOM_NAVIGATION
            contentType = LaTorreContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Medium -> {
            navigationType = LaTorreNavigationType.NAVIGATION_RAIL
            contentType = LaTorreContentType.LIST_AND_DETAIL_VERTICAL
        }
        WindowWidthSizeClass.Expanded -> {
            navigationType = LaTorreNavigationType.PERMANENT_NAVIGATION_DRAWER
            contentType = LaTorreContentType.LIST_AND_DETAIL_HORIZONTAL
        }
        else -> {
            navigationType = LaTorreNavigationType.BOTTOM_NAVIGATION
            contentType = LaTorreContentType.LIST_ONLY
        }
    }

    LaTorreHomeScreen(
        navigationType = navigationType,
        contentType = contentType,
        laTorreUiState = laTorreUiState,
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