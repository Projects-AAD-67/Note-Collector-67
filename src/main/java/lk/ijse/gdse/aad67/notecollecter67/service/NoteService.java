package lk.ijse.gdse.aad67.notecollecter67.service;

import lk.ijse.gdse.aad67.notecollecter67.dto.NoteStatus;
import lk.ijse.gdse.aad67.notecollecter67.dto.impl.NoteDTO;

import java.util.List;

public interface NoteService {
    void saveNote(NoteDTO noteDTO);
    List<NoteDTO> getAllNotes();
    NoteStatus getNote(String noteId);
    boolean deleteNote(String noteId);
    boolean updateNote(String noteId, NoteDTO noteDTO);
}
