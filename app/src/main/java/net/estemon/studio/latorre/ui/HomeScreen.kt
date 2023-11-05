package net.estemon.studio.latorre.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import net.estemon.studio.latorre.R
import net.estemon.studio.latorre.data.PlaceCategory
import net.estemon.studio.latorre.data.iconFamily
import net.estemon.studio.latorre.data.iconCulture
import net.estemon.studio.latorre.data.iconNature
import net.estemon.studio.latorre.data.iconRestaurant
import net.estemon.studio.latorre.data.iconShopping
import net.estemon.studio.latorre.model.Place
import net.estemon.studio.latorre.ui.utils.AppContentType
import net.estemon.studio.latorre.ui.utils.AppNavigationType

@Composable
fun LaTorreHomeScreen(
    navigationType: AppNavigationType,
    contentType: AppContentType,
    appUiState: AppUiState,
    onTabPressed: (PlaceCategory) -> Unit,
    onPlaceCardPressed: (Place) -> Unit,
    onDetailScreenBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    val navigationItemContentList = listOf(
        NavigationItemContent(
            category = PlaceCategory.Nature,
            icon = iconNature,
            text = stringResource(R.string.nav_nature)
        ),
        NavigationItemContent(
            category = PlaceCategory.Culture,
            icon = iconCulture,
            text = stringResource(R.string.nav_culture)
        ),
        NavigationItemContent(
            category = PlaceCategory.Restaurant,
            icon = iconRestaurant,
            text = stringResource(R.string.nav_restaurant)
        ),
        NavigationItemContent(
            category = PlaceCategory.Shopping,
            icon = iconShopping,
            text = stringResource(R.string.nav_shopping)
        ),
        NavigationItemContent(
            category = PlaceCategory.Family,
            icon = iconFamily,
            text = stringResource(R.string.nav_family)
        ),

        )
}

@Composable
private fun LaTorreAppContent(
    navigationType: AppNavigationType,
    contentType: AppContentType,
    appUiState: AppUiState,
    onTabPressed: (PlaceCategory) -> Unit,
    onPlaceCardPressed: (Place) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Row(modifier = Modifier.fillMaxSize()) {
            AnimatedVisibility(visible = navigationType == AppNavigationType.NAVIGATION_RAIL) {
                val navigationRailContentDescription = stringResource(R.string.navigation_rail)
                AppNavigationRail(
                    currentCategory = appUiState.currentCategory,
                    onTabPressed = onTabPressed,
                    navigationItemContentList = navigationItemContentList,
                    modifier = Modifier
                        .testTag(navigationRailContentDescription)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.inverseOnSurface)
            ) {
                if (contentType == AppContentType.LIST_AND_DETAIL_HORIZONTAL) {
                    AppListAndDetailHorizontalContent(
                        appUiState = appUiState,
                        onPlaceCardPressed = onPlaceCardPressed,
                        modifier = Modifier
                            .weight(1f)
                    )
                } else if (contentType == AppContentType.LIST_AND_DETAIL_VERTICAL) {
                    AppListAndDetailVerticalContent(
                        appUiState = appUiState,
                        onPlaceCardPressed = onPlaceCardPressed,
                        modifier = Modifier
                            .weight(1f)
                    )
                } else {
                    AppListOnlyContent(
                        appUiState = appUiState,
                        onPlaceCardPressed = onPlaceCardPressed,
                        modifier = Modifier
                            .weight(1f)
                            .padding(
                                horizontal = dimensionResource(R.dimen.place_list_only_horizontal_padding)
                            )
                    )
                }
            }
        }
    }
}


// TODO check if it have to been private
data class NavigationItemContent(
    val category: PlaceCategory,
    val icon: ImageVector,
    val text: String
)