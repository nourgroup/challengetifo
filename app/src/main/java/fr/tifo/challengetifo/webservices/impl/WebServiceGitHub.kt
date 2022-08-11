package fr.tifo.challengetifo.webservices.impl

import android.util.Log
import fr.tifo.challengetifo.data.Branch.Branch
import fr.tifo.challengetifo.data.Contributor.Contributor
import fr.tifo.challengetifo.data.Project.Data
import fr.tifo.challengetifo.webservices.APIGitHub
import fr.tifo.challengetifo.webservices.IWebService
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WebServiceGitHub : IWebService {
    var service: APIGitHub
    init{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(APIGitHub::class.java)
    }

    override suspend fun getData(keyword : String): Response<Data> {
        return service.getData(keyword)
    }

    //https://docs.github.com/en/rest/branches/branches
    //https://api.github.com/repos/octokit/octokit.net/branches
    /**
     * @param repo
     */
    override suspend fun getBranches(repo: String, login: String): Response<List<Branch>> {
        return service.getBranches(repo,login)
    }

    lateinit var listContributor : Response<List<Contributor>>
    override suspend fun getContributors(repo: String, login: String): Response<List<Contributor>> {
        try {
            listContributor =  service.getContributors(repo,login)

        }catch(Exc : Exception){
            Log.i("error_internet",Exc.message.toString())
        }
        return listContributor
    }
}