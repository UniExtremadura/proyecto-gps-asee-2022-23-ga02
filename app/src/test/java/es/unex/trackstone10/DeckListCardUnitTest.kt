package es.unex.trackstone10

import org.junit.Assert.assertEquals
import org.junit.Test
import java.lang.reflect.Field

class DeckListCardUnitTest {

    @Test
    fun setDeckId() {

        val value = 1
        val instance = es.unex.trackstone10.roomdb.Entity.DeckListCardEntity(0,0,"",0,0,0,0,"")
        instance.deck_id = value
        val field : Field = instance.javaClass.getDeclaredField("deck_id")
        field.isAccessible = true
        assertEquals("Deck Ids didn't match!", field.get(instance), value)

    }

    @Test
    fun setUserId() {

        val value = 1
        val instance = es.unex.trackstone10.roomdb.Entity.DeckListCardEntity(0,0,"",0,0,0,0,"")
        instance.user_id = value
        val field : Field = instance.javaClass.getDeclaredField("user_id")
        field.isAccessible = true
        assertEquals("User Ids didn't match!", field.get(instance), value)

    }

    @Test
    fun setCardName() {

        val value = "The Jailer"
        val instance = es.unex.trackstone10.roomdb.Entity.DeckListCardEntity(0,0,"",0,0,0,0,"")
        instance.card_name = value
        val field : Field = instance.javaClass.getDeclaredField("card_name")
        field.isAccessible = true
        assertEquals("Card names didn't match!", field.get(instance), value)

    }

    @Test
    fun setCopies() {

        val value = 2
        val instance = es.unex.trackstone10.roomdb.Entity.DeckListCardEntity(0,0,"",0,0,0,0,"")
        instance.copies = value
        val field : Field = instance.javaClass.getDeclaredField("copies")
        field.isAccessible = true
        assertEquals("Copies didn't match!", field.get(instance), value)

    }

    @Test
    fun setRarity() {

        val value = 5
        val instance = es.unex.trackstone10.roomdb.Entity.DeckListCardEntity(0,0,"",0,0,0,0,"")
        instance.card_rarity = value
        val field : Field = instance.javaClass.getDeclaredField("card_rarity")
        field.isAccessible = true
        assertEquals("Rarities didn't match!", field.get(instance), value)

    }

    @Test
    fun setCardClass() {

        val value = 12
        val instance = es.unex.trackstone10.roomdb.Entity.DeckListCardEntity(0,0,"",0,0,0,0,"")
        instance.card_class = value
        val field : Field = instance.javaClass.getDeclaredField("card_class")
        field.isAccessible = true
        assertEquals("Card classes didn't match!", field.get(instance), value)

    }

    @Test
    fun setManaCost() {

        val value = 10
        val instance = es.unex.trackstone10.roomdb.Entity.DeckListCardEntity(0,0,"",0,0,0,0,"")
        instance.card_manacost = value
        val field : Field = instance.javaClass.getDeclaredField("card_manacost")
        field.isAccessible = true
        assertEquals("Mana costs didn't match!", field.get(instance), value)

    }

    @Test
    fun setImage() {

        val value = "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/5873ffdcf397e2e8624d862cd2133c8c240c90e6f962ce8a24200aec9755ad0f.png"
        val instance = es.unex.trackstone10.roomdb.Entity.DeckListCardEntity(0,0,"",0,0,0,0,"")
        instance.card_name = value
        val field : Field = instance.javaClass.getDeclaredField("card_name")
        field.isAccessible = true
        assertEquals("Card names didn't match!", field.get(instance), value)

    }

    @Test
    fun getDeckId() {

        val instance = es.unex.trackstone10.roomdb.Entity.DeckListCardEntity(0,0,"",0,0,0,0,"")
        val field : Field = instance.javaClass.getDeclaredField("deck_id")
        field.isAccessible = true
        field.set(instance, 1)

        val result : Int? = instance.deck_id

        assertEquals("Deck Id wasn't retrieved properly", result, 1)
    }

    @Test
    fun getUserId() {

        val instance = es.unex.trackstone10.roomdb.Entity.DeckListCardEntity(0,0,"",0,0,0,0,"")
        val field : Field = instance.javaClass.getDeclaredField("user_id")
        field.isAccessible = true
        field.set(instance, 1)

        val result : Int? = instance.user_id

        assertEquals("User Id wasn't retrieved properly", result, 1)
    }

    @Test
    fun getCardName() {

        val instance = es.unex.trackstone10.roomdb.Entity.DeckListCardEntity(0,0,"",0,0,0,0,"")
        val field : Field = instance.javaClass.getDeclaredField("card_name")
        field.isAccessible = true
        field.set(instance, "The Jailer")

        val result : String? = instance.card_name

        assertEquals("Card name wasn't retrieved properly", result, "The Jailer")
    }

    @Test
    fun getCopies() {

        val instance = es.unex.trackstone10.roomdb.Entity.DeckListCardEntity(0,0,"",0,0,0,0,"")
        val field : Field = instance.javaClass.getDeclaredField("copies")
        field.isAccessible = true
        field.set(instance, 30)

        val result : Int? = instance.copies

        assertEquals("Copies wasn't retrieved properly", result, 30)
    }

    @Test
    fun getRarity() {

        val instance = es.unex.trackstone10.roomdb.Entity.DeckListCardEntity(0,0,"",0,0,0,0,"")
        val field : Field = instance.javaClass.getDeclaredField("card_rarity")
        field.isAccessible = true
        field.set(instance, 5)

        val result : Int? = instance.card_rarity

        assertEquals("Copies wasn't retrieved properly", result, 5)
    }

    @Test
    fun getCardClass() {

        val instance = es.unex.trackstone10.roomdb.Entity.DeckListCardEntity(0,0,"",0,0,0,0,"")
        val field : Field = instance.javaClass.getDeclaredField("card_class")
        field.isAccessible = true
        field.set(instance, 12)

        val result : Int? = instance.card_class

        assertEquals("Copies wasn't retrieved properly", result, 12)
    }

    @Test
    fun getManaCost() {

        val instance = es.unex.trackstone10.roomdb.Entity.DeckListCardEntity(0,0,"",0,0,0,0,"")
        val field : Field = instance.javaClass.getDeclaredField("card_manacost")
        field.isAccessible = true
        field.set(instance, 10)

        val result : Int? = instance.card_manacost

        assertEquals("Copies wasn't retrieved properly", result, 10)
    }

    @Test
    fun getImage() {

        val instance = es.unex.trackstone10.roomdb.Entity.DeckListCardEntity(0,0,"",0,0,0,0,"")
        val field : Field = instance.javaClass.getDeclaredField("image")
        field.isAccessible = true
        field.set(instance, "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/5873ffdcf397e2e8624d862cd2133c8c240c90e6f962ce8a24200aec9755ad0f.png")

        val result : String? = instance.image

        assertEquals("Card name wasnt retrieved properly", result, "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/5873ffdcf397e2e8624d862cd2133c8c240c90e6f962ce8a24200aec9755ad0f.png")
    }

}