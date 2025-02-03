CREATE TABLE IF NOT EXISTS PLAYERS (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    codename VARCHAR(255) NOT NULL,
    group_codename VARCHAR(255) NOT NULL,
    CONSTRAINT unique_group_codename UNIQUE (group_codename, codename)
);


