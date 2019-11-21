package br.edu.utfpr.pb.tcc2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/usuario/**").hasAnyRole("ADMIN,USUARIO_CRIAR,USUARIO_EDITAR,USUARIO_REMOVER")
                .antMatchers("/perfil/**").hasAnyRole("ADMIN,PERFIL_CRIAR,PERFIL_EDITAR,PERFIL_REMOVER")
                .antMatchers("/funcionario/**").hasAnyRole("ADMIN,FUNCIONARIO_CRIAR,FUNCIONARIO_EDITAR,FUNCIONARIO_REMOVER")
                .antMatchers("/bairro/**").hasAnyRole("ADMIN,BAIRRO_CRIAR,BAIRRO_EDITAR,BAIRRO_REMOVER")
                .antMatchers("/cidade/**").hasAnyRole("ADMIN,CIDADE_CRIAR,CIDADE_EDITAR,CIDADE_REMOVER")
                .antMatchers("/cliente/**").hasAnyRole("ADMIN,CLIENTE_CRIAR,CLIENTE_EDITAR,CLIENTE_REMOVER")
                .antMatchers("/contasapagar/**").hasAnyRole("ADMIN,CONTASAPAGAR_EDITAR,CONTASAPAGAR_REMOVER")
                .antMatchers("/contasareceber/**").hasAnyRole("ADMIN,CONTASARECEBER_EDITAR,CONTASARECEBER_REMOVER")
                .antMatchers("/imovel/**").hasAnyRole("ADMIN,IMOVEL_CRIAR,IMOVEL_EDITAR,IMOVEL_REMOVER")
                .antMatchers("/negociacao/**").hasAnyRole("ADMIN,NEGOCIACAO_CRIAR,NEGOCIACAO_EDITAR,NEGOCIACAO_REMOVER")
                .anyRequest().authenticated();
    }
}
