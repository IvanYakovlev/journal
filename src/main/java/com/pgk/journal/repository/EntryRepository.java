package com.pgk.journal.repository;

import com.pgk.journal.entity.Entry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface EntryRepository extends PagingAndSortingRepository<Entry, Long> {
    Page<Entry> findAllByDateOfAbsenceBetweenAndFioContainingOrPlaceCauseContaining(String startDate, String endDate,String fio,String place, Pageable pageable);


}
