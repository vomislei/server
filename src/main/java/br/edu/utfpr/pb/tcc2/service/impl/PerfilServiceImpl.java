package br.edu.utfpr.pb.tcc2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.tcc2.data.PerfilData;
import br.edu.utfpr.pb.tcc2.model.Perfil;
import br.edu.utfpr.pb.tcc2.service.PerfilService;

@Service
public class PerfilServiceImpl extends CrudServiceImpl<Perfil, Long> implements PerfilService{

    @Autowired private PerfilData perfilData;

    @Override
    protected JpaRepository<Perfil, Long> getData() {
        return perfilData;
    }
}
