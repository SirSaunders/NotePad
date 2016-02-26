package com.example.notepad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class NotePadActivity extends AppCompatActivity {
    NotePad notePad = new NotePad();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad);
       readInNote();
        Button saveBtn = (Button) findViewById(R.id.save_button);
        Button deleteBtn = (Button) findViewById(R.id.delete_button);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                writeOutNote();
            }});
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clearNote();
            }
        });

}
    public void writeOutNote(){
        try {
            saveNote();
            ReadWrite.WRITE_OUT(notePad, this.getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void clearNote(){
        notePad.getNote(0).setNote("");
    }

    private void readInNote() {

        try {
            notePad = ReadWrite.READ_IN(this.getApplicationContext(), "NotePad.ser");
            loadNote(); // this will load the contents of the first note in the notepad.
        }
        catch (Exception e) {
            e.printStackTrace();// not able to read in note
            createNote(); /// creates a new note
        }
    }

    /*
    this will create the put the content from the note in the notepad and put it into the activity
     */
    private void loadNote(){
        TextView note = (TextView) findViewById(R.id.note_text);
        note.setText(notePad.getNote(0).getNote());
    }

    private void createNote(){
        notePad.addNote(new Note("")); // make and adds a note to NotePad
    }

    private void saveNote(){
        TextView note = (TextView) findViewById(R.id.note_text);
        notePad.getNote(0).setNote(note.getText().toString());
    }
}
