package br.com.hbsbeauty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.hbsbeauty.model.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer>{
	
	@Query(value = "SELECT u FROM Agendamento u")
	List<Agendamento> getAllAgendamneto();

	
	@Query(value = "SELECT u FROM Agendamento u WHERE u.id =:id")
	Agendamento getAgendamentoById(@Param("id")Integer id);
}
