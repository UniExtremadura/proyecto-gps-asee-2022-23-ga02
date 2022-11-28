package es.unex.trackstone10.roomdb.database

import android.provider.BaseColumns

class DBContract private constructor() {
    object UserEntity : BaseColumns {
        const val TABLE_NAME = "user_table"
        const val USER_ID = "id"
        const val USERNAME = "username"
        const val PASSWORD = "password"
        const val MAIL = "mail"
    }
}