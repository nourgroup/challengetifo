package fr.tifo.challengetifo.webservices


import fr.tifo.challengetifo.data.Branch.Branch
import fr.tifo.challengetifo.data.Contributor.Contributor
import fr.tifo.challengetifo.data.Project.Data
import retrofit2.Response

interface IWebService {
    suspend fun getData(keyword : String): Response<Data>
    suspend fun getBranches(repo : String ,login : String) : Response<List<Branch>>
    suspend fun getContributors(repo: String, login: String): Response<List<Contributor>>
}