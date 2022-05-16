package org.cours.controller;


import org.cours.model.Module;
import org.cours.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    @RequestMapping("/modules")
    public List<Module> getModules(){
        return moduleService.getAllModules();
    }

    @RequestMapping("/modules/{id}")
    public Optional<Module> getModule(@PathVariable Integer id){
        return moduleService.getModule(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/modules")
    public void addModule(@RequestBody Module module){
        moduleService.addModule(module);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/modules/{id}")
    public void updateModule(@RequestBody Module module,@PathVariable Integer id){
        moduleService.updateModule(id,module);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/modules/{id}")
    public void deleteModule(@PathVariable Integer id){
        moduleService.deleteModule(id);
    }
}
