package fr.tifo.challengetifo.webservices.impl

import fr.tifo.challengetifo.data.Data
import fr.tifo.challengetifo.webservices.APIGitHub
import fr.tifo.challengetifo.webservices.IWebService
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WebServiceGitHub : IWebService {
    var service: APIGitHub
    init{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/search/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(APIGitHub::class.java)
    }

    override suspend fun getData(keyword : String): Response<Data> {
        return service.getData(keyword)
    }
}