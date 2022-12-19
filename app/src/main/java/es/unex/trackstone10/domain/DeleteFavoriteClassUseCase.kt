package es.unex.trackstone10.domain

import es.unex.trackstone10.roomdb.CardRepository
import javax.inject.Inject

class DeleteFavoriteClassUseCase @Inject constructor(private val repository: CardRepository) {
    operator fun invoke(id: Int?): Boolean {
        return repository.deleteFavoriteClass(id)
    }
}