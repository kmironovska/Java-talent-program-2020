package com.seavus.noteswithoutdatabase.api;

import com.seavus.noteswithoutdatabase.model.Note;
import com.seavus.noteswithoutdatabase.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
//@RequestMapping("/notes")
public class NotesController {

    @Autowired
    private NoteService noteService;


    //create new note
    @RequestMapping(method = RequestMethod.POST, value = "/notes/create")
    public void createNote(@RequestBody CreateNoteRequest request) {
        noteService.createNote(request.title, request.content);
    }

    public static class CreateNoteRequest {
        public String title;
        public String content;
    }

    //find note by id
    @RequestMapping(method = RequestMethod.GET, value = "/notes/{id}")
    public Note findNote(@PathVariable Long id) {
        return noteService.findNote(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //find all notes
    @RequestMapping("/notes")
    public List<Note> findAllNotes() {
        return noteService.findAllNotes();
    }

    //update note
    @RequestMapping(method = RequestMethod.POST, value = "/notes/update/{id}")
    public void updateNote(@PathVariable Long id, @RequestBody CreateNoteRequest request) {
        Note note1 = new Note(request.title, request.content);
        noteService.updateNote(id, note1);
    }

    //delete note
    @RequestMapping(method = RequestMethod.PUT, value = "/notes/delete/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }

}
