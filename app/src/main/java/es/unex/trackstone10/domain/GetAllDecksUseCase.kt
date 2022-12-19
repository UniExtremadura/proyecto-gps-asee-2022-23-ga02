package es.unex.trackstone10.domain

import es.unex.trackstone10.roomdb.DeckRespository
import es.unex.trackstone10.roomdb.Entity.DeckEntity
import javax.inject.Inject

class GetAllDecksUseCase @Inject constructor(private val repository : DeckRespository) {

    operator fun invoke(): List<DeckEntity>{
        return repository.getAllDecks()
    }
}