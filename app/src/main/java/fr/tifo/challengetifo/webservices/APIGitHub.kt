package fr.tifo.challengetifo.webservices

import fr.tifo.challengetifo.data.Data
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIGitHub {
    @GET("repositories")
    suspend fun getData(@Query("q") keyword : String) : Response<Data>
}