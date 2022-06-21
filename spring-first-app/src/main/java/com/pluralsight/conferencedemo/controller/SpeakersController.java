package com.pluralsight.conferencedemo.controller;

import com.pluralsight.conferencedemo.model.Speaker;
import com.pluralsight.conferencedemo.repository.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {

    @Autowired
    private SpeakerRepository repository;

    @GetMapping
    public List<Speaker> list() {
        return this.repository.findAll();
    }

    @GetMapping("{id}")
    public Speaker get(@PathVariable Long id) {
        return this.repository.getReferenceById(id);
    }

    @PostMapping
    public Speaker create(@RequestBody final Speaker speaker) {
        return this.repository.saveAndFlush(speaker);
    }

    @PutMapping("{id}")
    public Speaker update(@PathVariable Long id, @RequestBody final Speaker speaker) {
        Speaker existingSpeaker = this.repository.getReferenceById(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return this.repository.saveAndFlush(existingSpeaker);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        this.repository.deleteById(id);
    }

}
