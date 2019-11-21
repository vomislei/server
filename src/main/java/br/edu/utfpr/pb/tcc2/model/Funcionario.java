package br.edu.utfpr.pb.tcc2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Funcionario extends Pessoa implements Serializable{
	
	//@Column(length = 50, nullable = false)
	private String matricula;

    //@Column(nullable=false)
    private String admissao;
    
}
