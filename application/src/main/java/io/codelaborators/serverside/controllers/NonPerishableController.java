package io.codelaborators.serverside.controllers;

import io.codelaborators.serverside.models.NonPerishable;
import io.codelaborators.serverside.repositories.NonPerishableRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
@CrossOrigin
public class NonPerishableController {

    @Resource
    private NonPerishableRepository nonPerishableRepo;

    @GetMapping("/non-perishables")
    public Collection<NonPerishable> getAllNonPerishables(){
        return (Collection<NonPerishable>) nonPerishableRepo.findAll();
    }
}
