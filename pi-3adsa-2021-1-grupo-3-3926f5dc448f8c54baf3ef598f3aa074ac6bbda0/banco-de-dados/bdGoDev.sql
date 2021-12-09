CREATE TABLE usuario(
	idUsuario INT PRIMARY KEY IDENTITY(1,1),
	nomeUsuario VARCHAR(45) NOT NULL,
	dataNasc DATETIME NOT NULL, 
	email VARCHAR(45) NOT NULL,
	senha VARCHAR(45) NOT NULL,
	tipoUser BIT NOT NULL, 
	situacaoJuridica BIT NOT NULL,
	dataCriacaoConta DATETIME NOT NULL
)

CREATE TABLE usuario_pessoa_fisica(
	idUsuarioPessoaFisica INT PRIMARY KEY IDENTITY(1,1),
	cpf VARCHAR(45) NOT NULL,
	fkUsuario INT FOREIGN KEY REFERENCES usuario(idUsuario)
)

CREATE TABLE usuario_pessoa_juridica(
	idUsuarioPessoaFisica INT PRIMARY KEY IDENTITY(1,1),
	cnpj VARCHAR(45) NOT NULL
	fkUsuario INT FOREIGN KEY REFERENCES usuario(idUsuario)
)

CREATE TABLE perfil(
	idPerfil INT PRIMARY KEY IDENTITY(1,1),
	nomePerfil VARCHAR(45) NOT NULL,
	redesSociais VARCHAR(100) NOT NULL,
	sobre VARCHAR(200) NOT NULL
)

CREATE TABLE perfil_cliente(
	idPerfilCliente INT PRIMARY KEY IDENTITY(1,1),
	contextoNecessidade VARCHAR(200) NOT NULL
	fkPerfil INT FOREIGN KEY REFERENCES perfil(idPerfil)
)

CREATE TABLE perfil_profissional(
	idPerfilProfissional INT PRIMARY KEY IDENTITY(1,1),
	biografia VARCHAR(200) NOT NULL,
	companhia VARCHAR(45) NOT NULL,
	loginNomeGit VARCHAR(45) NOT NULL,
	disponibilidade BIT NOT NULL,
	fkPerfil INT FOREIGN KEY REFERENCES perfil(idPerfil)
)

CREATE TABLE servico (
	idServico INT PRIMARY KEY IDENTITY(1,1),
	nomeServico VARCHAR(45) NOT NULL,
	dataInicio DATETIME NOT NULL, 
	dataFim DATETIME NOT NULL, 
	descServico VARCHAR(45) NOT NULL,
	senha VARCHAR(45) NOT NULL,
	statusServico BIT NOT NULL,
	fkPerfilProfissional INT FOREIGN KEY REFERENCES perfil_profissional(idPerfilProfissional),
	fkPerfilCliente INT FOREIGN KEY REFERENCES perfil_cliente(idPerfilCliente)
)





