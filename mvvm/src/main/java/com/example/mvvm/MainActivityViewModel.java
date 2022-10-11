package com.example.mvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivityViewModel extends ViewModel {

 private final NoteRepository repository;


 public MainActivityViewModel(){
     repository = NoteRepository.getInstance();
 }

 public LiveData<List<Note>> getAllNotes(){
     return repository.getAllNotes();
 }

 public void addNote(final Note note){
     repository.insert(note);
 }

 public void deleteAllNotes(){
     repository.deleteAllNotes();
 }

}
