package net.estemon.studio.latorre.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import net.estemon.studio.latorre.R
import net.estemon.studio.latorre.data.PlaceCategory

data class Place(
    val id: Long,
    @StringRes val titleResourceId: Int,
    @StringRes val locationResourceId: Int,
    @StringRes val createdByResourceId: Int = R.string.author_1,
    val likes: Int,
    val isBookmarked: Boolean,
    @DrawableRes val imageResourceId: Int,
    @DrawableRes val placeImageBanner: Int,
    @StringRes val detailsResourceId: Int,
    val category: PlaceCategory = PlaceCategory.Culture
)
