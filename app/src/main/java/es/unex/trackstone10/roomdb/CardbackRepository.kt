package es.unex.trackstone10.roomdb

import android.content.Context
import es.unex.trackstone10.Application
import es.unex.trackstone10.domain.*
import es.unex.trackstone10.roomdb.dao.CardBackDao
import javax.inject.Inject

class CardbackRepository @Inject constructor(
    private val api: ApiFunctionalityService, private val cardBackDao: CardBackDao
) {
    val sharedPreferences =
        Application.instance?.getSharedPreferences("userid", Context.MODE_PRIVATE)
    val userId = sharedPreferences?.getInt("userid", 0)
    val uId = userId ?: 0

    fun deleteFavoriteCardback(id: Int?): Boolean {
        val deleteCardback = cardBackDao.deleteFromId(id)
        return deleteCardback != 0
    }

    fun addFavoriteCardback(cardBack: CardBackModel): Boolean {
        val insertedCardback = cardBackDao.insert(cardBack.toCardBackEntity(uId)).toInt()
        return insertedCardback != 0
    }

    suspend fun getAllCardBacksFromApi() = api.getCardBacks()
    suspend fun getCardBacksByName(query: String) = api.getCardBacksByName(query)

    fun getAllCardBacksFromDatabase(userId: Int?): List<CardBackModel> = cardBackDao.getAllById(userId)?.map { it.toCardBackModel() } ?: emptyList()

    fun getCardBackByNameFromDatabase(query: String,userId: Int?): List<CardBackModel>{
        val query2 = "%$query%"
        return cardBackDao.getByNameAndId(query2,userId)?.map { it.toCardBackModel()} ?: emptyList()
    }

}