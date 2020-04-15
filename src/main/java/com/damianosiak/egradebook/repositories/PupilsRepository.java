package com.damianosiak.egradebook.repositories;

import com.damianosiak.egradebook.model.Pupils;
import org.springframework.data.repository.CrudRepository;

public interface PupilsRepository extends CrudRepository<Pupils, Long> {
}
