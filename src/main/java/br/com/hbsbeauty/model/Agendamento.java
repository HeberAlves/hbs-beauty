package br.com.hbsbeauty.model;

import javax.persistence.Column;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Agendamento {
	
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date datainicio;
	private Date datafim;
	private Date criadoEm;
	
	@ManyToOne
	private Funcionario funcionario;
	
	@ManyToOne
	private Cliente cliente;
	
	@OneToMany
	private List<Servico> servico;
	
	
	public Agendamento() {
		
	}

	public Agendamento(Integer id,Date datainicio, Date datafim, Date dataAgendamento, Funcionario funcionario, Cliente cliente, List<Servico> servico) {
		super();
		this.id = id;
		this.datainicio = datainicio;
		this.datafim = datafim;
		this.criadoEm = dataAgendamento;
		this.funcionario = funcionario;
		this.cliente = cliente;
		this.servico = servico;
	}

	public Integer getId() {
		return id;
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

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Servico> getServico() {
		return servico;
	}

	public void setServico(List<Servico> servico) {
		this.servico = servico;
	}

	

	

	
	
	
}
		