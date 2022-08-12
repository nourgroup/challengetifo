package fr.tifo.challengetifo.repository.impl

import android.util.Log
import fr.tifo.challengetifo.Dao.ProjectDao
import fr.tifo.challengetifo.data.Branch.Branch
import fr.tifo.challengetifo.data.Contributor.Contributor
import fr.tifo.challengetifo.data.Project.Project
import fr.tifo.challengetifo.repository.IRepository
import fr.tifo.challengetifo.webservices.IWebService
import kotlinx.coroutines.flow.*

class RepositoryGitHub(
    private val mIWebService : IWebService,
    private val mProjectDao : ProjectDao
    ) : IRepository{

    var responnseProjects : MutableStateFlow<List<Project>?> = MutableStateFlow(null)
    var responnsebranches : MutableStateFlow<List<Branch>?> = MutableStateFlow(null)
    var responseContributor : MutableStateFlow<List<Contributor>?> = MutableStateFlow(null)
    var resBranch = mutableListOf<Branch>()
    var resContributor = mutableListOf<Contributor>()
    var resProject = mutableListOf<Project>()

    override suspend fun getData(keyword : String) : Flow<List<Project>>{
        try{
            val data =mIWebService.getData(keyword)
            if(data.isSuccessful){
                data.body()?.items?.forEach {
                    resProject.add(Project(it.full_name,it.stargazers_count,it.description,it.language))
                }
                // single source of truth
                mProjectDao.insertProjects(resProject)
            }
        }catch (ex : Exception){
            Log.i("Exception_internet",ex.message.toString())
        }finally {
            Log.i("Exception_internet","finally")
            return mProjectDao.getProjects(keyword)
        }
    }

    override suspend fun getBranches(repo : String){
        try{
            // split n'as pas d'exception et gere tous les cas
            val data = mIWebService.getBranches(repo.split("/")[0],repo.split("/")[1])
            if(data.isSuccessful){
                data.body()!!.forEach {
                    resBranch.add(Branch(it.name))
                }
                mProjectDao.insertBranches(resBranch)
                responnsebranches.emit(resBranch)
            }
        }catch (ex : Exception){
            Log.i("Exception_internet",ex.message.toString())
        }finally {
        }
    }

    override suspend fun getContributors(repo: String){
        try{
            val data = mIWebService.getContributors(repo.split("/")[0],repo.split("/")[1])
            if(data.isSuccessful){
                data.body()?.forEach {
                    resContributor.add(Contributor(it.login,it.avatar_url))
                }
                mProjectDao.insertContributors(resContributor)
                responseContributor.emit(resContributor)
            }
        }catch (ex : Exception){

        }finally {
        }
    }
}