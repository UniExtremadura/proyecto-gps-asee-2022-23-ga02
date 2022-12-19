package es.unex.trackstone10.domain

import es.unex.trackstone10.roomdb.CardRepository
import javax.inject.Inject

class GetHeroesByNameUseCase@Inject constructor(private val repository : CardRepository)
{
    suspend operator fun invoke(query: String) = repository.getHeroesByNameFromApi(query)
}