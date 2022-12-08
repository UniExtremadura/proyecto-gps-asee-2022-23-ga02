package es.unex.trackstone10

import es.unex.trackstone10.API.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.assertEquals
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiServiceUnitTest {

    @Test
    fun getCardTest() {

        val mockWebServer = MockWebServer()
        val card = CardResponse(2,3,"slug",1,null,2,1,1,2,4,"artist",1,"name","text","image","imageGold","flavorTest","cropImage",null)
        val mockResponse =
            MockResponse().addHeader("CardResponse", "application/json; charset=utf-8")
                .setBody("{\"card\": \"$card\"}")

        mockWebServer.enqueue(mockResponse)
        mockWebServer.start()

        val baseUrl = mockWebServer.url("/getCard")

        CoroutineScope(Dispatchers.IO).launch {
            val client = OkHttpClient.Builder().build()
            val retrofit = Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).client(client)
                .build()

            val call = retrofit.create(APIService::class.java).getCard()
            assertEquals(card,call.body())

        }
        mockWebServer.shutdown()

    }


}