package es.unex.trackstone10.domain

import es.unex.trackstone10.roomdb.CardbackRepository
import javax.inject.Inject

class DeleteFavoriteCardbackUseCase @Inject constructor(private val repository: CardbackRepository) {

    operator fun invoke(id: Int?): Boolean {
        return repository.deleteFavoriteCardback(id)
    }
}