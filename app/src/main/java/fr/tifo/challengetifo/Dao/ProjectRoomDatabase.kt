package fr.tifo.challengetifo.Dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fr.tifo.challengetifo.data.Branch.Branch
import fr.tifo.challengetifo.data.Contributor.Contributor
import fr.tifo.challengetifo.data.Project.Project

@Database(
    entities = [Project::class, Branch::class,Contributor::class],
    version = 1,
    exportSchema = false
)
abstract class ProjectRoomDatabase: RoomDatabase(){
    abstract fun projectDao() : ProjectDao

    companion object {
        @Volatile
        private var INSTANCE: ProjectRoomDatabase? = null

        // design p singleton
        fun getDatabase(
            context: Context?
        ): ProjectRoomDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context!!.applicationContext,
                    ProjectRoomDatabase::class.java,
                    "github_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}