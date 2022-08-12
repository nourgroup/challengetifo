package fr.tifo.challengetifo.repository

import fr.tifo.challengetifo.data.Branch.Branch
import fr.tifo.challengetifo.data.Contributor.Contributor
import fr.tifo.challengetifo.data.Project.Project
import kotlinx.coroutines.flow.Flow

interface IRepository {
    suspend fun getData(keyword : String)  : Flow<List<Project>>
    suspend fun getBranches(repo : String )
    suspend fun getContributors(repo: String)
}