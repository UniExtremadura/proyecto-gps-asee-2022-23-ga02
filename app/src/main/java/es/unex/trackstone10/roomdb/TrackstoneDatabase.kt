package es.unex.trackstone10.roomdb

import androidx.fragment.app.FragmentActivity
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import es.unex.trackstone10.roomdb.entity.*
import es.unex.trackstone10.roomdb.dao.*

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class TrackstoneDatabase: RoomDatabase() {

    abstract val userdao: UserDao?


    companion object{
        private var instance: TrackstoneDatabase? = null
        fun getInstance(context: FragmentActivity?): TrackstoneDatabase? {
            if(instance == null){
                if(context != null){
                    instance = Room.databaseBuilder(
                        context,
                        TrackstoneDatabase::class.java,"trackstone.db"
                    ).fallbackToDestructiveMigration().build()
                }
            }
            return instance
        }
    }
}