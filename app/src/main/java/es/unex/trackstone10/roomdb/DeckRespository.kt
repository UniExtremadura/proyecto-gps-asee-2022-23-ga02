package es.unex.trackstone10.roomdb

import android.content.Context
import es.unex.trackstone10.Application
import es.unex.trackstone10.roomdb.Entity.DeckEntity
import es.unex.trackstone10.roomdb.dao.DeckDao
import es.unex.trackstone10.roomdb.dao.DeckListDao
import javax.inject.Inject

class DeckRespository @Inject constructor(
    private val deckDao : DeckDao,
    private val deckListDao: DeckListDao
){

    val sharedPreferences =
        Application.instance?.getSharedPreferences("userid", Context.MODE_PRIVATE)
    val userId = sharedPreferences?.getInt("userid",0)

    fun addDeck(deck: DeckEntity): Int{
        return deckDao.insert(deck).toInt()
    }

    fun getAllDecks() : List<DeckEntity>{
        return deckDao.getAllFromUser(userId)
    }

    fun deleteDeck(deckId : Int) : Boolean{
        val deletedDeck = deckDao.deleteDeckFromId(deckId)
        deckListDao.deleteByDeckId(deckId)
        return deletedDeck != 0
    }

    fun getDeck(deckId: Int) = deckDao.getDeck(deckId)

    fun getDeckListCount(deckId: Int) = deckListDao.getCount(deckId)
}