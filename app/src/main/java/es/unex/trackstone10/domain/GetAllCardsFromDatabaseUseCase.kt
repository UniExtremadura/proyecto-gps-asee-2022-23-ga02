package es.unex.trackstone10.domain

import es.unex.trackstone10.roomdb.CardRepository
import javax.inject.Inject

class GetAllCardsFromDatabaseUseCase @Inject constructor(private val repository: CardRepository) {

    operator fun invoke(userId: Int?): List<CardModel> {
        return repository.getAllCardsFromDatabase(userId)
    }
}