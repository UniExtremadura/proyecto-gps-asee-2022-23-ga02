package es.unex.trackstone10.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.unex.trackstone10.API.APIService
import es.unex.trackstone10.API.TokenInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(url:String): Retrofit {
        val url = "https://us.api.blizzard.com/$url"
        val client = OkHttpClient.Builder()
            .addInterceptor(TokenInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        return retrofit
    }

    @Singleton
    @Provides
    fun provideQuoteApiClient(retrofit: Retrofit): APIService {
        return retrofit.create(APIService::class.java)
    }
}