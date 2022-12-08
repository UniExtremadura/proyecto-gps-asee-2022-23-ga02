package es.unex.trackstone10

import org.junit.Assert.assertEquals
import org.junit.Test
import java.lang.reflect.Field

class DeckUnitTest {

    @Test
    fun setClassId() {

        val value = 1
        val instance = es.unex.trackstone10.roomdb.Entity.DeckEntity(0,"",0,0)
        instance.classid = value
        val field : Field = instance.javaClass.getDeclaredField("classid")
        field.isAccessible = true
        assertEquals("Class Ids didn't match!", field.get(instance), value)

    }

    @Test
    fun setName() {

        val value = "Warlock Zoo"
        val instance = es.unex.trackstone10.roomdb.Entity.DeckEntity(0,"",0,0)
        instance.name = value
        val field : Field = instance.javaClass.getDeclaredField("name")
        field.isAccessible = true
        assertEquals("Names didn't match!", field.get(instance), value)

    }

    @Test
    fun setCount() {

        val value = 30
        val instance = es.unex.trackstone10.roomdb.Entity.DeckEntity(0,"",0,0)
        instance.count = value
        val field : Field = instance.javaClass.getDeclaredField("count")
        field.isAccessible = true
        assertEquals("Counts didn't match!", field.get(instance), value)

    }

    @Test
    fun setUserId() {

        val value = 1
        val instance = es.unex.trackstone10.roomdb.Entity.DeckEntity(0,"",0,0)
        instance.user_id = value
        val field : Field = instance.javaClass.getDeclaredField("user_id")
        field.isAccessible = true
        assertEquals("User Ids didn't match!", field.get(instance), value)

    }

    @Test
    fun getClassId() {

        val instance = es.unex.trackstone10.roomdb.Entity.DeckEntity(0,"",0,0)
        val field : Field = instance.javaClass.getDeclaredField("classid")
        field.isAccessible = true
        field.set(instance, 1)

        val result : Int? = instance.classid

        assertEquals("Class Id wasn't retrieved properly", result, 1)
    }

    @Test
    fun getName() {

        val instance = es.unex.trackstone10.roomdb.Entity.DeckEntity(0,"",0,0)
        val field : Field = instance.javaClass.getDeclaredField("name")
        field.isAccessible = true
        field.set(instance, "Warlock Zoo")

        val result : String? = instance.name

        assertEquals("Deck name wasn't retrieved properly", result, "Warlock Zoo")
    }

    @Test
    fun getCount() {

        val instance = es.unex.trackstone10.roomdb.Entity.DeckEntity(0,"",0,0)
        val field : Field = instance.javaClass.getDeclaredField("count")
        field.isAccessible = true
        field.set(instance, 30)

        val result : Int? = instance.count

        assertEquals("Count wasn't retrieved properly", result, 30)
    }

    @Test
    fun getUserId() {

        val instance = es.unex.trackstone10.roomdb.Entity.DeckEntity(0,"",0,0)
        val field : Field = instance.javaClass.getDeclaredField("user_id")
        field.isAccessible = true
        field.set(instance, 1)

        val result : Int? = instance.user_id

        assertEquals("User Id wasnt retrieved properly", result, 1)
    }

}