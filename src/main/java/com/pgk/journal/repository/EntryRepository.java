package com.pgk.journal.repository;

import com.pgk.journal.entity.Entry;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface EntryRepository extends CrudRepository<Entry, Long> {

}
