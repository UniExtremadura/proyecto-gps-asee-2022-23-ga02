package es.unex.trackstone10.domain

import es.unex.trackstone10.roomdb.DeckRespository
import es.unex.trackstone10.roomdb.Entity.DeckEntity
import javax.inject.Inject

class CreateDeckUseCase @Inject constructor(private val repository: DeckRespository) {

    operator fun invoke(deck: DeckEntity): Int {
        return repository.addDeck(deck)
    }
}