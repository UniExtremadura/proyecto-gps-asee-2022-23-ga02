package es.unex.trackstone10

import org.junit.Assert.assertEquals
import org.junit.Test
import java.lang.reflect.Field

class UserUnitTest {

    @Test
    fun setUsername() {

        val value = "test"
        val instance = es.unex.trackstone10.roomdb.Entity.UserEntity("","","")
        instance.username = value
        val field : Field = instance.javaClass.getDeclaredField("username")
        field.isAccessible = true
        assertEquals("Usernames didn't match!", field.get(instance), value)

    }

    @Test
    fun setPassword() {

        val value = "passwordTest"
        val instance = es.unex.trackstone10.roomdb.Entity.UserEntity("","","")
        instance.password = value
        val field : Field = instance.javaClass.getDeclaredField("password")
        field.isAccessible = true
        assertEquals("Passwords didn't match!", field.get(instance), value)

    }

    @Test
    fun setEmail() {

        val value = "test@gmail.com"
        val instance = es.unex.trackstone10.roomdb.Entity.UserEntity("","","")
        instance.mail = value
        val field : Field = instance.javaClass.getDeclaredField("mail")
        field.isAccessible = true
        assertEquals("Emails didn't match!", field.get(instance), value)

    }

    @Test
    fun getUsername() {

        val instance = es.unex.trackstone10.roomdb.Entity.UserEntity("","","")
        val field : Field = instance.javaClass.getDeclaredField("username")
        field.isAccessible = true
        field.set(instance, "test")

        val result : String? = instance.username

        assertEquals("Username wasn't retrieved properly", result, "test")

    }

    @Test
    fun getPassword() {

        val instance = es.unex.trackstone10.roomdb.Entity.UserEntity("","","")
        val field : Field = instance.javaClass.getDeclaredField("password")
        field.isAccessible = true
        field.set(instance, "passwordTest")

        val result : String? = instance.password

        assertEquals("Password wasn't retrieved properly", result, "passwordTest")

    }

    @Test
    fun getEmail() {

        val instance = es.unex.trackstone10.roomdb.Entity.UserEntity("","","")
        val field : Field = instance.javaClass.getDeclaredField("mail")
        field.isAccessible = true
        field.set(instance, "test@gmail.com")

        val result : String? = instance.mail

        assertEquals("Mail wasn't retrieved properly", result, "test@gmail.com")

    }

}