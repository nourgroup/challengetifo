package fr.tifo.challengetifo.repository

import fr.tifo.challengetifo.data.Data
import retrofit2.Response

interface IRepository {
    suspend fun getData(keyword : String)
}