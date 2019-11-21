package br.edu.utfpr.pb.tcc2.service;

import br.edu.utfpr.pb.tcc2.model.ContaaPagar;
import br.edu.utfpr.pb.tcc2.model.Negociacao;

public interface ContaaPagarService extends CrudService<ContaaPagar, Long>{

	public void contaaPagar(Negociacao negociacao);
	
}
