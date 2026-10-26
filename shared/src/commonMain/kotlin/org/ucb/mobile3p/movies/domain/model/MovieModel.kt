package org.ucb.mobile3p.movies.domain.model

import org.ucb.mobile3p.movies.domain.vo.PosterPath

data class MovieModel(
    val title: String,
    val description: String,
    val posterPath: PosterPath

)
