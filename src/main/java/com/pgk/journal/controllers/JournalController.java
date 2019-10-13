package com.pgk.journal.controllers;


import com.pgk.journal.entity.Entry;
import com.pgk.journal.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class JournalController {

    @Autowired
    private EntryRepository entryRepository;

    @GetMapping
    public String allEntry(Model model) {
        Iterable<Entry> entries = entryRepository.findAll();
        model.addAttribute( "entries",entries);
        return "journal";
    }

    @RequestMapping(path = "/saveEntry")
    public @ResponseBody String saveEntry (@RequestParam String fio,
                                          @RequestParam String dateOfAbsence,
                                          @RequestParam String startTime,
                                          @RequestParam String endTime,
                                          @RequestParam String placeOrCause){

        Entry entry = new Entry(fio, dateOfAbsence, startTime, endTime, placeOrCause);

        entryRepository.save(entry);
        Iterable<Entry> entries = entryRepository.findAll();

        return "entries :: entries";
    }
}