package br.edu.utfpr.pb.tcc2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.tcc2.data.UsuarioData;
import br.edu.utfpr.pb.tcc2.model.Usuario;
import br.edu.utfpr.pb.tcc2.service.UsuarioService;

@Service
public class UsuarioServiceImpl extends CrudServiceImpl<Usuario, Long> implements UsuarioService, UserDetailsService, CommandLineRunner {

    @Autowired 
    private UsuarioData usuarioData;

    @Override
    protected JpaRepository<Usuario, Long> getData() {
        return usuarioData;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return usuarioData.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado!"));
    }
    
    @Override
    public Iterable<Usuario> save(Iterable<Usuario> iterable) {
    	return super.save(iterable);
    }

    @Override
    public void run(String... args) throws Exception {    			
//    	Usuario usuario = Usuario.builder()
//                .id(1L)
//                .username("admin")
//                .password(new BCryptPasswordEncoder().encode("admin"))
//                .nome("Administrador")
//                .email("admin@admin.com")
//                .ativo(true)
//                .build();
//
//        usuarioData.save(usuario);
    }
    

}
