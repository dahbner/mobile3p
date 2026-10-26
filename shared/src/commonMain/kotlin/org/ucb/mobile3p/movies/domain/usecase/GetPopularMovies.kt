package org.ucb.mobile3p.movies.domain.usecase

import org.ucb.mobile3p.movies.domain.model.MovieModel
import org.ucb.mobile3p.movies.domain.repository.MovieRepository

class GetPopularMovies(
    private val repository: MovieRepository
) {

    suspend fun invoke(): List<MovieModel> {
        return repository.getMovies()
    }
}
