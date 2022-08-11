package fr.tifo.challengetifo.data.Branch

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "branch_table")
data class Branch(
    @PrimaryKey(autoGenerate = false)
    val name: String
)