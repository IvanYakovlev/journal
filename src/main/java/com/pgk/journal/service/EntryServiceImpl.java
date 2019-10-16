package com.pgk.journal.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pgk.journal.entity.Entry;
import com.pgk.journal.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EntryServiceImpl implements EntryService {

    @Autowired
    EntryRepository entryRepository;

    @Override
    public void saveEntry(Long idEntry,String fio,String dateOfAbsence,String startTime,String endTime,String placeCause) {

        Entry entry = new Entry(idEntry, fio, dateOfAbsence, startTime, endTime, placeCause);
        entryRepository.save(entry);
    }

    @Override
    public void deleteEntryById(Long idEntry) {
        entryRepository.deleteById(idEntry);
    }

    @Override
    public String getJsonEntryList(String searchText, String startDate, String endDate, Integer page) {
        ObjectMapper mapper = new ObjectMapper();
        Iterable<Entry> entries = null;


        Sort sort = new Sort(Sort.Direction.ASC, "idEntry");
        Pageable pageable = PageRequest.of(page, 10,sort);

         entries = entryRepository.findAllByDateOfAbsenceBetweenAndFioContainingOrPlaceCauseContaining(startDate,endDate,searchText,searchText,pageable);

        String jsonEntry = null;
        try {
            jsonEntry = mapper.writeValueAsString(entries);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonEntry;
    }
}
