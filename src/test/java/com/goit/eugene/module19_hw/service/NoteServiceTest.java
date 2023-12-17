package com.goit.eugene.module19_hw.service;

import com.goit.eugene.module19_hw.dto.RequestNoteDTO;
import com.goit.eugene.module19_hw.dto.ResponseNoteDTO;
import com.goit.eugene.module19_hw.dto.validate.NoteValidator;
import com.goit.eugene.module19_hw.entity.Note;
import com.goit.eugene.module19_hw.mapper.NoteMapper;
import com.goit.eugene.module19_hw.repository.NoteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NoteServiceTest {
    @Mock
    private  NoteRepository noteRepository;
    @Mock
    private NoteValidator noteValidator;
    @InjectMocks
    private NoteService noteService;

    @Test
    void createNote() {
        //GIVEN
        RequestNoteDTO request = createRequestNoteDTO();
        ResponseNoteDTO.Status status = ResponseNoteDTO.Status.ok;
        Note note = NoteMapper.convertToNote(request);
        ResponseNoteDTO expectedResponse = ResponseNoteDTO.getResponse(status, 1);

        //WHEN
        Mockito.when(noteRepository.save(note)).thenReturn(note);
        Mockito.when(noteValidator.validate(request)).thenReturn(ResponseNoteDTO.Status.ok);

        //THEN
        ResponseNoteDTO actualResponse = noteService.createNote(request);
        Assertions.assertEquals(expectedResponse.getId(), actualResponse.getId());
        Assertions.assertEquals(expectedResponse.getStatus(), actualResponse.getStatus());
    }

    private RequestNoteDTO createRequestNoteDTO() {
        return RequestNoteDTO.builder()
                .id(1)
                .title("NEW")
                .content("NEW CONTENT")
                .build();
    }

}