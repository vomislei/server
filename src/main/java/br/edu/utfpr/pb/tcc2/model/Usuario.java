package br.edu.utfpr.pb.tcc2.model;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.edu.utfpr.pb.tcc2.util.BooleanConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
//import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	private static final BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50, nullable = false)
	private String username;

	@Column(length = 300, nullable = false)
	private String password;

	@Column(length = 50, nullable = false)
	private String nome;

	@Convert(converter = BooleanConverter.class)
	@Column(columnDefinition = "char(1) default '1'", nullable = false)
	private Boolean ativo;

	@ManyToOne(optional = false)
	private Perfil perfil;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idfuncionario", referencedColumnName = "id")
	private Funcionario funcionario;

	public String getEncodedPassword(String pass) {
		if (!pass.isEmpty()) {
			return bCrypt.encode(pass);
		}
		return pass;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (perfil != null) {
			return perfil.getPermissoes().stream().map(e -> new SimpleGrantedAuthority("ROLE_" + e.name()))
					.collect(Collectors.toList());
		}

		return AuthorityUtils.NO_AUTHORITIES;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return ativo;
	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
//	public Boolean getAtivo() {
//		return ativo;
//	}
//
//	public void setAtivo(Boolean ativo) {
//		this.ativo = ativo;
//	}
//
//	public Perfil getPerfil() {
//		return perfil;
//	}
//
//	public void setPerfil(Perfil perfil) {
//		this.perfil = perfil;
//	}
//
//	public Funcionario getFuncionario() {
//		return funcionario;
//	}
//
//	public void setFuncionario(Funcionario funcionario) {
//		this.funcionario = funcionario;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return getUsername();
//	}
	
	
}
