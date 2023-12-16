package com.goit.eugene.module19_hw.dto.validate;

import com.goit.eugene.module19_hw.dto.RequestNoteDTO;
import com.goit.eugene.module19_hw.dto.ResponseNoteDTO;
import org.springframework.stereotype.Component;

@Component
public class NoteValidator {
    private final static int MAX_TITLE_LENGTH = 100;
    private final static int MAX_CONTENT_LENGTH = 1000;
    public ResponseNoteDTO.Status validate(RequestNoteDTO request){
        if (request.getTitle() == null || request.getTitle().length() > MAX_TITLE_LENGTH){
            return ResponseNoteDTO.Status.titleError;
        }
        if (request.getContent() == null || request.getContent().length() > MAX_CONTENT_LENGTH){
            return ResponseNoteDTO.Status.contentError;
        }
        return ResponseNoteDTO.Status.ok;
    }
}
