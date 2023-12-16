package com.goit.eugene.module19_hw.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseNoteDTO {
    private long id;
    private Status status;
    public enum Status{
        ok,
        titleError,
        contentError,
        notExist
    }

    public static ResponseNoteDTO getResponse(Status status, long id){
        return builder().status(status).id(id).build();
    }

}
