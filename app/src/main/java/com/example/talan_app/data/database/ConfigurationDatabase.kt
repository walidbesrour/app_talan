package com.example.talan_app.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.talan_app.data.dao.DaoConfiguration
import com.example.talan_app.data.entity.ConfigurationEntity


@Database(entities = [ConfigurationEntity::class], version = 1, exportSchema = false)
abstract class ConfigurationDatabase : RoomDatabase(){


    abstract fun DaoConfiguration(): DaoConfiguration

    companion object {
        @Volatile
        private var INSTANCE: ConfigurationDatabase? = null

        fun getDatabase(context: Context): ConfigurationDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ConfigurationDatabase::class.java,
                    "configuration_table"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}