package br.com.hbsbeauty.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hbsbeauty.model.Cliente;
import br.com.hbsbeauty.repository.ClienteRepository;

@Service
public class ClienteServices {
	
	
	@Autowired
	private ClienteRepository clienteRepository; 
	
	public Cliente getClienteById(Integer id) {
		return clienteRepository.getClienteById(id);
	}
	
	public List<Cliente> getAllClientes(){
		return clienteRepository.getAllCliente();
	}
	
	public Cliente saveOrUpdateCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public String deleteCliente(Integer id) {
		try {
			clienteRepository.deleteById(id);
			return "Cliente deletado com sucesso";
		}catch(Exception e){
			return "Cliente deletar o cliente id: "+id;
		}

}

}