package fr.tifo.challengetifo.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import fr.tifo.challengetifo.data.Branch.Branch
import fr.tifo.challengetifo.data.Contributor.Contributor
import fr.tifo.challengetifo.data.Project.Data

@Dao
interface BranchDao {

    /*@Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<Branch>?)

    @Query("Select * from project_table")
    fun getProjects() : LiveData<List<Branch>>*/
}