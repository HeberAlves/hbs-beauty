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

import br.com.hbsbeauty.model.Funcionario;
import br.com.hbsbeauty.services.FuncionarioServices;

@RestController
public class FuncionarioController {
	
	@Autowired
	FuncionarioServices funcionarioServices;
	
	
	@GetMapping (value = "/funcionario", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Funcionario>> getAllFuncionarios(){
		List<Funcionario> funcionario = funcionarioServices.getAllFuncionario();
		return new ResponseEntity<>(funcionario,HttpStatus.OK);
	}
	
	@GetMapping (value = "/funcionario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <Funcionario> getFuncionarioById(@PathVariable Integer id){
		Funcionario funcionario = funcionarioServices.getFuncionarioById(id);
		return new ResponseEntity<>(funcionario,HttpStatus.OK);
	}
	
	@PostMapping (value = "/funcionario", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Funcionario> saveFuncionario(@RequestBody Funcionario funcionario){
		return new ResponseEntity<Funcionario>(funcionarioServices.saveOrUpdateFuncionario(funcionario), HttpStatus.OK);
	}
	
	@PutMapping (value = "/funcionario", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Funcionario> updateFuncionario(@RequestBody Funcionario funcionario){
		return new ResponseEntity<Funcionario>(funcionarioServices.saveOrUpdateFuncionario(funcionario), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/funcionario/{matricula}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteFuncionarioByMatricula(@PathVariable Integer matricula){
		return funcionarioServices.deleteFuncionario(matricula);
	}
}
