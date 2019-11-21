package br.edu.utfpr.pb.tcc2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.tcc2.data.PessoaData;
import br.edu.utfpr.pb.tcc2.model.Pessoa;
import br.edu.utfpr.pb.tcc2.service.PessoaService;

@Service
public class PessoaServiceImpl extends CrudServiceImpl<Pessoa, Long> implements PessoaService {

    @Autowired private PessoaData pessoaData;

    @Override
    protected JpaRepository<Pessoa, Long> getData() {
        return pessoaData;
    }
}
