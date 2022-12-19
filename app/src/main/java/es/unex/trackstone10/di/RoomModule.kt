package es.unex.trackstone10.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import es.unex.trackstone10.roomdb.TrackstoneDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val TRACKSTONE_DATABASE_NAME = "trackstone_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context : Context) =
        Room.databaseBuilder(context, TrackstoneDatabase::class.java, TRACKSTONE_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideUserDao(db: TrackstoneDatabase) = db.getUserdao()

    @Singleton
    @Provides
    fun provideCardDao(db: TrackstoneDatabase) = db.getCarddao()

    @Singleton
    @Provides
    fun provideCardbackDao(db: TrackstoneDatabase) = db.getCardbackdao()

    @Singleton
    @Provides
    fun provideClassDao(db: TrackstoneDatabase) = db.getClassDao()

    @Singleton
    @Provides
    fun provideDeckDao(db: TrackstoneDatabase) = db.getDeckDao()

    @Singleton
    @Provides
    fun provideDeckListDao(db: TrackstoneDatabase) = db.getDeckListDao()


}