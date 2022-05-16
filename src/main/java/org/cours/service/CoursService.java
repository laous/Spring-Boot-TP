package org.cours.service;

import org.cours.model.Cours;
import org.cours.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Optional;

@Service
public class CoursService {
    @Autowired
    private CoursRepository coursRepository;

    public LinkedList<Cours> getAllCoursByModuleId(Integer moduleId){
        LinkedList<Cours> cours = new LinkedList<>();
        coursRepository.findCoursByModuleId(moduleId).forEach(cours::add);
        return cours;
    }

    public Optional<Cours> getCoursById(Integer id){
        return coursRepository.findById(id);
    }

    public void addCours(Cours cours) {
        coursRepository.save(cours);
    }

    public void updateCours(Cours cours){
        coursRepository.save(cours);
    }

    public void deleteCours(Integer id){
        coursRepository.deleteById(id);
    }
}
