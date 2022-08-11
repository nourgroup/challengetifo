package fr.tifo.challengetifo.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.tifo.challengetifo.Dao.ProjectRoomDatabase
import fr.tifo.challengetifo.data.Branch.Branch
import fr.tifo.challengetifo.data.Contributor.Contributor
import fr.tifo.challengetifo.data.Project.Data
import fr.tifo.challengetifo.data.Project.Project
import fr.tifo.challengetifo.repository.impl.RepositoryGitHub
import fr.tifo.challengetifo.webservices.impl.WebServiceGitHub
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelGithub : ViewModel() {

    var resultProject : MutableLiveData<List<Project>> = MutableLiveData()

    var resultbranches : MutableLiveData<List<Branch>> = MutableLiveData()

    var resultContributors : MutableLiveData<List<Contributor>> = MutableLiveData()

    lateinit  var mRepositoryGitHub :RepositoryGitHub


    fun initRoomDatabase(context: Context?){
        //var mProjectRoomDatabase =ProjectRoomDatabase.getDatabase(context = context).projectDao()
        mRepositoryGitHub = RepositoryGitHub(WebServiceGitHub())
        //,mProjectRoomDatabase
    }


    fun getData(keyword : String){
        viewModelScope.launch(Dispatchers.IO) {
            mRepositoryGitHub.getData(keyword)
            mRepositoryGitHub.responnseProjects.collect{
                resultProject.postValue(it)
            }
        }
    }

    fun getBranches(repo : String ){
        viewModelScope.launch(Dispatchers.IO) {
            mRepositoryGitHub.getBranches(repo)
            mRepositoryGitHub.responnsebranches.collect{
                resultbranches.postValue(it)
            }
        }
    }

    fun getContributor(repo : String ){
        viewModelScope.launch(Dispatchers.IO) {
            mRepositoryGitHub.getContributors(repo)
            mRepositoryGitHub.responseContributor.collect{
                resultContributors.postValue(it)
            }
        }
    }
}