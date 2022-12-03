package org.examen.packen.controllers;

import java.util.List;

import org.examen.packen.models.Reporte;
import org.examen.packen.services.ReporteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReporteController  {

    ReporteRepository repository = new ReporteRepository(); 
    
    @GetMapping("/reporte/all")
    public List<Reporte> getAllReporte() {
        return repository.getAllReporte();
    }  

}
