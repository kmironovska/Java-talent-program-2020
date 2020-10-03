package com.seavus.notes.api;

import com.seavus.notes.model.Note;
import com.seavus.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class NoteController {

    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/api/notes")
    public Set<Note> findAllNotes() {

        return noteService.findNotes();
    }


    @GetMapping("/api/notes/{id}")
    public Note findNoteById(@PathVariable Long id) {

        return noteService.findNoteById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/api/notes")
    public Note createNote(@RequestBody CreateNoteRequest request) {
        if (request.tags != null) {
            return noteService.createNote(request.title, request.content, request.tags);
        } else return noteService.createNote(request.title, request.content, new HashSet<>());

    }

    @PutMapping("/api/notes/{id}")
    public Note updateNoteById(@PathVariable Long id, @RequestBody CreateNoteRequest request) {
        if (request.tags != null) {
            return noteService.updateNoteById(id, request.title, request.content, request.tags);
        } else return noteService.updateNoteById(id, request.title, request.content, new HashSet<>());

    }

    @GetMapping("/api/tags/{id}/notes")
    public List<Note> findNotesByTagId(@PathVariable Long id) {
        return noteService.findNotesByTagsId(id);
    }

    @DeleteMapping("/api/notes/{id}")
    public void deleteNote(@PathVariable Long id) {

        noteService.deleteNoteById(id);
    }

    public static class CreateNoteRequest {
        public String title;
        public String content;
        public Set<Long> tags;
    }
}
