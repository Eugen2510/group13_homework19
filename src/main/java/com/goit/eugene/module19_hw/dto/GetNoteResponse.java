package com.goit.eugene.module19_hw.dto;

import com.goit.eugene.module19_hw.entity.Note;
import com.goit.eugene.module19_hw.mapper.NoteMapper;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetNoteResponse {

    Status status;
    long id;
    String title;
    String content;

    public enum Status{
        ok,
        notExist
    }

    public static GetNoteResponse getResponse(Note note){
        GetNoteResponse response = NoteMapper.convertToResponse(note);
        response.setStatus(Status.ok);
        return response;
    }
}
