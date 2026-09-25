package com.krakdev.clientes.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakdev.clientes.entidades.Cliente;
import com.krakdev.clientes.services.ServiciCliente;

@RestController
@RequestMapping("/clientes")
public class clienteController {

    private final ServiciCliente servicioCliente = new ServiciCliente();

    @PostMapping
    public Cliente crear(@RequestBody Cliente cliente) {
        return servicioCliente.crearCliente(cliente);
    }

    // Listar todos los clientes
    @GetMapping
    public List<Cliente> listar() {
        return servicioCliente.listar();
    }

    // Buscar cliente por cédula
    @GetMapping("/{cedula}")
    public Cliente buscar(@PathVariable String cedula) {
        return servicioCliente.buscarPorCedula(cedula);
    }

    // Actualizar cliente por cédula
    @PutMapping("/{cedula}")
    public Cliente actualizar(
            @PathVariable String cedula,
            @RequestBody Cliente clienteActualizado) {

        return servicioCliente.actualizarCliente(cedula, clienteActualizado);
    }

    // Eliminar cliente por cédula
    @DeleteMapping("/{cedula}")
    public boolean eliminar(@PathVariable String cedula) {
        return servicioCliente.eliminar(cedula);
    }
}