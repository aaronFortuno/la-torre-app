package net.estemon.studio.latorre.data.local

import net.estemon.studio.latorre.R
import net.estemon.studio.latorre.data.PlaceCategory
import net.estemon.studio.latorre.model.Place

object LocalLaTorreDataProvider {

    val allPlaces = listOf(
        Place(
            id = 1,
            titleResourceId = R.string.title_1,
            locationResourceId = R.string.location_1,
            likes = 1,
            isBookmarked = false,
            imageResourceId = R.drawable.ic_launcher_background,
            placeImageBanner = R.drawable.ic_launcher_background,
            detailsResourceId = R.string.details_1
        ),
        Place(
            id = 2,
            titleResourceId = R.string.title_1,
            locationResourceId = R.string.location_1,
            likes = 2,
            isBookmarked = true,
            imageResourceId = R.drawable.ic_launcher_background,
            placeImageBanner = R.drawable.ic_launcher_background,
            detailsResourceId = R.string.details_1
        ),
        Place(
            id = 3,
            titleResourceId = R.string.title_1,
            locationResourceId = R.string.location_1,
            likes = 3,
            isBookmarked = false,
            imageResourceId = R.drawable.ic_launcher_background,
            placeImageBanner = R.drawable.ic_launcher_background,
            detailsResourceId = R.string.details_1
        ),
        Place(
            id = 4,
            titleResourceId = R.string.title_1,
            locationResourceId = R.string.location_1,
            likes = 4,
            isBookmarked = true,
            imageResourceId = R.drawable.ic_launcher_background,
            placeImageBanner = R.drawable.ic_launcher_background,
            detailsResourceId = R.string.details_1
        ),
        Place(
            id = 5,
            titleResourceId = R.string.title_1,
            locationResourceId = R.string.location_1,
            likes = 5,
            isBookmarked = false,
            imageResourceId = R.drawable.ic_launcher_background,
            placeImageBanner = R.drawable.ic_launcher_background,
            detailsResourceId = R.string.details_1,
            category = PlaceCategory.Nature
        ),
        Place(
            id = 6,
            titleResourceId = R.string.title_1,
            locationResourceId = R.string.location_1,
            likes = 6,
            isBookmarked = false,
            imageResourceId = R.drawable.ic_launcher_background,
            placeImageBanner = R.drawable.ic_launcher_background,
            detailsResourceId = R.string.details_1,
            category = PlaceCategory.Nature
        ),
        Place(
            id = 7,
            titleResourceId = R.string.title_1,
            locationResourceId = R.string.location_1,
            likes = 7,
            isBookmarked = true,
            imageResourceId = R.drawable.ic_launcher_background,
            placeImageBanner = R.drawable.ic_launcher_background,
            detailsResourceId = R.string.details_1,
            category = PlaceCategory.Restaurant
        ),
        Place(
            id = 8,
            titleResourceId = R.string.title_1,
            locationResourceId = R.string.location_1,
            likes = 8,
            isBookmarked = false,
            imageResourceId = R.drawable.ic_launcher_background,
            placeImageBanner = R.drawable.ic_launcher_background,
            detailsResourceId = R.string.details_1,
            category = PlaceCategory.Shopping
        ),
        Place(
            id = 9,
            titleResourceId = R.string.title_1,
            locationResourceId = R.string.location_1,
            likes = 9,
            isBookmarked = true,
            imageResourceId = R.drawable.ic_launcher_background,
            placeImageBanner = R.drawable.ic_launcher_background,
            detailsResourceId = R.string.details_1,
            category = PlaceCategory.Shopping
        ),
        Place(
            id = 10,
            titleResourceId = R.string.title_1,
            locationResourceId = R.string.location_1,
            likes = 10,
            isBookmarked = true,
            imageResourceId = R.drawable.ic_launcher_background,
            placeImageBanner = R.drawable.ic_launcher_background,
            detailsResourceId = R.string.details_1,
            category = PlaceCategory.Family
        ),
        Place(
            id = 11,
            titleResourceId = R.string.title_1,
            locationResourceId = R.string.location_1,
            likes = 11,
            isBookmarked = false,
            imageResourceId = R.drawable.ic_launcher_background,
            placeImageBanner = R.drawable.ic_launcher_background,
            detailsResourceId = R.string.details_1,
            category = PlaceCategory.Culture
        ),
        Place(
            id = 12,
            titleResourceId = R.string.title_1,
            locationResourceId = R.string.location_1,
            likes = 12,
            isBookmarked = true,
            imageResourceId = R.drawable.ic_launcher_background,
            placeImageBanner = R.drawable.ic_launcher_background,
            detailsResourceId = R.string.details_1,
            category = PlaceCategory.Family
        ),
        Place(
            id = 13,
            titleResourceId = R.string.title_1,
            locationResourceId = R.string.location_1,
            likes = 13,
            isBookmarked = true,
            imageResourceId = R.drawable.ic_launcher_background,
            placeImageBanner = R.drawable.ic_launcher_background,
            detailsResourceId = R.string.details_1,
            category = PlaceCategory.Culture
        )
    )
    fun get(id: Long): Place? {
        return allPlaces.firstOrNull { it.id.toLong() == id }
    }

    val defaultPlace = allPlaces.get(0)
}