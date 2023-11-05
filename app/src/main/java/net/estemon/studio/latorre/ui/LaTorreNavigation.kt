package net.estemon.studio.latorre.ui

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.estemon.studio.latorre.data.PlaceCategory

@Composable
fun LaTorreNavigationRail(
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
    }
}