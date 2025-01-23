CREATE TABLE IF NOT EXISTS JOGADORES (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(255),
    codinome VARCHAR(255) NOT NULL,
    grupo VARCHAR(255) NOT NULL,
    CONSTRAINT unique_grupo_codinome UNIQUE(grupo, codinome)
);


