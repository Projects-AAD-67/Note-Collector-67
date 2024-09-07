package lk.ijse.gdse.aad67.notecollecter67.util;

import java.util.UUID;

public class AppUtil {
    public static String generateNoteId(){
        return "NOTE-"+UUID.randomUUID();
    }
}
