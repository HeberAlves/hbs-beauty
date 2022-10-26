package br.com.hbsbeauty.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hbsbeauty.model.Funcionario;
import br.com.hbsbeauty.repository.FuncionarioRepository;

@Service
public class FuncionarioServices {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	public List<Funcionario> getAllFuncionario() {
		return funcionarioRepository.getAllFuncionario();
	}
	public Funcionario getFuncionarioById(Integer id) {
		return funcionarioRepository.getFuncionarioById(id);
	}
	
	public Funcionario saveOrUpdateFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	public String deleteFuncionario(Integer matricula) {
		try {
				funcionarioRepository.deleteById(matricula);
			return "Funcionario, matricula: "+matricula+" deletado com sucesso";
		}catch(Exception e) {
			return "Erro ao deletar o funcionario";
		}
	}
	

}
