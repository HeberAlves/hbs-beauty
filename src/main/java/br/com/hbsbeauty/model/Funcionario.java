package br.com.hbsbeauty.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Funcionario {
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer matricula;
	private String nome;
	private String cargo;
	private Double salario;
	
	@OneToMany
	private List<Agendamento> agendamento;
	
	@ManyToOne
	private User user;
	
	public Funcionario () {
	}

	public Funcionario(Integer matricula, String nome, String cargo, Double salario) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.cargo = cargo;
		this.salario = salario;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	
	
	
	
	

}
