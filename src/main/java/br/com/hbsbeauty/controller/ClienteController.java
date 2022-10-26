package br.com.hbsbeauty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.hbsbeauty.model.Cliente;
import br.com.hbsbeauty.model.User;
import br.com.hbsbeauty.services.ClienteServices;

@RestController
public class ClienteController {
	
	@Autowired
	ClienteServices clienteServices;
	
	@GetMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List <Cliente>> getAllClientes(){
		List <Cliente> cliente = clienteServices.getAllClientes();
		return new ResponseEntity <>(cliente, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/clientes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id){
		Cliente cliente = clienteServices.getClienteById(id);
		return new ResponseEntity <>(cliente, HttpStatus.OK);
	}
	
	@PostMapping(value = "/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente>saveCliente(@RequestBody Cliente cliente){
		return new ResponseEntity<Cliente>(clienteServices.saveOrUpdateCliente(cliente), HttpStatus.OK);
		
	}
	
	@PutMapping(value = "/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente>updateCliente(@RequestBody Cliente cliente){
		return new ResponseEntity<Cliente>(clienteServices.saveOrUpdateCliente(cliente), HttpStatus.CREATED);
	}
		
	@DeleteMapping (value = "cliente/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteCliente(@PathVariable Integer id){
		return clienteServices.deleteCliente(id);
	}
	
	
	
		
	
	

}
