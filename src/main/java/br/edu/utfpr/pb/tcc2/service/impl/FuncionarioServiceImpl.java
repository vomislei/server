package br.edu.utfpr.pb.tcc2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.tcc2.data.FuncionarioData;
import br.edu.utfpr.pb.tcc2.model.Funcionario;
import br.edu.utfpr.pb.tcc2.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl extends CrudServiceImpl<Funcionario, Long> implements FuncionarioService {

	@Autowired private FuncionarioData funcionarioData;
	
    @Override
    protected JpaRepository<Funcionario, Long> getData() {
        return funcionarioData;
	}
}
