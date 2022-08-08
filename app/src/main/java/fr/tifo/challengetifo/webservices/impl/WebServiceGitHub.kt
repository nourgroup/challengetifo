package ft.exomind.testexomind.webservices.impl

import fr.tifo.challengetifo.data.Data
import ft.exomind.testexomind.webservices.APIGitHub
import ft.exomind.testexomind.webservices.IWebService
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WebServiceGitHub : IWebService {
    var service: APIGitHub
    init{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.darksky.net/forecast/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(APIGitHub::class.java)

    }

    override suspend fun getData(latlong : String): Response<Data> {
        return service.getMeteo(latlong)
    }
}