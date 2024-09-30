package lk.ijse.gdse.aad67.notecollecter67.customStatusCodes;

import lk.ijse.gdse.aad67.notecollecter67.dto.NoteStatus;
import lk.ijse.gdse.aad67.notecollecter67.dto.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedUserAndNoteErrorStatus implements UserStatus, NoteStatus {
    private int statusCode;
    private String statusMessage;
}
