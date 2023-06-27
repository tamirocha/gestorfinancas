CREATE TABLE conta(
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    saldo DECIMAL(10,2) NOT NULL,
    limite_saque_diario DECIMAL(10,2) NOT NULL,
    flag_ativo BOOLEAN NOT NULL,
    tipo_conta BIT(1) NOT NULL,
    data_criacao DATE,
    codigo_pessoa BIGINT(20) NOT NULL,
    FOREIGN KEY (codigo_pessoa) REFERENCES pessoa(codigo)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;