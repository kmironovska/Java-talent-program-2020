package com.seavus.notes.api;

import com.seavus.notes.model.Note;
import com.seavus.notes.model.Tag;
import com.seavus.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@RestController
public class NoteController {

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    private NoteService noteService;


    @GetMapping("/api/notes")
    public Set<Note>findAllNotes() {

        return noteService.findNotes();
    }


    @GetMapping("/api/notes/{id}")
    public Note findNoteById(@PathVariable Long id){

        return noteService.findNoteById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/api/notes")
    public void createNote(@RequestBody CreateNoteRequest request) {
        noteService.createNote(request.title,request.content,request.tags);
    }

    @PostMapping("/api/notes/{id}")
    public void updateNoteById(@PathVariable Long id, @RequestBody CreateNoteRequest request) {
        noteService.updateNoteById(id ,request.title,request.content,request.tags);
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
        public Set<Tag> tags;
    }
}
