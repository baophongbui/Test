package com.example.vocab;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;

@Dao
public interface VocabDao {
    @Insert
    void insert(VocabEntity vocabEntity);
    @Delete
    void delete(VocabEntity vocabEntity);
}
