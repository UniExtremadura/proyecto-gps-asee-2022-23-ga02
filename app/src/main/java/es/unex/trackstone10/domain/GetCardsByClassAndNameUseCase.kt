package es.unex.trackstone10.domain

import es.unex.trackstone10.roomdb.CardRepository
import javax.inject.Inject

class GetCardsByClassAndNameUseCase @Inject constructor(private val repository: CardRepository)
{
    suspend operator fun invoke(query1: String, query2: String) = repository.getCardsByClassName(query1, query2)
}