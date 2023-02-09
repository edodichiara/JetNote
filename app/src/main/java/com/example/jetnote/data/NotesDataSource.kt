package com.example.jetnote.data

import com.example.jetnote.model.Note

class NotesDataSource {
    fun loadNotes(): List<Note>{
        return listOf(
            Note(title = "Fare uscire Whisky", description = "Deve fare i bisognini"),
            Note(title = "Studiare il corso di Jetpack Compose", description = "Il corso ha una sua complessità"),
            Note(title = "Andare al cinema", description = "Vedere film di Christopher Nolan")
        )
    }
}