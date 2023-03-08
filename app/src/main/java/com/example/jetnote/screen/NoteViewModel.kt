package com.example.jetnote.screen

import androidx.lifecycle.ViewModel
import com.example.jetnote.data.NotesDataSource
import com.example.jetnote.model.Note

class NoteViewModel: ViewModel() {
    private var noteList = mutableListOf<Note>()
    init {
        noteList.addAll(NotesDataSource().loadNotes())
    }

    fun addNote(note: Note){
        noteList.add(note)
    }

    fun removeNote(note: Note){
        noteList.remove(note)
    }

    fun getAllNotes(): List<Note>{
        return noteList
    }
}