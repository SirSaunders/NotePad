package com.example.notepad;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/**
 * this will read in and write out any note information to/from android
 * Created by John on 2/26/2016.
 */
public class ReadWrite implements Serializable {

        @TargetApi(Build.VERSION_CODES.KITKAT)
        public static void WRITE_OUT(NotePad notePad, Context context) throws IOException {

            try (FileOutputStream fos = context.openFileOutput("NotePad.ser", Context.MODE_PRIVATE)) {
                ObjectOutputStream os = new ObjectOutputStream(fos);
                os.writeObject(notePad);
                os.close();
                fos.close();
            }
            catch (Exception e) {

            }
        }

        public static NotePad READ_IN(Context context, String fileName) throws IOException, ClassNotFoundException {

            FileInputStream fis = context.openFileInput(fileName);
            ObjectInputStream is = new ObjectInputStream(fis);
            NotePad notePad = (NotePad) is.readObject();
            is.close();
            fis.close();
            return notePad;
        }

}
