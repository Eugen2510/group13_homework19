package com.goit.eugene.module19_hw.service;

import com.goit.eugene.module19_hw.dto.GetNoteResponse;
import com.goit.eugene.module19_hw.dto.RequestNoteDTO;
import com.goit.eugene.module19_hw.dto.validate.NoteValidator;
import com.goit.eugene.module19_hw.dto.ResponseNoteDTO;
import com.goit.eugene.module19_hw.entity.Note;
import com.goit.eugene.module19_hw.mapper.NoteMapper;
import com.goit.eugene.module19_hw.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;
    private final NoteValidator noteValidator;

    public ResponseNoteDTO createNote (RequestNoteDTO request){
        ResponseNoteDTO.Status requestStatus = noteValidator.validate(request);
        if (!requestStatus.equals(ResponseNoteDTO.Status.ok)){
            return ResponseNoteDTO.getResponse(requestStatus, -1);
        }

        Note note = NoteMapper.convertToNote(request);
        noteRepository.save(note);

        return ResponseNoteDTO.getResponse(requestStatus, note.getId());
    }

    public GetNoteResponse getNoteById(long id){
        Optional<Note> byId = noteRepository.findById(id);
        return byId
                .map(GetNoteResponse::getResponse)
                .orElseGet(() -> GetNoteResponse.builder()
                        .status(GetNoteResponse.Status.notExist)
                        .id(id)
                        .build());
    }

    public List<Note> getAllNotes(){
        return  noteRepository.findAll();
    }

    public ResponseNoteDTO updateNote(Note note){
        Optional<Note> byId = noteRepository.findById(note.getId());
        if(byId.isEmpty()){
            return ResponseNoteDTO.getResponse(ResponseNoteDTO.Status.notExist, note.getId());
        }
        ResponseNoteDTO.Status status = noteValidator.validate(NoteMapper.convertToRequest(note));
        if(!status.equals(ResponseNoteDTO.Status.ok)){
            return ResponseNoteDTO.getResponse(status, note.getId());
        }
        noteRepository.save(note);
        return ResponseNoteDTO.getResponse(status, note.getId());
    }

    public ResponseNoteDTO deleteNote(long id){
        Optional<Note> byId = noteRepository.findById(id);
        if (byId.isEmpty()){
            return ResponseNoteDTO.getResponse(ResponseNoteDTO.Status.notExist, id);
        }
        noteRepository.deleteById(id);
        return ResponseNoteDTO.getResponse(ResponseNoteDTO.Status.ok, id);
    }
}
