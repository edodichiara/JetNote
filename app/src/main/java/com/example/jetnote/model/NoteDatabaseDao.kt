package com.example.jetnote.model

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {
    //language=sql
    @Query(value = "SELECT * from notes_tbl")
    fun getNotes(): Flow<List<Note>>

    //language=sql
    @Query(value = "SELECT * from notes_tbl where id = :id")
    suspend fun getNote(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    //language=sql
    @Query("DELETE from notes_tbl")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteNote(note: Note)

}
