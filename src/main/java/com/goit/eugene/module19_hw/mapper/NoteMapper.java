package com.goit.eugene.module19_hw.mapper;


import com.goit.eugene.module19_hw.dto.GetNoteResponse;
import com.goit.eugene.module19_hw.dto.RequestNoteDTO;
import com.goit.eugene.module19_hw.entity.Note;


public class NoteMapper {
    public static Note convertToNote(RequestNoteDTO request){
        Note note = new Note();
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        return note;
    }

    public static GetNoteResponse convertToResponse(Note note){
        return GetNoteResponse.builder()
                .id(note.getId())
                .title(note.getTitle())
                .content(note.getContent())
                .build();

    }

    public static RequestNoteDTO convertToRequest(Note note){
        return RequestNoteDTO.builder()
                .title(note.getTitle())
                .content(note.getContent())
                .id(note.getId())
                .build();
    }
}
