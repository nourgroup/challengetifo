package fr.tifo.challengetifo.data.Contributor

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contributor_table")
data class Contributor(
    @PrimaryKey
    val login: String,
    val avatar_url: String?
)