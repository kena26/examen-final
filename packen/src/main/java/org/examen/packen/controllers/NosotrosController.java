package org.examen.packen.controllers;

import java.util.List;
import org.examen.packen.models.Nosotros;
import org.examen.packen.services.NosotrosRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class NosotrosController{

    NosotrosRepository repository = new NosotrosRepository();

    @GetMapping("/nosotros/all")
    public List<Nosotros> getAllNosotros (){
        return repository.getAllNosotros ();
    }
}