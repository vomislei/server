package br.edu.utfpr.pb.tcc2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.pb.tcc2.model.Usuario;
import br.edu.utfpr.pb.tcc2.service.CrudService;
import br.edu.utfpr.pb.tcc2.service.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController extends CrudController<Usuario, Long> {

    @Autowired private UsuarioService usuarioService;

    @Override
    protected CrudService<Usuario, Long> getService() {
        return usuarioService;
    }
    
    @PostMapping
    public Usuario save(@RequestBody Usuario entity) {
    	//System.out.println("Chegou no save->" + entity);
    	List<Usuario> usuarios = usuarioService.findAll();

    	for (Usuario usuario : usuarios) {
			if ((entity.getUsername().equals(usuario.getUsername()) && entity.getId() == null)  ||
					(entity.getUsername().equals(usuario.getUsername()) && entity.getId() != usuario.getId())){
				throw new RuntimeException("Erro. Esse login ja existe!");
			}
		}
		
    	entity.setPassword(entity.getEncodedPassword(entity.getPassword()));
    	return getService().save(entity);
    }
}
