package org.ucb.mobile3p.movies.domain.repository

import org.ucb.mobile3p.movies.domain.model.MovieModel

interface MovieRepository {
    suspend fun getMovies(): List<MovieModel>
}
