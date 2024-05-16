package com.example.vocab;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {VocabEntity.class}, version = 1)
public abstract class VocabDatabase extends RoomDatabase {
    public abstract VocabDao vocabDao();
}