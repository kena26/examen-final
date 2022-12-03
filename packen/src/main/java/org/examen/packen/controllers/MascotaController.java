package org.examen.packen.controllers;

import java.util.List;

import org.examen.packen.models.Mascota;
import org.examen.packen.services.MascotaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MascotaController {

    private MascotaRepository repository = new MascotaRepository();

    @GetMapping("/mascota/all")
    public List<Mascota> getAllMascotas(){
        return repository.getAllMascotas();
    }

    @GetMapping("/mascota/cedulacli/{cedula}")
    public List<Mascota> getMascotasByCedulaCli (@PathVariable String cedula) {
        return repository.getMascotasByCedulaCli(cedula);
    }

    @GetMapping("/mascota/busqueda/{nombre}")
    public List<Mascota> getMascotasByNombre (@PathVariable String nombre) {
        return repository.getMascotasByNombre(nombre);
    }
}
   
