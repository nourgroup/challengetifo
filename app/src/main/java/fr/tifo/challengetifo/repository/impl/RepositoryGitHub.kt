package fr.tifo.challengetifo.repository.impl

import fr.tifo.challengetifo.data.Data
import fr.tifo.challengetifo.repository.IRepository
import ft.exomind.testexomind.webservices.IWebService
import retrofit2.Response

class RepositoryGitHub(val mIWebService : IWebService) : IRepository{

    override suspend fun getData(keyword : String): Response<Data> {
        return mIWebService.getData(keyword)
    }
}