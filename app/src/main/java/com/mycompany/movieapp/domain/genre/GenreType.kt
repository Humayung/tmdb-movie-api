package com.mycompany.movieapp.domain.genre

sealed class GenreType(
    val id: Int,
    val name: String,
) {
    object Action : GenreType(
        id = 28,
        name = "Action",
    )

    object Adventure : GenreType(
        id = 12,
        name = "Adventure",
    )

    object Animation : GenreType(
        id = 16,
        name = "Animation",
    )

    object Comedy : GenreType(
        id = 35,
        name = "Comedy",
    )

    object Crime : GenreType(
        id = 80,
        name = "Crime",
    )

    object Documentary : GenreType(
        id = 99,
        name = "Documentary",
    )

    object Drama : GenreType(
        id = 18,
        name = "Drama",
    )

    object Family : GenreType(
        id = 10751,
        name = "Family",
    )

    object Fantasy : GenreType(
        id = 14,
        name = "Fantasy",
    )

    object History : GenreType(
        id = 36,
        name = "History",
    )

    object Horror : GenreType(
        id = 27,
        name = "Horror",
    )

    object Music : GenreType(
        id = 10402,
        name = "Music",
    )

    object Mystery : GenreType(
        id = 9648,
        name = "Mystery",
    )

    object Romance : GenreType(
        id = 10749,
        name = "Romance",
    )

    object ScienceFiction : GenreType(
        id = 878,
        name = "Science Fiction",
    )

    object TVMovie : GenreType(
        id = 10770,
        name = "TV Movie",
    )

    object Thriller : GenreType(
        id = 53,
        name = "Thriller",
    )

    object War : GenreType(
        id = 10752,
        name = "War",
    )

    object Western : GenreType(
        id = 37,
        name = "Western",
    )

    companion object {
        fun fromId(id: Int): GenreType {
            return when (id) {
                28 -> Action
                12 -> Adventure
                16 -> Animation
                35 -> Comedy
                80 -> Crime
                99 -> Documentary
                18 -> Drama
                10751 -> Family
                14 -> Fantasy
                36 -> History
                27 -> Horror
                10402 -> Music
                9648 -> Mystery
                10749 -> Romance
                878 -> ScienceFiction
                10770 -> TVMovie
                53 -> Thriller
                10752 -> War
                37 -> Western
                else -> throw IllegalArgumentException("Invalid genre ID")
            }
        }

        fun getAllGenres(): List<GenreType> {
            return listOf(
                Action,
                Adventure,
                Animation,
                Comedy,
                Crime,
                Documentary,
                Drama,
                Family,
                Fantasy,
                History,
                Horror,
                Music,
                Mystery,
                Romance,
                ScienceFiction,
                TVMovie,
                Thriller,
                War,
                Western
            )
        }
    }
}