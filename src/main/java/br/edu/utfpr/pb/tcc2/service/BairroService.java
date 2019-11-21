package br.edu.utfpr.pb.tcc2.service;

import java.util.List;

import br.edu.utfpr.pb.tcc2.model.Bairro;
import br.edu.utfpr.pb.tcc2.model.Cidade;

public interface BairroService extends CrudService<Bairro, Long>{

	List<Bairro> findByCidade(Cidade cidade);

}
