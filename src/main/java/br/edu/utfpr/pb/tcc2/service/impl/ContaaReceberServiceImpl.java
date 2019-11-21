package br.edu.utfpr.pb.tcc2.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.tcc2.data.ContaaReceberData;
import br.edu.utfpr.pb.tcc2.enumeration.StatusContaEnum;
import br.edu.utfpr.pb.tcc2.model.ContaaReceber;
import br.edu.utfpr.pb.tcc2.model.Negociacao;
import br.edu.utfpr.pb.tcc2.service.ContaaReceberService;
@Service
public class ContaaReceberServiceImpl extends CrudServiceImpl<ContaaReceber, Long> implements ContaaReceberService {

	@Autowired private ContaaReceberData contaaReceberData;

	@Override
	protected JpaRepository<ContaaReceber, Long> getData() {
		return contaaReceberData;
	}
	@Override
	public void contaaReceberAluguel(Negociacao negociacao) {

		for (int i = 1; i <= 12; i++) {
			ContaaReceber entity = new ContaaReceber();
			
			LocalDate dataVenc = negociacao.getDatafim(); //criando data de venc
			dataVenc = dataVenc.plusMonths(i);  //adidiconando mês da parcela
			
//			LocalDate dataQuitacao = LocalDate.now(); //tem que receber vazio
			entity.setNegociacao(negociacao);
			entity.setValorrec(negociacao.getVreceber());
			entity.setStatus(StatusContaEnum.ARECEBER);
			entity.setDatavenc(dataVenc);
			//entity.setDataquitacao(LocalDate.now());
			//entity.setDataquitacao(LocalDate.now().toString());
//			entity.setDataquitacao(dataQuitacao.toString());
			save(entity);
		}
	}
	@Override
	public void contaaReceberVenda(Negociacao negociacao) {
		ContaaReceber entity = new ContaaReceber();
		
		entity.setNegociacao(negociacao);
		entity.setValorrec((negociacao.getVreceber() - negociacao.getVpagar()));//Calculo valor de recebimento
		entity.setStatus(StatusContaEnum.ARECEBER);
		//entity.setDatavenc(LocalDate.parse(negociacao.getDatainicio()).plusMonths(1));
		entity.setDatavenc(negociacao.getDatafim().plusMonths(1));
		//entity.setDataquitacao(LocalDate.now());
//		entity.setDataquitacao(dataQuitacao.toString());
		save(entity);
		
		
	}
		
}
