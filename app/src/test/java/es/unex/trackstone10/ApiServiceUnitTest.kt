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
    fun getCardBackTest() {

        val mockWebServer = MockWebServer()
        val cardback = CardBackResponse(1,2,"text","name","image","slug")
        val mockResponse =
            MockResponse().addHeader("CardBackResponse", "application/json; charset=utf-8")
                .setBody("{\"cardback\": \"$cardback\"}")

        mockWebServer.enqueue(mockResponse)
        mockWebServer.start()

        val baseUrl = mockWebServer.url("/getCardback")

        CoroutineScope(Dispatchers.IO).launch {
            val client = OkHttpClient.Builder().build()
            val retrofit = Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).client(client)
                .build()

            val call = retrofit.create(APIService::class.java).getCardBack()
            assertEquals(cardback,call.body())

        }
        mockWebServer.shutdown()

    }

}