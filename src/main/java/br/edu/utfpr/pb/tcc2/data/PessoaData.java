package br.edu.utfpr.pb.tcc2.data;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.tcc2.model.Pessoa;

public interface PessoaData extends JpaRepository<Pessoa, Long> {
}
