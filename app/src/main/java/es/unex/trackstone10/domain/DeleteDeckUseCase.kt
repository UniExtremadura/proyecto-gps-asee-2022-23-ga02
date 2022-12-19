package es.unex.trackstone10.domain

import es.unex.trackstone10.roomdb.DeckRespository
import javax.inject.Inject

class DeleteDeckUseCase @Inject constructor(private val repository: DeckRespository) {

    operator fun invoke(deckId: Int): Boolean {
        return repository.deleteDeck(deckId)
    }
}