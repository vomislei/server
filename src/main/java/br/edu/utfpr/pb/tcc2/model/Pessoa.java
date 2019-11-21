package br.edu.utfpr.pb.tcc2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.edu.utfpr.pb.tcc2.util.BooleanConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//@Column(length = 100, nullable = false)
	private String nome;

	@Column(length = 50)
	private String apelido;

	//@Column(length = 14, nullable = false)
	private String cpf_cnpj;

	//@Column(length = 20, nullable = false)
	private String telefone;

	//@Column(length = 100, nullable = false)
	private String endereco;

	@Column(length = 50)
	private String email;

	@Convert(converter = BooleanConverter.class)
	@Column(columnDefinition = "char(1) default '1'")
	private Boolean ativo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idbairro", referencedColumnName = "id")
	private Bairro bairro;

}
