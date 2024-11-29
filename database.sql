CREATE DATABASE imc_db;

CREATE TABLE public.usuarios
(
    id serial NOT NULL,
    nombre character varying(100),
    clave character varying(100),
    correo character varying(150),
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.usuarios
    OWNER to postgres;

---------------

CREATE TABLE public.resultado_imc
(
    id serial NOT NULL,
    user_id integer NOT NULL,
    peso double precision NOT NULL,
    altura double precision NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.resultado_imc
    OWNER to postgres;

--------------------------
-- Alteracion de unicidad para correo
ALTER TABLE IF EXISTS public.usuarios
    ADD CONSTRAINT correo_unique UNIQUE (correo)
    INCLUDE (correo);

----------------------------
-- Alteracion para crear columnas de timestamp e imc
-- Creacion de la fk para unir usuarios e imc

ALTER TABLE IF EXISTS public.resultado_imc
    ADD COLUMN creado_en timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE IF EXISTS public.resultado_imc
    ADD COLUMN imc double precision NOT NULL;
ALTER TABLE IF EXISTS public.resultado_imc
    ADD CONSTRAINT fk_user_id_imc FOREIGN KEY (user_id)
    REFERENCES public.usuarios (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

-- INSERCIONES

INSERT INTO usuarios (nombre, clave, correo) VALUES ('Erick Rivera', '1234', 'admin@admin.com');