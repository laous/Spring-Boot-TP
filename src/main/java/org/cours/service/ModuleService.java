package org.cours.service;


import org.cours.model.Module;
import org.cours.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Optional;

@Service
public class ModuleService {
    @Autowired
    private ModuleRepository moduleRepository;

    public LinkedList<Module> getAllModules(){
        LinkedList<Module> modules = new LinkedList<>();
        moduleRepository.findAll().forEach(modules::add);
        return modules;
    }

    public Optional<Module> getModule(Integer id){
        return moduleRepository.findById(id);
    }

    public void addModule(Module module) {
        moduleRepository.save(module);
    }

    public void updateModule(Integer id, Module module){
        moduleRepository.save(module);
    }

    public void deleteModule(Integer id){
        moduleRepository.deleteById(id);
    }
}