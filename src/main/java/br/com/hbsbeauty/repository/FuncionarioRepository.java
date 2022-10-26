package br.com.hbsbeauty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.hbsbeauty.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
	
	@Query (value = "SELECT u FROM Funcionario u")
	List<Funcionario> getAllFuncionario();
	
	@Query (value = "SELECT u FROM Funcionario u WHERE u.matricula =:matricula")
	Funcionario getFuncionarioByMatricula(@Param("matricula")Integer matricula);
	
	

}
