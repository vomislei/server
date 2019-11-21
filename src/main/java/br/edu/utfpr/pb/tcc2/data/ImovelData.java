package br.edu.utfpr.pb.tcc2.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.tcc2.model.Cliente;
import br.edu.utfpr.pb.tcc2.model.Imovel;

public interface ImovelData extends JpaRepository<Imovel, Long> {
	
	List<Imovel> findByCliente(Cliente cliente);
}
