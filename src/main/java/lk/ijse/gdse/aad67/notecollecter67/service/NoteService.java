package lk.ijse.gdse.aad67.notecollecter67.service;

import lk.ijse.gdse.aad67.notecollecter67.dto.impl.NoteDTO;

import java.util.List;

public interface NoteService {
    String saveNote(NoteDTO noteDTO);
    List<NoteDTO> getAllNotes();
    NoteDTO getNote(String noteId);
    boolean deleteNote(String noteId);
    boolean updateNote(String noteId, NoteDTO noteDTO);
}
