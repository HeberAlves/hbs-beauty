package br.com.hbsbeauty.controller;

import java.util.Date;
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

import br.com.hbsbeauty.model.Agendamento;
import br.com.hbsbeauty.services.AgendamentoServices;

@RestController
public class AgendamentoController {
	
	@Autowired
	AgendamentoServices agendamentoServices;
	
	@GetMapping(value = "/agendamentos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <List<Agendamento>> getAllAgendamentos(){
		List<Agendamento> agendamento = agendamentoServices.getAllAgendamento();
		return new ResponseEntity<> (agendamento,HttpStatus.OK);
	}
	
	@GetMapping(value = "/agendamento/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <Agendamento> getAllAgendamentoById(@PathVariable Integer id){
		Agendamento agendamento = agendamentoServices.getAgendamentoById(id);
		return new ResponseEntity<> (agendamento,HttpStatus.OK);
	}
	
	@PostMapping (value = "/agendamento", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <Agendamento> saveAgendamento(@RequestBody Agendamento agendamento){
		return new ResponseEntity<Agendamento> (agendamentoServices.saveOrUpdateAgendamento(agendamento), HttpStatus.OK);
	}
	
	@PutMapping (value = "/agendamento", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <Agendamento> upadteAgendamento(@RequestBody Agendamento agendamento){
		return new ResponseEntity<Agendamento> (agendamentoServices.saveOrUpdateAgendamento(agendamento), HttpStatus.OK);
	}
	
	@DeleteMapping (value = "/agendamento/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteAgendamento(@PathVariable Integer id){
		return agendamentoServices.deleteAgendamentoById(id);
	}
	
}
