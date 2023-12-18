package com.goit.eugene.module19_hw.dto.validate;

import com.goit.eugene.module19_hw.dto.RequestNoteDTO;
import com.goit.eugene.module19_hw.dto.ResponseNoteDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class NoteValidatorTest {
    private NoteValidator noteValidator;
    private final static String FAIL_TITLE = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    private final static String FAIL_CONTENT = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaa";

    private final static String OK_TITLE = "title";
    private final static String OK_CONTENT = "content";

    @BeforeEach
    void init(){
        noteValidator = new NoteValidator();
    }
    @Test
    void validateContentTest() {
        RequestNoteDTO failRequestNoteDTO = RequestNoteDTO.builder().id(1).title(OK_TITLE).content(FAIL_CONTENT).build();
        RequestNoteDTO okRequestNoteDTO = RequestNoteDTO.builder().id(1).title(OK_TITLE).content(OK_CONTENT).build();

        ResponseNoteDTO.Status expectedFailStatus = ResponseNoteDTO.Status.contentError;
        ResponseNoteDTO.Status expectedOkStatus = ResponseNoteDTO.Status.ok;

        ResponseNoteDTO.Status actualFailStatus = noteValidator.validate(failRequestNoteDTO);
        ResponseNoteDTO.Status actualOkStatus = noteValidator.validate(okRequestNoteDTO);

        Assertions.assertEquals(expectedFailStatus, actualFailStatus);
        Assertions.assertEquals(expectedOkStatus, actualOkStatus);
    }

    @Test
    void validateTitleTest(){
        RequestNoteDTO failRequestNoteDTO = RequestNoteDTO.builder().id(1).title(FAIL_TITLE).content(OK_CONTENT).build();
        RequestNoteDTO okRequestNoteDTO = RequestNoteDTO.builder().id(1).title(OK_TITLE).content(OK_CONTENT).build();

        ResponseNoteDTO.Status expectedFailStatus = ResponseNoteDTO.Status.titleError;
        ResponseNoteDTO.Status expectedOkStatus = ResponseNoteDTO.Status.ok;

        ResponseNoteDTO.Status actualFailStatus = noteValidator.validate(failRequestNoteDTO);
        ResponseNoteDTO.Status actualOkStatus = noteValidator.validate(okRequestNoteDTO);

        Assertions.assertEquals(expectedFailStatus, actualFailStatus);
        Assertions.assertEquals(expectedOkStatus, actualOkStatus);
    }
}