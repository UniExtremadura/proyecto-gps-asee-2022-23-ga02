package es.unex.trackstone10.domain

import es.unex.trackstone10.roomdb.CardbackRepository
import javax.inject.Inject

class GetCarbacksByNameFromApiUseCase @Inject constructor( private  val repository: CardbackRepository)
{
    suspend operator fun invoke(query:String) = repository.getCardBacksByName(query)
}