package es.unex.trackstone10

import org.junit.Assert.assertEquals
import org.junit.Test
import java.lang.reflect.Field

class CardUnitTest {

    @Test
    fun setName() {

        val value = "The Jailer"
        val instance = es.unex.trackstone10.roomdb.Entity.CardEntity("",0,0,0,"","","",0)
        instance.name = value
        val field : Field = instance.javaClass.getDeclaredField("name")
        field.isAccessible = true
        assertEquals("Usernames didn't match!", field.get(instance), value)

    }

    @Test
    fun setRarity() {

        val value = 5
        val instance = es.unex.trackstone10.roomdb.Entity.CardEntity("",0,0,0,"","","",0)
        instance.rarity = value
        val field : Field = instance.javaClass.getDeclaredField("rarity")
        field.isAccessible = true
        assertEquals("Rarities didn't match!", field.get(instance), value)

    }

    @Test
    fun setCardClass() {

        val value = 12
        val instance = es.unex.trackstone10.roomdb.Entity.CardEntity("",0,0,0,"","","",0)
        instance.cardclass = value
        val field : Field = instance.javaClass.getDeclaredField("cardclass")
        field.isAccessible = true
        assertEquals("Card classes didn't match!", field.get(instance), value)

    }

    @Test
    fun setManaCost() {

        val value = 10
        val instance = es.unex.trackstone10.roomdb.Entity.CardEntity("",0,0,0,"","","",0)
        instance.manacost = value
        val field : Field = instance.javaClass.getDeclaredField("manacost")
        field.isAccessible = true
        assertEquals("Mana costs didn't match!", field.get(instance), value)

    }

    @Test
    fun setInfo() {

        val value = "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/5873ffdcf397e2e8624d862cd2133c8c240c90e6f962ce8a24200aec9755ad0f.png"
        val instance = es.unex.trackstone10.roomdb.Entity.CardEntity("",0,0,0,"","","",0)
        instance.info = value
        val field : Field = instance.javaClass.getDeclaredField("info")
        field.isAccessible = true
        assertEquals("Infos didn't match!", field.get(instance), value)

    }

    @Test
    fun setType() {

        val value = "Minion"
        val instance = es.unex.trackstone10.roomdb.Entity.CardEntity("",0,0,0,"","","",0)
        instance.type = value
        val field : Field = instance.javaClass.getDeclaredField("type")
        field.isAccessible = true
        assertEquals("Types didn't match!", field.get(instance), value)

    }

    @Test
    fun setRace() {

        val value = "Orc"
        val instance = es.unex.trackstone10.roomdb.Entity.CardEntity("",0,0,0,"","","",0)
        instance.race = value
        val field : Field = instance.javaClass.getDeclaredField("race")
        field.isAccessible = true
        assertEquals("Races didn't match!", field.get(instance), value)

    }

    @Test
    fun setUserName() {

        val value = 1
        val instance = es.unex.trackstone10.roomdb.Entity.CardEntity("",0,0,0,"","","",0)
        instance.userid = value
        val field : Field = instance.javaClass.getDeclaredField("userid")
        field.isAccessible = true
        assertEquals("User ids didn't match!", field.get(instance), value)

    }

    @Test
    fun getName() {

        val instance = es.unex.trackstone10.roomdb.Entity.CardEntity("",0,0,0,"","","",0)
        val field : Field = instance.javaClass.getDeclaredField("name")
        field.isAccessible = true
        field.set(instance, "The Jailer")

        val result : String? = instance.name

        assertEquals("Card name wasn't retrieved properly", result, "The Jailer")
    }

    @Test
    fun getRarity() {

        val instance = es.unex.trackstone10.roomdb.Entity.CardEntity("",0,0,0,"","","",0)
        val field : Field = instance.javaClass.getDeclaredField("rarity")
        field.isAccessible = true
        field.set(instance, 5)

        val result : Int? = instance.rarity

        assertEquals("Rarity wasn't retrieved properly", result, 5)
    }

    @Test
    fun getCardClass() {

        val instance = es.unex.trackstone10.roomdb.Entity.CardEntity("",0,0,0,"","","",0)
        val field : Field = instance.javaClass.getDeclaredField("cardclass")
        field.isAccessible = true
        field.set(instance, 12)

        val result : Int? = instance.cardclass

        assertEquals("Card class wasn't retrieved properly", result, 12)
    }

    @Test
    fun getManaCost() {

        val instance = es.unex.trackstone10.roomdb.Entity.CardEntity("",0,0,0,"","","",0)
        val field : Field = instance.javaClass.getDeclaredField("manacost")
        field.isAccessible = true
        field.set(instance, 10)

        val result : Int? = instance.manacost

        assertEquals("Card class wasn't retrieved properly", result, 10)
    }

    @Test
    fun getInfo() {

        val instance = es.unex.trackstone10.roomdb.Entity.CardEntity("",0,0,0,"","","",0)
        val field : Field = instance.javaClass.getDeclaredField("info")
        field.isAccessible = true
        field.set(instance, "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/5873ffdcf397e2e8624d862cd2133c8c240c90e6f962ce8a24200aec9755ad0f.png")

        val result : String? = instance.info

        assertEquals("Card class wasn't retrieved properly", result, "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/5873ffdcf397e2e8624d862cd2133c8c240c90e6f962ce8a24200aec9755ad0f.png")
    }

    @Test
    fun getType() {

        val instance = es.unex.trackstone10.roomdb.Entity.CardEntity("",0,0,0,"","","",0)
        val field : Field = instance.javaClass.getDeclaredField("type")
        field.isAccessible = true
        field.set(instance, "Minion")

        val result : String? = instance.type

        assertEquals("Card class wasn't retrieved properly", result, "Minion")
    }

    @Test
    fun getRace() {

        val instance = es.unex.trackstone10.roomdb.Entity.CardEntity("",0,0,0,"","","",0)
        val field : Field = instance.javaClass.getDeclaredField("race")
        field.isAccessible = true
        field.set(instance, "Orc")

        val result : String? = instance.race

        assertEquals("Card class wasn't retrieved properly", result, "Orc")
    }

    @Test
    fun getUserId() {

        val instance = es.unex.trackstone10.roomdb.Entity.CardEntity("",0,0,0,"","","",0)
        val field : Field = instance.javaClass.getDeclaredField("userid")
        field.isAccessible = true
        field.set(instance, 1)

        val result : Int? = instance.userid

        assertEquals("kard class wasn't retrieved properly", result, 1)
    }

}