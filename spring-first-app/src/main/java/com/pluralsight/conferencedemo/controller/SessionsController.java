package com.pluralsight.conferencedemo.controller;

import com.pluralsight.conferencedemo.model.Session;
import com.pluralsight.conferencedemo.repository.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
    @Autowired
    private SessionRepository repository;

    @GetMapping
    public List<Session> list() {
        return this.repository.findAll();
    }

    @GetMapping("{id}")
    public Session get(@PathVariable Long id) {
        return this.repository.getReferenceById(id);
    }

    @PostMapping
    public Session create(@RequestBody final Session session) {
        return this.repository.saveAndFlush(session);
    }

    @PutMapping("{id}")
    public Session update(@PathVariable Long id, @RequestBody final Session session) {
        Session existingSession = this.repository.getReferenceById(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return this.repository.saveAndFlush(existingSession);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        this.repository.deleteById(id);
    }

}
