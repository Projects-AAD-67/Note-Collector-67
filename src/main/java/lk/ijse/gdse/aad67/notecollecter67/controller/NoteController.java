package lk.ijse.gdse.aad67.notecollecter67.controller;

import lk.ijse.gdse.aad67.notecollecter67.customStatusCodes.SelectedUserAndNoteErrorStatus;
import lk.ijse.gdse.aad67.notecollecter67.dto.NoteStatus;
import lk.ijse.gdse.aad67.notecollecter67.dto.impl.NoteDTO;
import lk.ijse.gdse.aad67.notecollecter67.exception.DataPersistException;
import lk.ijse.gdse.aad67.notecollecter67.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("api/v1/notes")
public class NoteController {
    @Autowired
   private NoteService noteService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveNote(@RequestBody NoteDTO noteDTO) {
        try {
            noteService.saveNote(noteDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{noteID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteStatus getSelectedNote(@PathVariable ("noteID") String noteId){
        String regexForUserID = "^NOTE-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexForUserID);
        var regexMatcher = regexPattern.matcher(noteId);
            if (!regexMatcher.matches()) {
                return new SelectedUserAndNoteErrorStatus(1,"Note ID is not valid");
            }
            return noteService.getNote(noteId);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteDTO> getALlNotes(){
       return noteService.getAllNotes();
    }
    public void deleteNote(String noteId){

    }
    public void updateNote(String noteId,NoteDTO noteDTO){

    }

}
