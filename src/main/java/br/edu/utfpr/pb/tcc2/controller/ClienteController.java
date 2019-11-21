package br.edu.utfpr.pb.tcc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.pb.tcc2.model.Cliente;
import br.edu.utfpr.pb.tcc2.service.ClienteService;
import br.edu.utfpr.pb.tcc2.service.CrudService;

@RestController
@RequestMapping("cliente")
public class ClienteController extends CrudController<Cliente, Long> {

    @Autowired private ClienteService clienteService;

    @Override
    protected CrudService<Cliente, Long> getService() {
        return clienteService;
    }
    

   /* @PostMapping
    public Cliente save(@RequestBody Cliente entity) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String currentPrincipalName = authentication.getName();
    	//System.out.println(currentPrincipalName);
    	entity.setUsuario(currentPrincipalName);
        return getService().save(entity);
    }*/
}
