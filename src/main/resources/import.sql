INSERT INTO perfil (nome) values('Administrador');

INSERT INTO perfil_permissoes (perfil_id, permissoes) values(1, 'ADMIN');

INSERT INTO usuario (username, password, nome, ativo, perfil_id) values('admin', '$2a$10$MUxruSV6fspjMTv.axUKPuss2raoer5K9vN2Eue80NxTkB6nnVoPG', 'Administrador',  1, 1);

INSERT INTO cidade(nome, estado) values('Pato Branco','PR');
INSERT INTO cidade(nome, estado) values('São Lourenço do Oeste','SC');
INSERT INTO cidade(nome, estado) values('Guaporé','RS');

INSERT INTO bairro(nome, idcidade) values('Centro', 1);
INSERT INTO bairro(nome, idcidade) values('Sudoeste', 1);
INSERT INTO bairro(nome, idcidade) values('Centro', 2);
INSERT INTO bairro(nome, idcidade) values('Cruzeiro', 2);
INSERT INTO bairro(nome, idcidade) values('Centro', 3);
INSERT INTO bairro(nome, idcidade) values('Sul', 3);

INSERT INTO pessoa(apelido, ativo, cpf_cnpj, email, endereco, nome, telefone, idbairro) 
VALUES ('Vomislei','1', '09814650994', 'vomislei@hotmail.com', 'Rui barbosa 76', 'Vomislei Comprador', '49999303658', 1);
INSERT INTO pessoa(id, apelido, ativo, cpf_cnpj, email, endereco, nome, telefone, idbairro) 
VALUES ('João','1', '38493845960', 'joao@hotmail.com', 'Av Brasil 176', 'João Vendedor', '49999554481', 4);

INSERT INTO cliente(interesses, id)	VALUES ('Comprar casas');
INSERT INTO cliente(interesses, id)	VALUES ('Vender casa');

INSERT INTO pessoa(id, apelido, ativo, cpf_cnpj, email, endereco, nome, telefone, idbairro) 
VALUES ('Chico','1', '27348596078', 'chico@imob.com', 'Av alameda 17', 'Chico Funcionario', '49999556070', 3);

INSERT INTO funcionario(admissao, matricula, id) VALUES ('2019-10-01', '123645');


INSERT INTO imovel(ativo, rua, idbairro, idcliente) VALUES('1','imovel do capeta', 3, 2);


