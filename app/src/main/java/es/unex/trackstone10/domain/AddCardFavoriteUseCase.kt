package es.unex.trackstone10.domain

import es.unex.trackstone10.roomdb.CardRepository
import javax.inject.Inject

class AddCardFavoriteUseCase @Inject constructor(private val repository: CardRepository) {

    operator fun invoke(card: CardModel, userId: Int): Boolean {
        return repository.addCardFavorite(card, userId)
    }
}