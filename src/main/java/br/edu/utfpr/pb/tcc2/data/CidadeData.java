package br.edu.utfpr.pb.tcc2.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.tcc2.model.Bairro;
import br.edu.utfpr.pb.tcc2.model.Cidade;

public interface CidadeData extends JpaRepository<Cidade, Long>{
	
}
