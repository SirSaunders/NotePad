package com.example.notepad;

import java.io.Serializable;

/**
 * this will contain the note written in the notepad.
 * Created by John on 2/26/2016.
 */
public class Note implements Serializable{
String note = "";

    public Note(String n){
        note = n;
    }
    public String getNote(){
        return note;
    }
    public void setNote(String n){
        note = n;
    }
    public String toString(){
        return note;
    }
}
