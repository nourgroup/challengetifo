package fr.tifo.challengetifo.repository.impl

import android.util.Log
import fr.tifo.challengetifo.data.Data
import fr.tifo.challengetifo.repository.IRepository
import fr.tifo.challengetifo.webservices.IWebService
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

class RepositoryGitHub(private val mIWebService : IWebService) : IRepository{

    var responnsedata : MutableStateFlow<Data?> = MutableStateFlow(null)


    override suspend fun getData(keyword : String) {
        try{
            val data =mIWebService.getData(keyword)
            if(data.isSuccessful){
                responnsedata.emit(data.body())
            }else{

            }
        }catch (ex : Exception){
            Log.i("Exception_internet",ex.message.toString())
        }
    }
}