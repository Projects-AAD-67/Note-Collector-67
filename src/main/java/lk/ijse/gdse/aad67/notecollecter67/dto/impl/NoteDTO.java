package lk.ijse.gdse.aad67.notecollecter67.dto.impl;

import lk.ijse.gdse.aad67.notecollecter67.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteDTO implements SuperDTO {
   private String noteId;
   private String noteTitle;
   private String noteDesc;
   private String createdDate;
   private String priorityLevel;
   private String userId;

}
