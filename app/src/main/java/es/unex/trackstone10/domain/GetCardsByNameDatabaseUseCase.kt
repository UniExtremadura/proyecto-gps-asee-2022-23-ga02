package es.unex.trackstone10.domain

import es.unex.trackstone10.roomdb.CardRepository
import javax.inject.Inject

class GetCardsByNameDatabaseUseCase @Inject constructor(private val repository: CardRepository) {
    operator fun invoke(query: String, userId: Int?): List<CardModel> {
        return repository.getCardsByNameFromDatabase(query, userId)
    }
}