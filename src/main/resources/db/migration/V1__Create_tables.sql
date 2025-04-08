CREATE TABLE IF NOT EXISTS caes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    raca VARCHAR(255) NOT NULL,
    idade INTEGER NOT NULL,
    porte VARCHAR(50) NOT NULL,
    temperamento VARCHAR(255) NOT NULL,
    disponivel_para_adocao BOOLEAN NOT NULL DEFAULT TRUE,
    descricao VARCHAR(1000)
);

CREATE TABLE IF NOT EXISTS adocoes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cao_id BIGINT NOT NULL,
    nome_adotante VARCHAR(255) NOT NULL,
    cpf_adotante VARCHAR(14) NOT NULL,
    telefone_adotante VARCHAR(20) NOT NULL,
    email_adotante VARCHAR(255) NOT NULL,
    data_agendamento TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL,
    FOREIGN KEY (cao_id) REFERENCES caes(id)
); 