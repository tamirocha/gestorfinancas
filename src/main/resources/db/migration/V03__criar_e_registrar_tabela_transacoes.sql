CREATE TABLE transacao(
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    valor DECIMAL(10,2) NOT NULL,
    data_transacao DATE,
    codigo_conta BIGINT(20) NOT NULL,
    FOREIGN KEY (codigo_conta) REFERENCES conta(codigo)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;