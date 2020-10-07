package com.seavus.notes.repository;

import com.seavus.notes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {


    @Query(value = "select * from note join note_tags on note.id=note_tags.notes_id where note_tags.tags_id = :id", nativeQuery = true)
    List<Note> findNotesByTagsId(Long id);

    @Query(value = "select * from note where user_id =:id", nativeQuery = true)
    Set<Note> findNotesByUserId(Long id);



}
