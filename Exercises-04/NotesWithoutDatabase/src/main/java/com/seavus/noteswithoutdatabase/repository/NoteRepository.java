package com.seavus.noteswithoutdatabase.repository;

import com.seavus.noteswithoutdatabase.model.Note;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class NoteRepository {


    private ArrayList<Note> notes = new ArrayList<>();

    private long nextId = 1;

    //create new note
    public void save(Note note) {
        note.setId(nextId++);
        notes.add(note);
    }

    //find note by id
    public Optional<Note> findById(Long id) {
        return notes.stream().filter(note -> note.getId().equals(id)).findFirst();
    }
    //find all notes

    public List<Note> findAll() {
        return notes;
    }

    //update note
    public void updateById(Long id, Note note) {
        for (Note note1 : notes) {
            if (note1.getId().equals(id)) {
                note1.setContent(note.getContent());
                note1.setTitle(note.getTitle())
                break;
            }
        }
    }

    //delete note
    public void deleteNote(Long id) {
        notes.removeIf(note -> note.getId().equals(id));
    }

}
