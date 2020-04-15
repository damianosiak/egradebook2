package com.damianosiak.egradebook.repositories;

import com.damianosiak.egradebook.model.Subjects;
import org.springframework.data.repository.CrudRepository;

public interface SubjectsRepository extends CrudRepository<Subjects, Long> {
}
