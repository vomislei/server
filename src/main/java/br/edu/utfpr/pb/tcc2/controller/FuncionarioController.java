package br.edu.utfpr.pb.tcc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.pb.tcc2.model.Funcionario;
import br.edu.utfpr.pb.tcc2.service.CrudService;
import br.edu.utfpr.pb.tcc2.service.FuncionarioService;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController extends CrudController<Funcionario, Long> {

    @Autowired private FuncionarioService funcionarioService;

    @Override
    protected CrudService<Funcionario, Long> getService() {
        return funcionarioService;
    }
    

   /* @PostMapping
    public Funcionario save(@RequestBody Funcionario entity) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String currentPrincipalName = authentication.getName();
    	//System.out.println(currentPrincipalName);
    	entity.setUsuario(currentPrincipalName);
        return getService().save(entity);
    }*/
}
