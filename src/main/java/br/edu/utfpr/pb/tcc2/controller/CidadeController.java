package br.edu.utfpr.pb.tcc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.pb.tcc2.model.Cidade;
import br.edu.utfpr.pb.tcc2.service.CidadeService;
import br.edu.utfpr.pb.tcc2.service.CrudService;

@RestController
@RequestMapping("cidade")
public class CidadeController extends CrudController<Cidade, Long> {

	@Autowired
	private CidadeService cidadeService;

	@Override
	protected CrudService<Cidade, Long> getService() {
		return cidadeService;
	}

}
