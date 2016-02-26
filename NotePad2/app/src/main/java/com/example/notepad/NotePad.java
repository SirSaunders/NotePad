package com.example.notepad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 2/26/2016.
 * This will hold all of the notes and allow access to the notes.
 */
public class NotePad implements Serializable{
    private List<Note> notes;

    public NotePad(){
        notes = new ArrayList<>();
    }

    public Note getNote(int ndx){
        return notes.get(ndx);
    }

    public void addNote(Note note){
        notes.add(note);
    }

    public List<Note> getNotes(){
        return notes;
    }

    public String toString(){
        String notepad = "";
        int i =0;
        for (Note n: notes) {
            i++;
            notepad+="Note " + i +": " +n.toString() +"\n";
        }
        return notepad;
    }
}
