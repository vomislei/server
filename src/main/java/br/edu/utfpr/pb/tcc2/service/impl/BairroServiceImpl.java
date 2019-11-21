package br.edu.utfpr.pb.tcc2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.tcc2.data.BairroData;
import br.edu.utfpr.pb.tcc2.model.Bairro;
import br.edu.utfpr.pb.tcc2.model.Cidade;
import br.edu.utfpr.pb.tcc2.service.BairroService;

@Service
public class BairroServiceImpl extends CrudServiceImpl<Bairro, Long> implements BairroService{

    @Autowired private BairroData bairroData;

    @Override
    protected JpaRepository<Bairro, Long> getData() {
        return bairroData;
    }
    
    @Override
	public List<Bairro> findByCidade(Cidade cidade) {
		return bairroData.findByCidade(cidade);
	}
}
