package br.edu.utfpr.pb.tcc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.pb.tcc2.model.ContaaReceber;
import br.edu.utfpr.pb.tcc2.model.Negociacao;
import br.edu.utfpr.pb.tcc2.service.ContaaReceberService;
import br.edu.utfpr.pb.tcc2.service.CrudService;

@RestController
@RequestMapping("contaareceber")
public class ContaaReceberController extends CrudController<ContaaReceber, Long> {

	@Autowired
	private ContaaReceberService contaaReceberService;

	@Override
	protected CrudService<ContaaReceber, Long> getService() {
		return contaaReceberService;
	}
}
