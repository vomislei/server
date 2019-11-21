package br.edu.utfpr.pb.tcc2.data;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.tcc2.model.Usuario;

import java.util.Optional;

public interface UsuarioData extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByUsername(String username);
}
