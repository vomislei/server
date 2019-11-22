package br.edu.utfpr.pb.tcc2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Imovel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long quartos;

	private Long vgaragem;

	@Convert(converter = BooleanConverter.class)
	@Column(columnDefinition = "char(1) default '1'")
	private Boolean ativo;

	// @Column(nullable = false)
	private Double latitude;

	// @Column(nullable = false)
	private Double longitude;

	@Convert(converter = BooleanConverter.class)
	@Column(columnDefinition = "char(1) default '1'")
	private Boolean venda;

	@Convert(converter = BooleanConverter.class)
	@Column(columnDefinition = "char(1) default '1'")
	private Boolean locacao;

	@Convert(converter = BooleanConverter.class)
	@Column(columnDefinition = "char(1) default '1'")
	private Boolean troca;

	private Long vvenda;

	private Long vlocacao;

	// status
	//	@Column(nullable = true)
	//	private StatusImovel status;

	private Long mterreno;

	private Long mimovel;

	private String rua;

	private Long cep;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idcliente", referencedColumnName = "id")
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idbairro", referencedColumnName = "id")
	private Bairro bairro;
	
	@Column(name = "imagem", length = 1024, nullable = true)
	private String imagem;
	
	//METHODS GET AND SET 
/*
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuartos() {
		return quartos;
	}

	public void setQuartos(Long quartos) {
		this.quartos = quartos;
	}

	public Long getVgaragem() {
		return vgaragem;
	}

	public void setVgaragem(Long vgaragem) {
		this.vgaragem = vgaragem;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Boolean getVenda() {
		return venda;
	}

	public void setVenda(Boolean venda) {
		this.venda = venda;
	}

	public Boolean getLocacao() {
		return locacao;
	}

	public void setLocacao(Boolean locacao) {
		this.locacao = locacao;
	}

	public Boolean getTroca() {
		return troca;
	}

	public void setTroca(Boolean troca) {
		this.troca = troca;
	}

	public Long getVvenda() {
		return vvenda;
	}

	public void setVvenda(Long vvenda) {
		this.vvenda = vvenda;
	}

	public Long getVlocacao() {
		return vlocacao;
	}

	public void setVlocacao(Long vlocacao) {
		this.vlocacao = vlocacao;
	}

	public Long getMterreno() {
		return mterreno;
	}

	public void setMterreno(Long mterreno) {
		this.mterreno = mterreno;
	}

	public Long getMimovel() {
		return mimovel;
	}

	public void setMimovel(Long mimovel) {
		this.mimovel = mimovel;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
*/	
}
