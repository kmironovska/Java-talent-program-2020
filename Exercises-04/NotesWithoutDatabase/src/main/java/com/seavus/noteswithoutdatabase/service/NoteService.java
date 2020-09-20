package com.seavus.noteswithoutdatabase.service;

import com.seavus.noteswithoutdatabase.model.Note;
import com.seavus.noteswithoutdatabase.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public void createNote(String title, String content) {
        Note note = new Note(title, content);
        noteRepository.save(note);
    }

    public Optional<Note> findNote(Long id) {
        return noteRepository.findById(id);
    }

    public List<Note> findAllNotes() {
        return noteRepository.findAll();
    }

    public void updateNote(Long id, Note note) {
        noteRepository.updateById(id, note);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteNote(id);
    }
}
