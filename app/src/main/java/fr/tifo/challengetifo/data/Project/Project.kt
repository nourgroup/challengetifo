package fr.tifo.challengetifo.data.Project

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "project_table")
data class Project(
    @PrimaryKey
    val full_name: String,
    val stargazers_count: Int?,
    val description: String?,
    val language: String?
)