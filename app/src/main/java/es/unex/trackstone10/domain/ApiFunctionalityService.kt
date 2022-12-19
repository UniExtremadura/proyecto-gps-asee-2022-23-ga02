package es.unex.trackstone10.domain

import es.unex.trackstone10.API.APIService
import es.unex.trackstone10.API.APIToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiFunctionalityService @Inject constructor() {

    private val retrofit = APIToken.getRetrofit("/hearthstone/cards/")
    private val retrofit2 = APIToken.getRetrofit("/hearthstone/cardbacks/")

    suspend fun getCards(): List<CardModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(APIService::class.java)
                .getCards("standard", "groupByClass:asc,manaCost:asc", 1300, "en_US")
            response.body()?.cards?.map { it.toCardModel() } ?: emptyList()
        }
    }

    suspend fun getCardsByName(query: String): List<CardModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(APIService::class.java).getCardsByName(
                query,
                "standard",
                "groupByClass:asc,manaCost:asc",
                1300,
                "en_US"
            )
            response.body()?.cards?.map { it.toCardModel() } ?: emptyList()
        }
    }

    suspend fun getHeroes(): List<CardModel> {
        return withContext(Dispatchers.IO) {
            val response =
                retrofit.create(APIService::class.java).getHeroes("17", "groupByClass:asc", "en_US")
            response.body()?.cards?.map { it.toCardModel() } ?: emptyList()
        }
    }

    suspend fun getHeroesByName(query: String): List<CardModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(APIService::class.java)
                .getHeroByName(query, "17", "groupByClass:asc", "en_US")
            response.body()?.cards?.map { it.toCardModel() } ?: emptyList()
        }
    }

    suspend fun getCardBacks(): List<CardBackModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit2.create(APIService::class.java).getCardBacks("en_US")
            response.body()?.cardBacks?.map { it.toCardBackModel() } ?: emptyList()
        }
    }

    suspend fun getCardBacksByName(query: String): List<CardBackModel> {
        return withContext(Dispatchers.IO) {
            val response =
                retrofit2.create(APIService::class.java).getCardBacksByName("en_US", query)
            response.body()?.cardBacks?.map { it.toCardBackModel() } ?: emptyList()
        }
    }

    suspend fun getCardsByClass(classSelected: String): List<CardModel> {
        return withContext(Dispatchers.IO) {
            val classSlug = "$classSelected,neutral"
            val response = retrofit.create(APIService::class.java)
                .getCardsByClass(
                    classSlug,
                    "standard",
                    "groupByClass:asc,manaCost:asc",
                    1300,
                    "en_US"
                )
            response.body()?.cards?.map { it.toCardModel() } ?: emptyList()
        }
    }

    suspend fun getCardsByClassAndName(HSclass: String, Query: String): List<CardModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(APIService::class.java).getCardsByClassAndName(
                Query,
                HSclass,
                "standard",
                "groupByClass:asc,manaCost:asc",
                1300,
                "en_US"
            )
            response.body()?.cards?.map { it.toCardModel() } ?: emptyList()
        }
    }

}