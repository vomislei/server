package br.edu.utfpr.pb.tcc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.pb.tcc2.model.Cliente;
import br.edu.utfpr.pb.tcc2.model.Negociacao;
import br.edu.utfpr.pb.tcc2.service.CrudService;
import br.edu.utfpr.pb.tcc2.service.NegociacaoService;

@RestController
@RequestMapping("negociacao")
public class NegociacaoController extends CrudController<Negociacao, Long> {

    @Autowired 
    private NegociacaoService negociacaoService;
    
   
    @PostMapping
    public Negociacao save(@RequestBody Negociacao entity) {
//    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//    	String currentPrincipalName = authentication.getName();
//    	System.out.println(currentPrincipalName);
    	negociacaoService.saveNegociacao(entity);
    	return entity;
    }
    /*
    @GetMapping	("/findByNegociacao")
    public List<ContaaReceber> findByNegociacao(Long id){
    	return null; // ContaaReceberService.findByNegociacao(NegociacaoService.findOne(id));
    }
    */
    
	@Override
	protected CrudService<Negociacao, Long> getService() {
		return  negociacaoService;
	}
 }