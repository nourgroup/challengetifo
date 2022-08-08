package ft.exomind.testexomind.webservices


import fr.tifo.challengetifo.data.Data
import retrofit2.Response

interface IWebService {
    suspend fun getData(keyword : String): Response<Data>
}