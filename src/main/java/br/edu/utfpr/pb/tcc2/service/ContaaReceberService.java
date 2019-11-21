package br.edu.utfpr.pb.tcc2.service;

import br.edu.utfpr.pb.tcc2.model.ContaaReceber;
import br.edu.utfpr.pb.tcc2.model.Negociacao;

public interface ContaaReceberService extends CrudService<ContaaReceber, Long>{

	public void contaaReceberAluguel(Negociacao negociacao);
	
	public void contaaReceberVenda(Negociacao negociacao);
		
}
