package com.pgk.journal.repository;

import com.pgk.journal.entity.Entry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EntryRepository extends PagingAndSortingRepository<Entry, Long> {
    Page<Entry> findAllByDateOfAbsenceBetweenAndFioContainingOrDateOfAbsenceBetweenAndPlaceCauseContainingOrderByIdEntryDesc(String startDate, String endDate,String fio,String startDate2, String endDate2, String place, Pageable pageable);
    Page<Entry> findAllByDateOfAbsenceBetweenAndFioContainingOrDateOfAbsenceBetweenAndPlaceCauseContainingOrderByIdEntryAsc(String startDate, String endDate,String fio,String startDate2, String endDate2, String place, Pageable pageable);

}
