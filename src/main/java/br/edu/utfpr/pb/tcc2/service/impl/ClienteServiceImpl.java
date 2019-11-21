package br.edu.utfpr.pb.tcc2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.tcc2.data.ClienteData;
import br.edu.utfpr.pb.tcc2.model.Cliente;
import br.edu.utfpr.pb.tcc2.service.ClienteService;

@Service
public class ClienteServiceImpl extends CrudServiceImpl<Cliente, Long> implements ClienteService {

    @Autowired private ClienteData clienteData;

    @Override
    protected JpaRepository<Cliente, Long> getData() {
        return clienteData;
    }
    
    
}
