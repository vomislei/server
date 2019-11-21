package br.edu.utfpr.pb.tcc2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.tcc2.data.CidadeData;
import br.edu.utfpr.pb.tcc2.model.Cidade;
import br.edu.utfpr.pb.tcc2.service.CidadeService;

@Service
public class CidadeServiceImpl extends CrudServiceImpl<Cidade, Long> implements CidadeService{

    @Autowired private CidadeData cidadeData;

    @Override
    protected JpaRepository<Cidade, Long> getData() {
        return cidadeData;
    }
}
