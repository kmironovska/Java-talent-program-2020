package com.seavus.notes.service;


import com.seavus.notes.model.Note;
import com.seavus.notes.model.Tag;
import com.seavus.notes.model.User;
import com.seavus.notes.repository.NoteRepository;
import com.seavus.notes.repository.TagRepository;
import com.seavus.notes.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class NoteService {


    private SecurityService securityService;

    private NoteRepository noteRepository;

    private TagRepository tagRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository, SecurityService securityService, TagRepository tagRepository) {
        this.noteRepository = noteRepository;
        this.securityService = securityService;
        this.tagRepository = tagRepository;
    }

    //find all notes
    public Set<Note> findNotes() {
        User user = securityService.getAuthenticatedUser();
        return noteRepository.findNotesByUserId(user.getId());
    }

    //find note by id
    public Optional<Note> findNoteById(Long id) {
        return noteRepository.findById(id);
    }

    //create new note
    public Note createNote(String title, String content,Set<Long> tagId) {
        User user = securityService.getAuthenticatedUser();
        Set<Tag>tags = tagRepository.findAllById(tagId).stream().filter(t -> t.getUser().equals(user)).collect(Collectors.toSet());
        Note note = new Note(title, content, user, tags);
        return noteRepository.save(note);

    }

    //update note
    public Note updateNoteById(Long id, String title, String content, Set<Long> tagId) {
        User user = securityService.getAuthenticatedUser();
        Set<Tag>tags = tagRepository.findAllById(tagId).stream().filter(t -> t.getUser().equals(user)).collect(Collectors.toSet());
        Set<Note> notes = noteRepository.findNotesByUserId(user.getId());
        Note note = notes.stream().filter(n -> n.getId().equals(id)).findFirst().orElseThrow(IllegalArgumentException::new);

        note.setTitle(title);
        note.setContent(content);
        note.setTags(tags);
        return noteRepository.save(note);
    }

    //delete note
    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }


    public List<Note> findNotesByTagsId(Long id) {

        return noteRepository.findNotesByTagsId(id);
    }

}
