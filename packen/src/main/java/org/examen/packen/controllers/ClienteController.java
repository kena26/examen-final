package org.examen.packen.controllers;

import java.util.List;
import org.examen.packen.models.Cliente;
import org.examen.packen.services.ClienteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// decorador
@RestController
public class ClienteController {

    ClienteRepository repository = new ClienteRepository();
    
    @GetMapping("/clientes/all")
    public List<Cliente> getAllClientes () {
        return repository.getAllClientes();
    }

    // http//:localhost:8080/clientes/cedula/10-5222-2222
    @GetMapping("/cliente/cedula/{cedula}")
    public Cliente getClientesByCedula (@PathVariable String cedula) {
        return repository.getClienteByCedula(cedula);
    }
    
    @GetMapping("/cliente/passyemail/{contra}/{correo}")
    public Cliente getClienteByPassYEmail (@PathVariable String contra,@PathVariable String correo) {
        return repository.getClienteByPassYEmail(contra, correo);
    }

    @GetMapping("/clientes/cedulaoemail/{cedula}/{correo}")
    public List<Cliente> getClientesListaByCedulaYEmail (@PathVariable String cedula, @PathVariable String correo) {
        return repository.getClientesListaByCedulaYEmail(cedula, correo);
    }

    @PostMapping("/cliente/registro")
    public Cliente setCliente(@RequestBody Cliente cliente) {
        repository.setCliente(cliente);
        return cliente;
    }

    @PutMapping("/cliente/update")
    public Cliente updateCliente(@RequestBody Cliente cliente) {
        repository.updateCliente(cliente);
        return cliente;
    }

    /*
    Faltan 3 endpoints
  **  getClienteByPassYEmail -> /cliente/passyemail/{contra}/{email} -> [GET]
    setCliente -> /cliente/registro -> [POST]
    updateCliente -> /cliente/update -> [PUT]

    Deben crear la misma estructura que creamos con los anteriores endpoints,
    un método para cada enpoint en el reposiroty y en aqui en el controller

    para [POST] Y [PUT] deben usar el @RequestBody, investigenlo, es similar al @PathVariable

    ----------------------------------------------------------------------------------------

    también investiguen el fetch, es una clase de JavaScript para hacer consultas a api's

    investigar también Y APRENDER DOM Scripting en JavaScript (objeto document)

    adios.
    */

}