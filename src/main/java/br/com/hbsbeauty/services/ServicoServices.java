package br.com.hbsbeauty.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hbsbeauty.model.Servico;
import br.com.hbsbeauty.repository.ServicoRepository;

@Service
public class ServicoServices {
	
	@Autowired
	ServicoRepository servicoRepository;
	
	public List<Servico> getAllServicos(){
		return servicoRepository.getAllServico();
	}
	
	public Servico getServicoById(Integer id){
		return servicoRepository.getServicoById(id);
		
	}
	
	public Servico saveOrUpdateServico(Servico servico) {
		return servicoRepository.save(servico);
	}
	
	public String deleteServico(Integer id) {
		try {
			servicoRepository.deleteById(id);
			return "Servico deletado com sucesso";
		}catch (Exception e){
			return "Erro ao deletar o servido id: "+id;
		}
	}

}
