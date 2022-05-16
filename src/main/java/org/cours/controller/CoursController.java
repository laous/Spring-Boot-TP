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
    public Optional<Cours> getCoursById(@PathVariable Integer id, @PathVariable Integer moduleId){
        return coursService.getCoursById(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/modules/{moduleId}/cours")
    public void addCours( @RequestBody Cours cours , @PathVariable Integer moduleId){
        cours.setModule(new Module(moduleId, "",""));
        coursService.addCours(cours);
    }

    @RequestMapping(method= RequestMethod.PUT, value="/modules/{moduleId}/cours/{id}")
    public void updateCours(@RequestBody Cours cours , @PathVariable Integer moduleId , @PathVariable Integer id){
        cours.setModule(new Module(moduleId, "",""));
        coursService.updateCours(cours);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/modules/{moduleId}/cours/{id}")
    public void addCours(@PathVariable Integer id, @PathVariable Integer moduleId){
        coursService.deleteCours(id);
    }
}
