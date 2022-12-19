package es.unex.trackstone10.domain

import es.unex.trackstone10.roomdb.CardbackRepository
import javax.inject.Inject

class GetCardbackByNameFromDatabaseUseCase @Inject constructor(private val repository: CardbackRepository) {

    operator fun invoke(query: String, userId: Int?): List<CardBackModel> {
        return repository.getCardBackByNameFromDatabase(query, userId)
    }
}