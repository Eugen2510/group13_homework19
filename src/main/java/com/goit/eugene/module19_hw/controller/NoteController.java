package com.goit.eugene.module19_hw.controller;

import com.goit.eugene.module19_hw.dto.GetNoteResponse;
import com.goit.eugene.module19_hw.dto.RequestNoteDTO;
import com.goit.eugene.module19_hw.dto.ResponseNoteDTO;
import com.goit.eugene.module19_hw.entity.Note;
import com.goit.eugene.module19_hw.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/note/api")
public class NoteController {
    private final NoteService noteService;

    @PostMapping("/create")
    public ResponseNoteDTO create(@RequestBody RequestNoteDTO request){
        return noteService.createNote(request);
    }

    @GetMapping("/get/{id}")
    public GetNoteResponse getNoteById(@PathVariable("id") long id){
        return noteService.getNoteById(id);
    }
    @GetMapping("/get/all")
    public List<Note> getAllNotes(){
        return noteService.getAllNotes();
    }

    @PostMapping("/update")
    public ResponseNoteDTO updateNote(@RequestBody Note note){
        return noteService.updateNote(note);
    }

    @PostMapping("/delete/{notId}")
    public ResponseNoteDTO deleteNote(@PathVariable long notId){
        return noteService.deleteNote(notId);
    }
}
