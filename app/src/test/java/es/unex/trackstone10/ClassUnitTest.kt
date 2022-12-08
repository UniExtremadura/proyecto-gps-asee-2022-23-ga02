package es.unex.trackstone10

import org.junit.Assert.assertEquals
import org.junit.Test
import java.lang.reflect.Field

class ClassUnitTest {

    @Test
    fun setName() {

        val value = "Elise Starseeker"
        val instance = es.unex.trackstone10.roomdb.Entity.ClassEntity("",0,"",0)
        instance.name = value
        val field : Field = instance.javaClass.getDeclaredField("name")
        field.isAccessible = true
        assertEquals("Class names didn't match!", field.get(instance), value)

    }

    @Test
    fun setIdHero() {

        val value = 2
        val instance = es.unex.trackstone10.roomdb.Entity.ClassEntity("",0,"",0)
        instance.idhero = value
        val field : Field = instance.javaClass.getDeclaredField("idhero")
        field.isAccessible = true
        assertEquals("Class Ids didn't match!", field.get(instance), value)

    }

    @Test
    fun setURL() {

        val value = "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/69b1f9bb3ced88678d9b6e11020cdd6117bb9b69cec054ddda013d778da2cc93.png"
        val instance = es.unex.trackstone10.roomdb.Entity.ClassEntity("",0,"",0)
        instance.url = value
        val field : Field = instance.javaClass.getDeclaredField("url")
        field.isAccessible = true
        assertEquals("URLs didn't match!", field.get(instance), value)

    }

    @Test
    fun setUserId() {

        val value = 1
        val instance = es.unex.trackstone10.roomdb.Entity.ClassEntity("",0,"",0)
        instance.userid = value
        val field : Field = instance.javaClass.getDeclaredField("userid")
        field.isAccessible = true
        assertEquals("User Ids didn't match!", field.get(instance), value)

    }

    @Test
    fun getName() {

        val instance = es.unex.trackstone10.roomdb.Entity.ClassEntity("",0,"",0)
        val field : Field = instance.javaClass.getDeclaredField("name")
        field.isAccessible = true
        field.set(instance, "Elise Starseeker")

        val result : String? = instance.name

        assertEquals("Hero name wasn't retrieved properly", result, "Elise Starseeker")
    }

    @Test
    fun getIdHero() {

        val instance = es.unex.trackstone10.roomdb.Entity.ClassEntity("",0,"",0)
        val field : Field = instance.javaClass.getDeclaredField("idhero")
        field.isAccessible = true
        field.set(instance, 2)

        val result : Int? = instance.idhero

        assertEquals("Hero name wasn't retrieved properly", result, 2)
    }

    @Test
    fun getURL() {

        val instance = es.unex.trackstone10.roomdb.Entity.ClassEntity("",0,"",0)
        val field : Field = instance.javaClass.getDeclaredField("url")
        field.isAccessible = true
        field.set(instance, "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/69b1f9bb3ced88678d9b6e11020cdd6117bb9b69cec054ddda013d778da2cc93.png")

        val result : String? = instance.url

        assertEquals("URL wasn't retrieved properly", result, "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/69b1f9bb3ced88678d9b6e11020cdd6117bb9b69cec054ddda013d778da2cc93.png")
    }

    @Test
    fun getUserId() {

        val instance = es.unex.trackstone10.roomdb.Entity.ClassEntity("",0,"",0)
        val field : Field = instance.javaClass.getDeclaredField("userid")
        field.isAccessible = true
        field.set(instance, 1)

        val result : Int? = instance.userid

        assertEquals("ero name wasn't retrieved properly", result, 1)
    }
}