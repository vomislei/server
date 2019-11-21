package br.edu.utfpr.pb.tcc2.service;

import java.util.List;

import br.edu.utfpr.pb.tcc2.model.Cliente;
import br.edu.utfpr.pb.tcc2.model.Imovel;

public interface ImovelService extends CrudService<Imovel, Long> {
	
	List<Imovel> findByCliente(Cliente cliente);
}
