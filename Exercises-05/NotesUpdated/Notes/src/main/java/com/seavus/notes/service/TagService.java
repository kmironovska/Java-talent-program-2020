package com.seavus.notes.service;

import com.seavus.notes.model.Tag;
import com.seavus.notes.model.User;
import com.seavus.notes.repository.TagRepository;
import com.seavus.notes.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    private TagRepository tagRepository;

    private SecurityService securityService;

    @Autowired
    public TagService(TagRepository tagRepository, SecurityService securityService) {
        this.tagRepository = tagRepository;
        this.securityService = securityService;
    }

    public Tag createTag(String name) {
        User user = securityService.getAuthenticatedUser();
        Tag t = new Tag(name, user);
        return tagRepository.save(t);

    }

    public Tag updateTag(Long id, Tag tag) {
        User user = securityService.getAuthenticatedUser();
        Tag existingTag = tagRepository.findById(id).get();
        existingTag.setName(tag.getName());
        Tag updatedTag = tagRepository.save(existingTag);

        return new Tag(updatedTag.getName(), user);

    }


    public List<Tag> findTags(User user) {
        return tagRepository.findByUser(user);

    }


    public Optional<Tag> findTagById(Long id) {

        return tagRepository.findById(id);
    }

    public void deleteTagById(Long id) {
        tagRepository.deleteById(id);
    }
}
