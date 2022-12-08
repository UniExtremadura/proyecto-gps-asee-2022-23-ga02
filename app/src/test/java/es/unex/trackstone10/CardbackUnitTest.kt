package es.unex.trackstone10

import org.junit.Assert.assertEquals
import org.junit.Test
import java.lang.reflect.Field

class CardbackUnitTest {

    @Test
    fun setName() {

        val value = "Alleria"
        val instance = es.unex.trackstone10.roomdb.Entity.CardBackEntity("","",0)
        instance.name = value
        val field : Field = instance.javaClass.getDeclaredField("name")
        field.isAccessible = true
        assertEquals("Cardbacks names didn't match!", field.get(instance), value)

    }

    @Test
    fun setURL() {

        val value = "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/6e1be2bb1e24ddb739466c733b05bcdea1fd098bf8390c1ab70733a539e84975.png"
        val instance = es.unex.trackstone10.roomdb.Entity.CardBackEntity("","",0)
        instance.url = value
        val field : Field = instance.javaClass.getDeclaredField("url")
        field.isAccessible = true
        assertEquals("URLs didn't match!", field.get(instance), value)

    }

    @Test
    fun setUserId() {

        val value = 1
        val instance = es.unex.trackstone10.roomdb.Entity.CardBackEntity("","",0)
        instance.userid = value
        val field : Field = instance.javaClass.getDeclaredField("userid")
        field.isAccessible = true
        assertEquals("User Ids didn't match!", field.get(instance), value)

    }

    @Test
    fun getName() {

        val instance = es.unex.trackstone10.roomdb.Entity.CardBackEntity("","",0)
        val field : Field = instance.javaClass.getDeclaredField("name")
        field.isAccessible = true
        field.set(instance, "Alleria")

        val result : String? = instance.name

        assertEquals("Cardback name wasn't retrieved properly", result, "Alleria")
    }

    @Test
    fun getURL() {

        val instance = es.unex.trackstone10.roomdb.Entity.CardBackEntity("","",0)
        val field : Field = instance.javaClass.getDeclaredField("url")
        field.isAccessible = true
        field.set(instance, "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/6e1be2bb1e24ddb739466c733b05bcdea1fd098bf8390c1ab70733a539e84975.png")

        val result : String? = instance.url

        assertEquals("Cardback name wasn't retrieved properly", result, "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/6e1be2bb1e24ddb739466c733b05bcdea1fd098bf8390c1ab70733a539e84975.png")
    }

    @Test
    fun getUserId() {

        val instance = es.unex.trackstone10.roomdb.Entity.CardBackEntity("","",0)
        val field : Field = instance.javaClass.getDeclaredField("userid")
        field.isAccessible = true
        field.set(instance, 1)

        val result : Int? = instance.userid

        assertEquals("Cardback name wasn't retrieved properly", result, 1)
    }

}