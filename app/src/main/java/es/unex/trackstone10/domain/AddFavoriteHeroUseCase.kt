package es.unex.trackstone10.domain

import es.unex.trackstone10.roomdb.CardRepository
import javax.inject.Inject

class AddFavoriteHeroUseCase @Inject constructor(private val repository: CardRepository)
{
    operator fun invoke(hero: CardModel, userId: Int) = repository.addHeroFavorite(hero, userId)
}