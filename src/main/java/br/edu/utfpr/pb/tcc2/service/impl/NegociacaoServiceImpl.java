package br.edu.utfpr.pb.tcc2.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.tcc2.data.NegociacaoData;
import br.edu.utfpr.pb.tcc2.enumeration.StatusNegociacaoEnum;
import br.edu.utfpr.pb.tcc2.model.Imovel;
import br.edu.utfpr.pb.tcc2.model.Negociacao;
import br.edu.utfpr.pb.tcc2.service.ContaaPagarService;
import br.edu.utfpr.pb.tcc2.service.ContaaReceberService;
import br.edu.utfpr.pb.tcc2.service.ImovelService;
import br.edu.utfpr.pb.tcc2.service.NegociacaoService;

@Service
public class NegociacaoServiceImpl extends CrudServiceImpl<Negociacao, Long> implements NegociacaoService {

	@Autowired
	NegociacaoData negociacaoData;

	@Autowired
	private ContaaPagarService pagarService;

	@Autowired
	private ContaaReceberService receberService;

	@Autowired
	private ImovelService imovelService;

	@Override
	protected JpaRepository<Negociacao, Long> getData() {
		return negociacaoData;
	}

	@Override
	public Negociacao saveNegociacao(Negociacao negociacaoaux) {

		Negociacao negociacao = new Negociacao();

		negociacao = save(negociacaoaux);
		
		if (negociacao.getStatus() != StatusNegociacaoEnum.FINALIZADA) {
			negociacao.setDatafim(LocalDate.now());
			negociacao.setStatus(StatusNegociacaoEnum.FINALIZADA);
			negociacao.getImovel().setAtivo(Boolean.FALSE);
			negociacao.getImovel().setVenda(Boolean.FALSE);
			negociacao.getImovel().setLocacao(Boolean.FALSE);
			save(negociacao);
			
			if (negociacao.getTiponegocio()) {
				pagarService.contaaPagar(negociacao);
				receberService.contaaReceberAluguel(negociacao);
			} else {
				receberService.contaaReceberVenda(negociacao);
				
				Imovel imovel = new Imovel();
				imovel.setCliente(negociacao.getCliente());
				imovel.setAtivo(Boolean.TRUE);
				imovel.setVenda(Boolean.FALSE);
				imovel.setLocacao(Boolean.FALSE);
				imovel.setVvenda(null);
				imovel.setVlocacao(null);
				imovel.setLatitude(negociacao.getImovel().getLatitude());
				imovel.setLongitude(negociacao.getImovel().getLongitude());
				imovel.setBairro(negociacao.getImovel().getBairro());
				imovel.setQuartos(negociacao.getImovel().getQuartos());
				imovel.setVgaragem(negociacao.getImovel().getVgaragem());
				imovel.setMterreno(negociacao.getImovel().getMterreno());
				imovel.setMimovel(negociacao.getImovel().getMimovel());
				imovel.setCep(negociacao.getImovel().getCep());
				imovelService.save(imovel);
			}

		}
/*
		if (negociacao.getDatafim() != null) {
			negociacao.setStatus(StatusNegociacaoEnum.FINALIZADA);
			negociacao.setDatafim(LocalDate.now());
			negociacao.getImovel().setAtivo(Boolean.FALSE);
			save(negociacao);
			if (negociacao.getTiponegocio()) { // TRUE PARA ALUGUEL
				pagarService.contaaPagar(negociacao);
				receberService.contaaReceberAluguel(negociacao);
			} else { // Caso seja venda
				receberService.contaaReceberVenda(negociacao);

				negociacao.getImovel().setAtivo(Boolean.FALSE);
				imovelService.save(negociacao.getImovel());

				Imovel imovel = new Imovel();
				
				System.out.println(imovel);
				System.out.println("imovel = negociacao.getImovel();");

				imovel.setCliente(negociacao.getCliente());
				System.out.println("imovel.setCliente(negociacao.getCliente());");
				imovel.setAtivo(Boolean.TRUE);
				imovel.setVenda(Boolean.FALSE);
				imovel.setLocacao(Boolean.FALSE);
				System.out.println("imovel.setLocacao(Boolean.FALSE);");

				imovel.setId(null);
				System.out.println(imovel);
				imovel.setVvenda(null);
				imovel.setVlocacao(null);

				imovelService.save(imovel);

			}

		}*/
		
		return negociacao;
	}
}