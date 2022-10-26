package br.com.hbsbeauty.services;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.hbsbeauty.model.Cliente;
import br.com.hbsbeauty.model.Funcionario;
import br.com.hbsbeauty.model.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hbsbeauty.model.Agendamento;
import br.com.hbsbeauty.repository.AgendamentoRepository;

@Service
public class AgendamentoServices {
	
	@Autowired
	AgendamentoRepository agendamentoRepository;

	@Autowired
	ClienteServices clienteServices;

	@Autowired
	FuncionarioServices funcionarioServices;

	@Autowired
	ServicoServices servicoServices;
	
	public List<Agendamento> getAllAgendamento(){
		return agendamentoRepository.getAllAgendamneto();
	}
	
	public Agendamento getAgendamentoById(Integer id) {
		return agendamentoRepository.getAgendamentoById(id);
	}
	
	public Agendamento saveOrUpdateAgendamento(Agendamento agendamento) {

		Agendamento agendamentoNovo = new Agendamento();

		agendamentoNovo.setCriadoEm(agendamento.getCriadoEm());
		agendamentoNovo.setDatafim(agendamento.getDatafim());
		agendamentoNovo.setDatainicio(agendamento.getDatainicio());

		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		List<Servico> servicos = new ArrayList<Servico>();
		List<Cliente> clientes = new ArrayList<Cliente>();

		for(int i = 0; i < agendamento.getFuncionarios().size(); i++){
			funcionarios.add(funcionarioServices.getFuncionarioById(agendamento.getFuncionarios().get(i).getId()));
		}

		agendamentoNovo.setFuncionarios(funcionarios);

		for(int i = 0; i < agendamento.getClientes().size(); i++){
			clientes.add(clienteServices.getClienteById(agendamento.getClientes().get(i).getId()));
		}
		agendamentoNovo.setClientes(clientes);

		for(int i = 0; i < agendamento.getServico().size(); i++){
			servicos.add(servicoServices.getServicoById(agendamento.getServico().get(i).getId()));
		}

		agendamentoNovo.setServico(servicos);

		return agendamentoRepository.save(agendamentoNovo);
	}
	
	public String deleteAgendamentoById(Integer id) {
		try {
			agendamentoRepository.deleteById(id);
			return "Agendamento deletado com sucesso com id: "+id;
		}catch(Exception e) {
			return "Erro ao deletar o agendamento";
		}
	}
	
	
	

}
