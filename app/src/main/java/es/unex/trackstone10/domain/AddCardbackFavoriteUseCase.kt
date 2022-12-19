package es.unex.trackstone10.domain

import es.unex.trackstone10.roomdb.CardbackRepository
import javax.inject.Inject

class AddCardbackFavoriteUseCase @Inject constructor(private val repository: CardbackRepository) {

    operator fun invoke(cardback: CardBackModel): Boolean {
        return repository.addFavoriteCardback(cardback)
    }
}