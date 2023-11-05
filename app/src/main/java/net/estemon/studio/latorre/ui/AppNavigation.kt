package net.estemon.studio.latorre.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import net.estemon.studio.latorre.R
import net.estemon.studio.latorre.data.PlaceCategory
import net.estemon.studio.latorre.data.iconBookmarked


@Composable
fun AppBottomNavigationBar(
    currentCategory: PlaceCategory,
    onTabPressed: (PlaceCategory) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationBarItem(
                selected = currentCategory == navItem.category,
                onClick = { onTabPressed(navItem.category) },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.text
                    )
                }
            )
        }
        // TODO bookmarked NavigationBarITem
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { iconBookmarked }
        )
    }
}

@Composable
fun AppNavigationRail(
    currentCategory: PlaceCategory,
    onTabPressed: (PlaceCategory) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    NavigationRail(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationRailItem(
                selected = currentCategory == navItem.category,
                onClick = { onTabPressed(navItem.category) },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.text
                    )
                }
            )
        }
        // TODO bookmarked NavigationRailITem
        NavigationRailItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { iconBookmarked }
        )
    }
}

@Composable
fun AppNavigationDrawerContent(
    selectedDestination: PlaceCategory,
    onTabPressed: (PlaceCategory) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        NavigationDrawerHeader(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.drawer_padding_content))
        )
        for (navItem in navigationItemContentList) {
            NavigationDrawerItem(
                label = {
                    Text(
                        text = navItem.text,
                        modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.drawer_padding_header))
                        )
                },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.text
                    )
                },
                selected = selectedDestination == navItem.category,
                onClick = { onTabPressed(navItem.category) }
            )
        }
        // TODO bookmarked NavigationDrawerItem
        NavigationDrawerItem(
            label = { stringResource(R.string.nav_bookmarked) },
            selected = false,
            onClick = { /*TODO*/ },
            icon = { iconBookmarked }
        )
    }
}

@Composable
private fun NavigationDrawerHeader(
    modifier: Modifier = Modifier
) {

}