package br.edu.utfpr.pb.tcc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.pb.tcc2.enumeration.StatusContaEnum;
import br.edu.utfpr.pb.tcc2.model.ContaaPagar;
import br.edu.utfpr.pb.tcc2.service.ContaaPagarService;
import br.edu.utfpr.pb.tcc2.service.CrudService;

@RestController
@RequestMapping("contaapagar")
public class ContaaPagarController extends CrudController<ContaaPagar, Long> {

	@Autowired
	private ContaaPagarService contaaPagarService;

	@Override
	protected CrudService<ContaaPagar, Long> getService() {
		return contaaPagarService;
	}
}
