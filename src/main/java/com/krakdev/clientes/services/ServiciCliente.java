package com.krakdev.clientes.services;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.krakdev.clientes.entidades.Cliente;

@Service
public class ServiciCliente {
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	// Metodo Buscar por cedula

	public Cliente buscarPorCedula(String cedula) {
		for (Cliente c : clientes) {
			if (c.getCedula().equals(cedula)) {
				return c;
			}
		}
		return null;
	}

	// Crear cleinte
	public Cliente crearCliente(Cliente cliente) {

		Cliente existente = buscarPorCedula(cliente.getCedula());

		if (existente != null) {
			return null;
		} else {
			clientes.add(cliente);
			return cliente;
		}
	}

	// lista todos los cleite
	public List<Cliente> listar() {
		return clientes;
	}

	// 7actualizar
	public Cliente actualizarCliente(String cedula, Cliente clienteActualizado) {
		Cliente cliente = buscarPorCedula(cedula);
		if (cliente != null) {
			cliente.setNombre(clienteActualizado.getNombre());
			cliente.setApellido(clienteActualizado.getApellido());
		}
		return cliente;
	}

	// eliminar
	public boolean eliminar(String Cedula) {
		Cliente cliente = buscarPorCedula(Cedula);
		if (cliente != null) {
			clientes.remove(cliente);
			return true;
		} else {
			return false;
		}

	}

}
