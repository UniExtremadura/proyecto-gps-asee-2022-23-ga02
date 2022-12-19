package es.unex.trackstone10.roomdb


import android.content.Context
import es.unex.trackstone10.Application
import es.unex.trackstone10.domain.*
import es.unex.trackstone10.roomdb.dao.CardDao
import es.unex.trackstone10.roomdb.dao.ClassDao
import es.unex.trackstone10.roomdb.dao.DeckDao
import es.unex.trackstone10.roomdb.dao.DeckListDao
import javax.inject.Inject

class CardRepository @Inject constructor(
    private val api: ApiFunctionalityService,
    private val cardDao: CardDao,
    private val classDao: ClassDao,
    private val deckListDao: DeckListDao,
    private val deckDao: DeckDao
) {

    val sharedPreferences =
        Application.instance?.getSharedPreferences("userid", Context.MODE_PRIVATE)

    suspend fun getAllCardsFromApi(): List<CardModel> = api.getCards()
    suspend fun getHeroesFromApi(): List<CardModel> = api.getHeroes()

    suspend fun getCardsByNameFromApi(query: String): List<CardModel> = api.getCardsByName(query)
    suspend fun getHeroesByNameFromApi(query: String): List<CardModel> = api.getHeroesByName(query)

    suspend fun getCardsByClassFromApi(query: String): List<CardModel> = api.getCardsByClass(query)
    suspend fun getCardsByClassName(query1: String, query2: String) =
        api.getCardsByClassAndName(query1, query2)

    fun addCardFavorite(card: CardModel, userId: Int): Boolean {
        val insertedCard = cardDao.insert(card.toCardEntity(userId)).toInt()
        return insertedCard != 0
    }

    fun getDeckListFromDB(deckId: Int): List<CardModel> {
        val response = deckListDao.getAllByDeckId(deckId)
        return response?.map { it.toCardModel() } ?: emptyList()
    }


    fun getCardFromDeckDB(query: String, deckId: Int): List<CardModel> {
        val query2 = "%$query%"
        val response = deckListDao.getCardsByName(query2, deckId)
        return response?.map { it.toCardModel() } ?: emptyList()
    }

    fun deleteCardFromDeck(query: String, deckId: Int): Int {
        when (deckListDao.checkCopies(deckId, query)) {
            2 -> {
                deckListDao.decCopies(deckId, query)
                return 2
            }
            1 -> {
                deckListDao.deleteCardDeck(deckId, query)
                return 1
            }
        }
        return 3
    }

    fun deleteFavoriteCard(name: String?): Boolean {
        val deletedCard = cardDao.deleteByName(name)
        return deletedCard != 0
    }

    fun deleteFavoriteClass(id: Int?): Boolean {
        val deleteHero = classDao.deleteFromId(id)
        return deleteHero != 0
    }

    fun getAllCardsFromDatabase(userId: Int?): List<CardModel> = cardDao.getAllById(userId)?.map { it.toCardModel() } ?: emptyList()

    fun getCardsByNameFromDatabase(query: String,userId : Int?): List<CardModel> {
        val query2 = "%$query%"
        return cardDao.getByNameAndId(query2,userId)?.map { it.toCardModel() } ?: emptyList()
    }
    fun getAllHerosFromDatabase(userId: Int?): List<CardModel> = classDao.getAllById(userId)?.map { it.toCardModel()} ?: emptyList()

    fun getHeroesByNameFromDatabase(query: String,userId: Int?): List <CardModel>{
        val query2 = "%$query%"
        return classDao.getByNameAndId(query2,userId)?.map { it.toCardModel() } ?: emptyList()
    }

    fun addHeroFavorite(hero: CardModel, userId: Int): Boolean {
        val insertedHero = classDao.insert(hero.toClassEntity(userId)).toInt()
        return insertedHero != 0
    }


}