package com.krakdev.clientes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.krakdev.clientes.entidades.Cliente;
import com.krakdev.clientes.services.ServiciCliente;

public class TestServiciCliente {

	// Prueba que un cliente nuevo se agregue correctamente.
	@Test
	public void testCrearCliente() {

		ServiciCliente servicio = new ServiciCliente();

		Cliente cliente = new Cliente();
		cliente.setCedula("1723456789");
		cliente.setNombre("Galo");
		cliente.setApellido("Cisneros");

		Cliente resultado = servicio.crearCliente(cliente);

		assertEquals(cliente, resultado);
		assertEquals(1, servicio.listar().size());
	}

	// Prueba que no se pueda crear un cliente con una cédula repetida.
	@Test
	public void testCrearClienteDuplicado() {

		ServiciCliente servicio = new ServiciCliente();

		Cliente cliente1 = new Cliente();
		cliente1.setCedula("1723456789");
		cliente1.setNombre("Galo");
		cliente1.setApellido("Cisneros");

		Cliente cliente2 = new Cliente();
		cliente2.setCedula("1723456789");
		cliente2.setNombre("Pedro");
		cliente2.setApellido("Perez");

		servicio.crearCliente(cliente1);

		Cliente resultado = servicio.crearCliente(cliente2);

		assertNull(resultado);
		assertEquals(1, servicio.listar().size());
	}

	// Prueba que se pueda buscar un cliente existente por su cédula.
	@Test
	public void testBuscarPorCedulaExistente() {

		ServiciCliente servicio = new ServiciCliente();

		Cliente cliente = new Cliente();
		cliente.setCedula("1723456789");
		cliente.setNombre("Galo");
		cliente.setApellido("Cisneros");

		servicio.crearCliente(cliente);

		Cliente resultado = servicio.buscarPorCedula("1723456789");

		assertEquals(cliente, resultado);
	}

	// Prueba que buscar una cédula inexistente retorne null.
	@Test
	public void testBuscarPorCedulaNoExistente() {

		ServiciCliente servicio = new ServiciCliente();

		Cliente resultado = servicio.buscarPorCedula("9999999999");

		assertNull(resultado);
	}

	// Prueba que listar retorne todos los clientes registrados.
	@Test
	public void testListarClientes() {

		ServiciCliente servicio = new ServiciCliente();

		Cliente cliente1 = new Cliente();
		cliente1.setCedula("1111111111");
		cliente1.setNombre("Galo");
		cliente1.setApellido("Cisneros");

		Cliente cliente2 = new Cliente();
		cliente2.setCedula("2222222222");
		cliente2.setNombre("Maria");
		cliente2.setApellido("Lopez");

		servicio.crearCliente(cliente1);
		servicio.crearCliente(cliente2);

		assertEquals(2, servicio.listar().size());
	}

	// Prueba que se pueda actualizar un cliente existente.
	@Test
	public void testActualizarClienteExistente() {

		ServiciCliente servicio = new ServiciCliente();

		Cliente cliente = new Cliente();
		cliente.setCedula("1723456789");
		cliente.setNombre("Galo");
		cliente.setApellido("Cisneros");

		servicio.crearCliente(cliente);

		Cliente actualizado = new Cliente();
		actualizado.setNombre("Carlos");
		actualizado.setApellido("Perez");

		Cliente resultado = servicio.actualizarCliente("1723456789", actualizado);

		assertEquals("Carlos", resultado.getNombre());
		assertEquals("Perez", resultado.getApellido());
	}

	// Prueba que actualizar un cliente inexistente retorne null.
	@Test
	public void testActualizarClienteNoExistente() {

		ServiciCliente servicio = new ServiciCliente();

		Cliente actualizado = new Cliente();
		actualizado.setNombre("Carlos");
		actualizado.setApellido("Perez");

		Cliente resultado = servicio.actualizarCliente("9999999999", actualizado);

		assertNull(resultado);
	}

	// Prueba que se pueda eliminar un cliente existente.
	@Test
	public void testEliminarClienteExistente() {

		ServiciCliente servicio = new ServiciCliente();

		Cliente cliente = new Cliente();
		cliente.setCedula("1723456789");
		cliente.setNombre("Galo");
		cliente.setApellido("Cisneros");

		servicio.crearCliente(cliente);

		boolean resultado = servicio.eliminar("1723456789");

		assertTrue(resultado);
		assertEquals(0, servicio.listar().size());
		assertNull(servicio.buscarPorCedula("1723456789"));
	}

	// Prueba que eliminar un cliente inexistente retorne false.
	@Test
	public void testEliminarClienteNoExistente() {

		ServiciCliente servicio = new ServiciCliente();

		boolean resultado = servicio.eliminar("9999999999");

		assertFalse(resultado);
	}
}