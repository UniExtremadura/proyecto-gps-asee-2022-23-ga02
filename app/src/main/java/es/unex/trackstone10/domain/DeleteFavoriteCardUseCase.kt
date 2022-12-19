package es.unex.trackstone10.domain

import es.unex.trackstone10.roomdb.CardRepository
import javax.inject.Inject

class DeleteFavoriteCardUseCase @Inject constructor(private val repository: CardRepository) {

    operator fun invoke(name: String?): Boolean {
        return repository.deleteFavoriteCard(name)
    }
}