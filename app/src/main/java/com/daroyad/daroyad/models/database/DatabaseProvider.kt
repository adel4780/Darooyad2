package com.daroyad.daroyad.models.database

import android.content.Context
import androidx.room.Room

/**
 * Singleton object to provide the AppDatabase instance.
 */
object DatabaseProvider {
    private var INSTANCE: AppDatabase? = null

    /**
     * Retrieves the AppDatabase instance, creating it if necessary.
     *
     * @param context The application context.
     * @return The AppDatabase instance.
     */
    fun getDatabase(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "app_database"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}
