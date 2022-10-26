package br.com.hbsbeauty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.hbsbeauty.model.Cliente;
import br.com.hbsbeauty.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {
	
	@Query (value = "SELECT u FROM Servico u")
	List<Servico> getAllServico();
	

	@Query(value = "SELECT u FROM Servico u WHERE u.id =:id")
	Servico getServicoById(@Param("id")Integer id);
	
	
}
