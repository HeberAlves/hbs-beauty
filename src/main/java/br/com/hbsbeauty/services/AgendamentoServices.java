package br.com.hbsbeauty.services;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hbsbeauty.model.Agendamento;
import br.com.hbsbeauty.repository.AgendamentoRepository;

@Service
public class AgendamentoServices {
	
	@Autowired
	AgendamentoRepository agendamentoRepository;
	
	public List<Agendamento> getAllAgendamento(){
		return agendamentoRepository.getAllAgendamneto();
	}
	
	public Agendamento getAgendamentoById(Integer id) {
		return agendamentoRepository.getAgendamentoById(id);
	}
	
	public Agendamento saveOrUpdateAgendamento(Agendamento agendamento) {
		return agendamentoRepository.save(agendamento);
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
