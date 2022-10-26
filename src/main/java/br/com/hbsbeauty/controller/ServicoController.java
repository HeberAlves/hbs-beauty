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
import br.com.hbsbeauty.model.Servico;
import br.com.hbsbeauty.services.ServicoServices;

@RestController
public class ServicoController {
	
	@Autowired
	ServicoServices servicoServices;
	
	@GetMapping (value = "/servicos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Servico>> getAllServicos(){
		List<Servico> servico = servicoServices.getAllServicos();
		return new ResponseEntity<>(servico, HttpStatus.OK);
	}
	
	@GetMapping(value = "/servicos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Servico> getServicoById(@PathVariable Integer id){
		Servico servico = servicoServices.getServicoById(id);
		return new ResponseEntity <>(servico, HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/servico", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Servico>saveServico(@RequestBody Servico servico){
		return new ResponseEntity<Servico>(servicoServices.saveOrUpdateServico(servico), HttpStatus.OK);
		
	}
		
	@PutMapping(value = "/servico", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Servico>updateServico(@RequestBody Servico servico){
		return new ResponseEntity<Servico>(servicoServices.saveOrUpdateServico(servico), HttpStatus.OK);
		
	}
	
	@DeleteMapping (value = "/servico/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteServico(@PathVariable Integer id){
		return servicoServices.deleteServico(id);
	}
	


}