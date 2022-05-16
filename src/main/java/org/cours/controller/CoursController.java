package org.cours.controller;

import org.cours.model.Cours;
import org.cours.model.Module;
import org.cours.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.Optional;

@RestController
public class CoursController {
    @Autowired
    private CoursService coursService;

    @RequestMapping("/modules/{moduleId}/cours")
    public LinkedList<Cours> getAllCoursByModuleId(@PathVariable Integer moduleId){
        return coursService.getAllCoursByModuleId(moduleId);
    }

    @RequestMapping("/modules/{moduleId}/cours/{id}")
    public Optional<Cours> getCoursById(@PathVariable Integer id){
        return coursService.getCoursById(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/modules/{moduleId}/cours")
    public void addCours(@PathVariable Integer moduleId , @RequestBody Cours cours){
        Module md = new Module();
        md.setId(moduleId);
        cours.setModule(md);
        coursService.addCours(cours);
    }

    @RequestMapping(method= RequestMethod.PUT, value="/modules/{moduleId}/cours/{id}")
    public void updateCours(@PathVariable Integer moduleId , @RequestBody Cours cours){
        Module md = new Module();
        md.setId(moduleId);
        cours.setModule(md);
        coursService.updateCours(cours);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/modules/{moduleId}/cours/{id}")
    public void addCours(@PathVariable Integer id){
        coursService.deleteCours(id);
    }
}
