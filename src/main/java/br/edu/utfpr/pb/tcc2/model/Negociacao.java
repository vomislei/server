package br.edu.utfpr.pb.tcc2.model;

import java.io.Serializable;
import java.time.LocalDate;

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
import javax.persistence.OneToOne;

import br.edu.utfpr.pb.tcc2.enumeration.StatusContaEnum;
import br.edu.utfpr.pb.tcc2.enumeration.StatusNegociacaoEnum;
import br.edu.utfpr.pb.tcc2.util.BooleanConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Negociacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate data;

	private LocalDate datainicio;

	private LocalDate datafim;

	@Column(nullable = true)
	private Long vreceber;

	private Long vpagar;
	
	@Column(nullable = true)
	private StatusNegociacaoEnum status;

	@Convert(converter = BooleanConverter.class)
	@Column(columnDefinition = "char(1) default '1'")
	private Boolean tiponegocio;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idcliente", referencedColumnName = "id")
	private Cliente cliente;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idimovel", referencedColumnName = "id")
	private Imovel imovel;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idfuncionario", referencedColumnName = "id")
	private Funcionario funcionario;

	//METHOD GET AND SET
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalDate getDatainicio() {
		return datainicio;
	}

	public void setDatainicio(LocalDate datainicio) {
		this.datainicio = datainicio;
	}

	public LocalDate getDatafim() {
		return datafim;
	}

	public void setDatafim(LocalDate datafim) {
		this.datafim = datafim;
	}

	public Long getVreceber() {
		return vreceber;
	}

	public void setVreceber(Long vreceber) {
		this.vreceber = vreceber;
	}

	public Long getVpagar() {
		return vpagar;
	}

	public void setVpagar(Long vpagar) {
		this.vpagar = vpagar;
	}
	
	public StatusNegociacaoEnum getStatus() {
		return status;
	}

	public void setStatus(StatusNegociacaoEnum status) {
		this.status = status;
	}

	public Boolean getTiponegocio() {
		return tiponegocio;
	}

	public void setTiponegocio(Boolean tiponegocio) {
		this.tiponegocio = tiponegocio;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
