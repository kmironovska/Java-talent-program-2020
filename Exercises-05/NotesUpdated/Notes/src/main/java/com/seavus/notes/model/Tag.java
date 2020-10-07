package com.seavus.notes.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Tag {

    @Id
    @GeneratedValue
    Long id;
    String name;

    @ManyToOne
    private User user;

    @ManyToMany(mappedBy = "tags")
    private Set<Note> notes;


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Tag(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getUser() {
        return user;
    }

    public Tag() {
    }
}
