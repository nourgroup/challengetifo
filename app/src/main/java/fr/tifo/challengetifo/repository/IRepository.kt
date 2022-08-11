package fr.tifo.challengetifo.repository

interface IRepository {
    suspend fun getData(keyword : String)
    suspend fun getBranches(repo : String )
    suspend fun getContributors(repo: String)
}