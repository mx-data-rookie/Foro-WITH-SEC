-- Crear tabla usuarios
CREATE TABLE usuarios (
    id_usuario SERIAL PRIMARY KEY,
    alias VARCHAR(50) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Crear tabla temas
CREATE TABLE temas (
    id_tema SERIAL PRIMARY KEY,
    id_usuario BIGINT NOT NULL,
    asunto VARCHAR(255),
    asunto_activo BOOLEAN NOT NULL,
    asignatura_enum VARCHAR(50),
    mensaje TEXT,
    fecha_creacion TIMESTAMP NOT NULL,
    CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) ON DELETE CASCADE
);