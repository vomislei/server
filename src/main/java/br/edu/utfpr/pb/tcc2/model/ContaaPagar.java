package br.edu.utfpr.pb.tcc2.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.edu.utfpr.pb.tcc2.enumeration.StatusContaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class ContaaPagar implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(nullable=false)
    private LocalDate datavenc;
    
    @Column(nullable=true)
    private LocalDate dataquitacao;
        
	@Column(nullable = true)
	private Long valorpag;
		
	@Column(nullable = true)
	private StatusContaEnum status;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idnegociacao", referencedColumnName = "id")
	private Negociacao negociacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDatavenc() {
		return datavenc;
	}

	public void setDatavenc(LocalDate datavenc) {
		this.datavenc = datavenc;
	}
	
	public LocalDate getDataquitacao() {
		return dataquitacao;
	}

	public void setDataquitacao(LocalDate dataquitacao) {
		this.dataquitacao = dataquitacao;
	}
	
	public Long getValorpag() {
		return valorpag;
	}

	public void setValorpag(Long valorpag) {
		this.valorpag = valorpag;
	}

	public StatusContaEnum getStatus() {
		return status;
	}

	public void setStatus(StatusContaEnum status) {
		this.status = status;
	}

	public Negociacao getNegociacao() {
		return negociacao;
	}

	public void setNegociacao(Negociacao negociacao) {
		this.negociacao = negociacao;
	}
}