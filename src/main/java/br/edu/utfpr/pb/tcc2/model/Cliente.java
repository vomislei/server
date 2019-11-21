package br.edu.utfpr.pb.tcc2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Cliente extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idcliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@Column(length = 100, nullable = false)
	private String interesses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInteresses() {
		return interesses;
	}

	public void setInteresses(String interesses) {
		this.interesses = interesses;
	}

}
