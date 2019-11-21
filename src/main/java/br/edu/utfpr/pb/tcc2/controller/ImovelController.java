package br.edu.utfpr.pb.tcc2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.pb.tcc2.model.Imovel;
import br.edu.utfpr.pb.tcc2.service.ClienteService;
import br.edu.utfpr.pb.tcc2.service.CrudService;
import br.edu.utfpr.pb.tcc2.service.ImovelService;

@RestController
@RequestMapping("imovel")
public class ImovelController extends CrudController<Imovel, Long> {

    @Autowired private ImovelService imovelService;

    @Autowired private ClienteService clienteService;
    

    @Override
    protected CrudService<Imovel, Long> getService() {
        return imovelService;
    }
    
    @GetMapping	("/findByCliente")
    public List<Imovel> findByCliente(Long id){
    	return imovelService.findByCliente(clienteService.findOne(id));
    	
    }

    
}
