package fr.tifo.challengetifo.repository.impl

import android.util.Log
import fr.tifo.challengetifo.Dao.ProjectDao
import fr.tifo.challengetifo.data.Branch.Branch
import fr.tifo.challengetifo.data.Contributor.Contributor
import fr.tifo.challengetifo.data.Project.Data
import fr.tifo.challengetifo.data.Project.Project
import fr.tifo.challengetifo.repository.IRepository
import fr.tifo.challengetifo.webservices.IWebService
import kotlinx.coroutines.flow.MutableStateFlow

class RepositoryGitHub(
    private val mIWebService : IWebService,
    //private val mProjectDao : ProjectDao
    ) : IRepository{

    var responnseProjects : MutableStateFlow<List<Project>?> = MutableStateFlow(null)
    var responnsebranches : MutableStateFlow<List<Branch>?> = MutableStateFlow(null)
    var responseContributor : MutableStateFlow<List<Contributor>?> = MutableStateFlow(null)
    var resBranch = mutableListOf<Branch>()
    var resContributor = mutableListOf<Contributor>()
    var resProject = mutableListOf<Project>()

    override suspend fun getData(keyword : String) {
        try{
            val data =mIWebService.getData(keyword)
            if(data.isSuccessful){
                data.body()?.items?.forEach {
                    resProject.add(Project(it.full_name,it.stargazers_count,it.description,it.language))
                }
                //mProjectDao.insertAll(resProject)
                responnseProjects.emit(resProject)
                //mProjectDao.getProjects().value?.items?.size
            }else{

            }
        }catch (ex : Exception){
            Log.i("Exception_internet",ex.message.toString())
        }
    }

    override suspend fun getBranches(repo : String){
        try{
            val data = mIWebService.getBranches(repo.split("/")[0],repo.split("/")[1])
            if(data.isSuccessful){
                data.body()!!.forEach {
                    resBranch.add(Branch(it.name))
                }
                responnsebranches.emit(resBranch)
            }else{

            }
            /*val data1 = mIWebService.getContributors(repo.split("/")[0],repo.split("/")[1])
            if(data1.isSuccessful){
                data1.body()!!.forEach {
                    resContributor.add(Contributor(it.login,it.avatar_url))
                }
                responnsebranches.emit(res)
            }else{

            }*/

        }catch (ex : Exception){
            Log.i("Exception_internet",ex.message.toString())
        }
    }

    override suspend fun getContributors(repo: String){
        try{
            val data = mIWebService.getContributors(repo.split("/")[0],repo.split("/")[1])
            if(data.isSuccessful){
                responseContributor.emit(data.body())
            }else{

            }
        }catch (ex : Exception){
            Log.i("Exception_internet",ex.message.toString())
        }
    }
}