package es.unex.trackstone10.roomdb

import android.content.Context
import es.unex.trackstone10.Application
import es.unex.trackstone10.roomdb.Entity.UserEntity
import es.unex.trackstone10.roomdb.dao.*
import javax.inject.Inject


class UserRepository @Inject constructor(
    private val userDao: UserDao,
    private val classDao : ClassDao,
    private val cardDao : CardDao,
    private val cardBackDao: CardBackDao,
    private val deckDao: DeckDao,
    private val deckListDao: DeckListDao
) {

    val sharedPreferences =
        Application.instance?.getSharedPreferences("userid", Context.MODE_PRIVATE)


    fun register(user: UserEntity): Int {
        val id = userDao.insert(user).toInt()
        var edit = sharedPreferences?.edit()
        edit?.putInt("userid", id)
        edit?.commit()

        return id
    }

    fun login(query1: String, query2: String): Boolean {
        val user = userDao.getUserByName(query1)
        if (user != null) {
            var edit = sharedPreferences?.edit()
            edit?.putInt("userid", user.id)
            edit?.commit()
            return user.password == query2
        }
        return false
    }

    fun deleteUser(userId : Int?): Boolean {
        val deletedUserId = userDao.deleteUser(userId)
        cardDao.deleteByUser(userId)
        cardBackDao.deleteByUser(userId)
        classDao.deleteByUser(userId)
        deckDao.deleteByUser(userId)
        deckListDao.deleteByUser(userId)
        var edit = sharedPreferences?.edit()
        edit?.clear()
        edit?.commit()
        return deletedUserId != 0
    }

    fun getUser(userId : Int) : UserEntity{
        return userDao.getUserById(userId) ?: UserEntity("", "", "")
    }

    fun modifyUser(user: UserEntity): Boolean {
        val updateUser = userDao.update(user)
        return updateUser != 0
    }
}