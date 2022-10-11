package com.example.mvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class NoteDao {

    private final MutableLiveData<List<Note>> allNotes;
    private static NoteDao instance;

    public NoteDao() {
       allNotes = new MutableLiveData<>();
       List<Note> newList = new ArrayList<>();
       allNotes.setValue(newList);
    }


    public static NoteDao getInstance() {
        if (instance == null){
            instance = new NoteDao();
        }
        return instance;
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

    public void insert(Note note) {
        List<Note> currentNotes = allNotes.getValue();
        currentNotes.add(note);
        allNotes.setValue(currentNotes);
    }

    public void deleteAllNotes() {
        List<Note> newList = new ArrayList<>();
        allNotes.setValue(newList);
    }


}
