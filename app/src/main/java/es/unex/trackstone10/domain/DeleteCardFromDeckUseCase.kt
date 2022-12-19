package es.unex.trackstone10.domain

import es.unex.trackstone10.roomdb.CardRepository
import javax.inject.Inject

class DeleteCardFromDeckUseCase @Inject constructor( private val repository: CardRepository)
{
    operator fun invoke(query: String, deckId: Int) = repository.deleteCardFromDeck(query, deckId)
}