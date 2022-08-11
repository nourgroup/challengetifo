package fr.tifo.challengetifo.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import fr.tifo.challengetifo.data.Contributor.Contributor
import fr.tifo.challengetifo.data.Project.Data

@Dao
interface ContributorDao {

    /*@Query("Select * from project_table")
    fun getProjects() : LiveData<List<Contributor>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<Contributor>?)*/
}