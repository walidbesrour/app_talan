package com.example.talan_app.repository

import androidx.lifecycle.LiveData
import com.example.talan_app.data.dao.DaoConfiguration
import com.example.talan_app.data.entity.ConfigurationEntity


class ConfigurationRepository(private val daoConfiguration: DaoConfiguration) {

    val readAllData: LiveData<List<ConfigurationEntity>> = daoConfiguration.readAllData()

    suspend fun addconfiguration(Configuration: ConfigurationEntity){
        daoConfiguration.addconfiguration(Configuration)
    }


    suspend fun updateconfiguration(Configuration: ConfigurationEntity){
        daoConfiguration.updateconfiguration(Configuration)
    }
}