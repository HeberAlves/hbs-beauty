package br.com.hbsbeauty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.hbsbeauty.model.Cliente;
import br.com.hbsbeauty.model.User;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer>{
	
	@Query(value = "SELECT u FROM Cliente u")
	List<Cliente> getAllCliente();

	
	@Query(value = "SELECT u FROM Cliente u WHERE u.id =:id")
	Cliente getClienteById(@Param("id")Integer id);
	
	
}
