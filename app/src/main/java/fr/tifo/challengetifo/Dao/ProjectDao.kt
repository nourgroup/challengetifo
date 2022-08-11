package fr.tifo.challengetifo.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import fr.tifo.challengetifo.data.Project.Data
import fr.tifo.challengetifo.data.Project.Project

@Dao
interface ProjectDao {

    /*@Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<Project>)

    @Query("Select * from project_table")
    fun getProjects() : LiveData<List<Project>>*/
}