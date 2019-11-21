package br.edu.utfpr.pb.tcc2.data;

import org.springframework.data.jpa.repository.JpaRepository;
	
import br.edu.utfpr.pb.tcc2.model.Funcionario;

public interface FuncionarioData extends JpaRepository<Funcionario, Long>{

}
