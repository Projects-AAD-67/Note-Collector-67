package lk.ijse.gdse.aad67.notecollecter67.controller;

import lk.ijse.gdse.aad67.notecollecter67.dto.impl.NoteDTO;
import lk.ijse.gdse.aad67.notecollecter67.service.NoteService;
import lk.ijse.gdse.aad67.notecollecter67.service.NoteServiceIMPL;
import lk.ijse.gdse.aad67.notecollecter67.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/notes")
public class NoteController {
    @Autowired
    NoteService noteService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteDTO saveNote(@RequestBody NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtil.generateNoteId());
        var noteServiceIMPL = new NoteServiceIMPL();
        noteServiceIMPL.saveNote(noteDTO);
        return noteDTO;
    }
    public NoteDTO getSelectedNote(){
        return null;
    }
    public List<NoteDTO> getALlNotes(){
        return null;
    }
    public void deleteNote(String noteId){

    }
    public void updateNote(String noteId,NoteDTO noteDTO){

    }

}
