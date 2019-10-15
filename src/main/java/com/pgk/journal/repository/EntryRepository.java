package com.pgk.journal.repository;

import com.pgk.journal.entity.Entry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface EntryRepository extends PagingAndSortingRepository<Entry, Long> {
}
