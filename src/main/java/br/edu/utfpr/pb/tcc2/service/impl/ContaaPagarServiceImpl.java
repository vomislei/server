package br.edu.utfpr.pb.tcc2.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.tcc2.data.ContaaPagarData;
import br.edu.utfpr.pb.tcc2.enumeration.StatusContaEnum;
import br.edu.utfpr.pb.tcc2.model.ContaaPagar;
import br.edu.utfpr.pb.tcc2.model.Negociacao;
import br.edu.utfpr.pb.tcc2.service.ContaaPagarService;

@Service
public class ContaaPagarServiceImpl extends CrudServiceImpl<ContaaPagar, Long> implements ContaaPagarService {

	@Autowired
	private ContaaPagarData contaaPagarData;

	@Override
	protected JpaRepository<ContaaPagar, Long> getData() {
		return contaaPagarData;
	}

	@Override
	public void contaaPagar(Negociacao negociacao) {

		for (int i = 1; i <= 12; i++) {

			ContaaPagar entity = new ContaaPagar();

			// LocalDate dataVenc = LocalDate.parse(negociacao.getDatafim());
			LocalDate dataVenc = negociacao.getDatafim();
			dataVenc = dataVenc.plusMonths(i); // adidiconando mês da parcela
			// entity.setDataquitacao(LocalDate.now());
			entity.setNegociacao(negociacao);
			entity.setValorpag(negociacao.getVpagar());
			entity.setStatus(StatusContaEnum.APAGAR);
			entity.setDatavenc(dataVenc);

			save(entity);
		}
	}

}
