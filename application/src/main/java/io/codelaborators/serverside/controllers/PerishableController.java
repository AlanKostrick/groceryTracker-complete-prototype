package io.codelaborators.serverside.controllers;

import io.codelaborators.serverside.models.Perishable;
import io.codelaborators.serverside.repositories.PerishableRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
@CrossOrigin
public class PerishableController {

    @Resource
    private PerishableRepository perishableRepo;

    @GetMapping("/perishables")
    public Collection<Perishable> getPerishables(){
        return (Collection<Perishable>) perishableRepo.findAll();
    }
}
