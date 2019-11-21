package br.edu.utfpr.pb.tcc2.service;

import br.edu.utfpr.pb.tcc2.model.Negociacao;

public interface NegociacaoService extends CrudService<Negociacao, Long> {

	public Negociacao saveNegociacao(Negociacao negociacao);

}
