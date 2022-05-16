package org.cours.repository;

import org.cours.model.Cours;
import org.springframework.data.repository.CrudRepository;

import java.util.LinkedList;

public interface CoursRepository extends CrudRepository<Cours, Integer> {
    public LinkedList<Cours> findCoursByModuleId(Integer moduleId);
}
