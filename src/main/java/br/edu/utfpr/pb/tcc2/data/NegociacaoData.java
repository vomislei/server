package br.edu.utfpr.pb.tcc2.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.tcc2.model.ContaaReceber;
import br.edu.utfpr.pb.tcc2.model.Negociacao;

public interface NegociacaoData extends JpaRepository<Negociacao, Long> {
	
	
}
