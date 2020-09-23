package com.seavus.noteswithoutdatabase.api;

import com.seavus.noteswithoutdatabase.model.Note;
import com.seavus.noteswithoutdatabase.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class NotesController {


    private NoteService noteService;

    @Autowired
    public NotesController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/api/notes")
    public void createNote(@RequestBody CreateNoteRequest request) {
        noteService.createNote(request.title, request.content);
    }

    @GetMapping("/api/notes/{id}")
    public Note findNote(@PathVariable Long id) {
        return noteService.findNote(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("api/notes")
    public List<Note> findAllNotes() {
        return noteService.findAllNotes();
    }

    @PutMapping("/api/notes/{id}")
    public void updateNote(@PathVariable Long id, @RequestBody CreateNoteRequest request) {
        Note note1 = new Note(request.title, request.content);
        noteService.updateNote(id, note1);
    }

    @DeleteMapping("/api/notes/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }

    public static class CreateNoteRequest {
        public String title;
        public String content;
    }

}
