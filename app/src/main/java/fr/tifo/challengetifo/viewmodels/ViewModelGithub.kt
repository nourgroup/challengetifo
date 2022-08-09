package fr.tifo.challengetifo.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.tifo.challengetifo.data.Data
import fr.tifo.challengetifo.repository.impl.RepositoryGitHub
import fr.tifo.challengetifo.webservices.impl.WebServiceGitHub
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelGithub : ViewModel() {

    var result : MutableLiveData<Data> = MutableLiveData()

    var mRepositoryGitHub = RepositoryGitHub(WebServiceGitHub())


    fun getData(keyword : String){
        viewModelScope.launch(Dispatchers.IO) {
            mRepositoryGitHub.getData(keyword)
            mRepositoryGitHub.responnsedata.collect{
                result.postValue(it)
            }

        }


    }

}