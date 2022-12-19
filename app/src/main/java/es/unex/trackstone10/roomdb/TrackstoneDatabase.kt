package es.unex.trackstone10.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import es.unex.trackstone10.roomdb.Entity.*
import es.unex.trackstone10.roomdb.dao.*

@Database(entities = [UserEntity::class,CardBackEntity::class,ClassEntity::class,CardEntity::class,DeckEntity::class,DeckListCardEntity::class], version = 1, exportSchema = false)
abstract class TrackstoneDatabase: RoomDatabase() {

    abstract fun getUserdao(): UserDao
    abstract fun getCarddao(): CardDao
    abstract fun getCardbackdao(): CardBackDao
    abstract fun getClassDao(): ClassDao
    abstract fun getDeckDao(): DeckDao
    abstract fun getDeckListDao(): DeckListDao

}