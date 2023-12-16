package com.goit.eugene.module19_hw.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestNoteDTO {
    private String title;
    private String content;
    private long id;
}
