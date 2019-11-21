package br.edu.utfpr.pb.tcc2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.tcc2.data.ImovelData;
import br.edu.utfpr.pb.tcc2.model.Cliente;
import br.edu.utfpr.pb.tcc2.model.Imovel;
import br.edu.utfpr.pb.tcc2.service.ImovelService;

@Service
public class ImovelServiceImpl extends CrudServiceImpl<Imovel, Long> implements ImovelService {

    @Autowired private ImovelData imovelData;
    
    @Override
    protected JpaRepository<Imovel, Long> getData() {
        return imovelData;
    }
    
    @Override
	public List<Imovel> findByCliente(Cliente cliente) {
    	return imovelData.findByCliente(cliente);
	}
    
   
}
	