package fr.tifo.challengetifo.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import fr.tifo.challengetifo.data.Branch.Branch
import fr.tifo.challengetifo.data.Contributor.Contributor
import fr.tifo.challengetifo.data.Project.Project
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow


@Dao
interface ProjectDao {

    @Query("Select * from project_table WHERE full_name like '%/' || :keyword || '%'")
    fun getProjects(keyword :String) : Flow<List<Project>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProjects(list: List<Project>)

    /**TODO
     * add column login & repo for insert & search
     */
    @Query("Select * from branch_table where name =:name")
    fun getBranches(name : String) : Flow<List<Branch>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBranches(list: List<Branch>?)

    /**TODO
     * add column login & repo for insert & search
     */
    @Query("Select * from contributor_table where login =:login")
    fun getContributors(login : String) : Flow<List<Contributor>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContributors(list: List<Contributor>?)

}