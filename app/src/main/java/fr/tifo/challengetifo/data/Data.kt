package fr.tifo.challengetifo.data

data class Data(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)