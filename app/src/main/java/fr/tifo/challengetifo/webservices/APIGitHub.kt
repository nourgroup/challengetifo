package fr.tifo.challengetifo.webservices

import fr.tifo.challengetifo.data.Branch.Branch
import fr.tifo.challengetifo.data.Contributor.Contributor
import fr.tifo.challengetifo.data.Project.Data
import retrofit2.Response
import retrofit2.http.*

interface APIGitHub {
    @GET("search/repositories")
    suspend fun getData(@Query("q") keyword : String) : Response<Data>
    //https://docs.github.com/en/rest/branches/branches
    //https://api.github.com/repos/octokit/octokit.net/branches
    //200 -> OK; 404 -> Resource not found
    @GET("repos/{repo}/{login}/branches")
    suspend fun getBranches(@Path("repo") repo : String,@Path("login") login : String) : Response<List<Branch>>
    //https://docs.github.com/en/rest/collaborators/collaborators#list-repository-collaborators
    //https://api.github.com/repos/OWNER/REPO/contributors
    //200 -> OK; 404 -> Resource not found
    //https://api.github.com/repos/Moya/Moya/contributors
    @GET("repos/{repo}/{login}/contributors")
    suspend fun getContributors(@Path("repo") repo: String, @Path("login") login : String) : Response<List<Contributor>>
    //
}