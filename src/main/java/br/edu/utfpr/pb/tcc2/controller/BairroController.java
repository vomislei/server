package br.edu.utfpr.pb.tcc2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.pb.tcc2.model.Bairro;
import br.edu.utfpr.pb.tcc2.service.BairroService;
import br.edu.utfpr.pb.tcc2.service.CidadeService;
import br.edu.utfpr.pb.tcc2.service.CrudService;

@RestController
@RequestMapping("bairro")
public class BairroController extends CrudController<Bairro, Long> {

	@Autowired
	private BairroService bairroService;
	@Autowired
	private CidadeService cidadeService;

	@Override
	protected CrudService<Bairro, Long> getService() {
		return bairroService;
	}
	
	@GetMapping	("/findByCidade")
    public List<Bairro> findByCidade(Long id){
    	return bairroService.findByCidade(cidadeService.findOne(id));
    }

}
