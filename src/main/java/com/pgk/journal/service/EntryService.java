package com.pgk.journal.service;

import com.pgk.journal.entity.Entry;

public interface EntryService {
    void saveEntry(Long idEntry,String fio,String dateOfAbsence,String startTime,String endTime,String placeOrCause);
    void deleteEntryById(Long idEntry);
    String getJsonEntryList(String fioSearch, String startDate, String endDate);
}
