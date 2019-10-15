package com.pgk.journal.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pgk.journal.entity.Entry;
import com.pgk.journal.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EntryServiceImpl implements EntryService {

    @Autowired
    EntryRepository entryRepository;

    @Override
    public void saveEntry(Long idEntry,String fio,String dateOfAbsence,String startTime,String endTime,String placeOrCause) {

        Entry entry = new Entry(idEntry, fio, dateOfAbsence, startTime, endTime, placeOrCause);
        entryRepository.save(entry);
    }

    @Override
    public void deleteEntryById(Long idEntry) {
        entryRepository.deleteById(idEntry);
    }

    @Override
    public String getJsonEntryList(String fioSearch, String startDate, String endDate) {
        ObjectMapper mapper = new ObjectMapper();
        Iterable<Entry> entries = null;

        if (fioSearch.equals("")&startDate.equals("")&endDate.equals("")){
            entries = entryRepository.findAll();
        }

        String jsonEntry = null;
        try {
            jsonEntry = mapper.writeValueAsString(entries);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonEntry;
    }
}
