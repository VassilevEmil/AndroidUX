package com.example.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel viewModel;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.getAllNotes().observe(this, notes -> {
            if (!notes.isEmpty()) {
                textView.setText("");
                for (Note n : notes) {
                    textView.append(n.getTitle() + "\n");
                }
            } else {
                textView.setText("Empty");
            }
        });
    }

    public void saveNote(View v){
        viewModel.addNote(new Note(editText.getText().toString()));
    }

    public void deleteAllNotes(View v){
        viewModel.deleteAllNotes();
    }
}