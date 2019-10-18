package com.pgk.journal.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pgk.journal.entity.Entry;
import com.pgk.journal.repository.EntryRepository;
import com.pgk.journal.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class JournalController {

    @Autowired
    private EntryService entryService;

    @RequestMapping(path = "/")
    public String allEntry() {
        return "journal";
    }

    @RequestMapping(path = "/saveEntry")
    public @ResponseBody String saveEntry (@RequestParam Long idEntry,
                                           @RequestParam String fio,
                                          @RequestParam String dateOfAbsence,
                                          @RequestParam String startTime,
                                          @RequestParam String endTime,
                                          @RequestParam String placeCause){
        entryService.saveEntry( idEntry, fio, dateOfAbsence, startTime, endTime, placeCause);
        return null;
    }

    @RequestMapping(path = "/deleteEntry")
    public @ResponseBody String deleteEntry (@RequestParam Long idEntry){
        entryService.deleteEntryById(idEntry);
        return null;
    }

    @RequestMapping(path = "/loadEntry")
    public @ResponseBody String loadEntry (@RequestParam String searchText,
                                           @RequestParam String startDate,
                                           @RequestParam String endDate,
                                           @RequestParam Integer page){
        return entryService.getJsonEntryList(searchText,startDate,endDate, page==null?0:page);
    }


}