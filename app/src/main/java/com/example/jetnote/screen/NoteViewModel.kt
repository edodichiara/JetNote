package com.example.jetnote.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetnote.data.NotesDataSource
import com.example.jetnote.model.Note
import com.example.jetnote.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val noteRepository: NoteRepository) : ViewModel() {
    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    //private var noteList = mutableListOf<Note>()
    init {
        //noteList.addAll(NotesDataSource().loadNotes())
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.getAllNotes().distinctUntilChanged().collect{listOfNote ->
                if (listOfNote.isEmpty()){
                    Log.d("Empty", "Empty List")
                } else {
                    _noteList.value = listOfNote
                }
            }
        }
    }

    suspend fun addNote(note: Note) = viewModelScope.launch { noteRepository.addNote(note = note) }

    suspend fun updateNote(note: Note) =
        viewModelScope.launch { noteRepository.updateNote(note = note) }

    suspend fun removeNote(note: Note) =
        viewModelScope.launch { noteRepository.deleteNote(note = note) }
}