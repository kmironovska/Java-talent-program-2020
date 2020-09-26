package com.seavus.notes.api;

import com.seavus.notes.model.Tag;
import com.seavus.notes.model.User;
import com.seavus.notes.security.SecurityService;
import com.seavus.notes.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class TagController {

    private TagService tagService;

    private SecurityService securityService;

    @Autowired
    public TagController(TagService tagService, SecurityService securityService) {
        this.tagService = tagService;
        this.securityService = securityService;
    }

    @PostMapping("/api/tags")
    public void createTag(@RequestBody CreateTagRequest request) {
        tagService.createTag(request.name);
    }

    @GetMapping("/api/tags/{id}")
    public Tag findTag(@PathVariable Long id) {
        return tagService.findTagById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/api/tags")
    public List<Tag> findTags() {
        User user = securityService.getAuthenticatedUser();
        return tagService.findTags(user);
    }

    @DeleteMapping("/api/tags/{id}")
    public void deleteTag(@PathVariable Long id) {
        tagService.deleteTagById(id);
    }

    public static class CreateTagRequest {
        public String name;
    }
}
