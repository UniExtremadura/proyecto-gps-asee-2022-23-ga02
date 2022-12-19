package es.unex.trackstone10.domain

import es.unex.trackstone10.roomdb.CardRepository
import javax.inject.Inject

class GetDeckListUseCase @Inject constructor(private val repository: CardRepository)
{
    operator fun invoke(deckId: Int) = repository.getDeckListFromDB(deckId)
}