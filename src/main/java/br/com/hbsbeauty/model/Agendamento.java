package br.com.hbsbeauty.model;

import javax.persistence.*;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Agendamento implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date datainicio;
	private Date datafim;
	private Date criadoEm;

	@OneToMany
	@JoinTable(name = "funcionario_agendamento",
			joinColumns = {@JoinColumn(name = "agendamento_id")},
			inverseJoinColumns = {@JoinColumn(name = "funcionario_id")}
	)
	private List<Funcionario> funcionarios;

	@OneToMany
	@JoinTable(name = "cliente_agendamento",
			joinColumns = {@JoinColumn(name = "agendamento_id")},
			inverseJoinColumns = {@JoinColumn(name = "cliente_id")}
	)
	private List<Cliente> clientes;

	@OneToMany
	@JoinTable(name = "agendamento_servico",
			joinColumns = {@JoinColumn(name = "agendamento_id")},
			inverseJoinColumns = {@JoinColumn(name = "servico_id")}
	)
	private List<Servico> servico;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDatainicio() {
		return datainicio;
	}

	public void setDatainicio(Date datainicio) {
		this.datainicio = datainicio;
	}

	public Date getDatafim() {
		return datafim;
	}

	public void setDatafim(Date datafim) {
		this.datafim = datafim;
	}

	public Date getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(Date criadoEm) {
		this.criadoEm = criadoEm;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Servico> getServico() {
		return servico;
	}

	public void setServico(List<Servico> servico) {
		this.servico = servico;
	}
}
		