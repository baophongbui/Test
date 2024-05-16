package com.example.vocab;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class VocabEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String term;
    public String def;
    public String ipa;

    public VocabEntity(int id, String term, String def, String ipa) {
        this.id = id;
        this.term = term;
        this.def = def;
        this.ipa = ipa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def;
    }

    public String getIpa() {
        return ipa;
    }

    public void setIpa(String ipa) {
        this.ipa = ipa;
    }


}
