package ft.exomind.testexomind.webservices

import fr.tifo.challengetifo.data.Data
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface APIGitHub {
    @GET("{coordinate}")
    suspend fun getMeteo(@Path("coordinate") coordinate : String) : Response<Data>
}