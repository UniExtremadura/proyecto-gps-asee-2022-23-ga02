package es.unex.trackstone10.domain

import es.unex.trackstone10.roomdb.CardbackRepository
import javax.inject.Inject

class GetAllCardbacksFromDatabaseUseCase @Inject constructor(private val repository: CardbackRepository) {

    operator fun invoke(userId: Int?): List<CardBackModel> {
        return repository.getAllCardBacksFromDatabase(userId)
    }
}