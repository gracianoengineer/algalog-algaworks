CREATE TABLE public.cliente
(
    nome character varying(60) COLLATE pg_catalog."default" NOT NULL,
    id bigint NOT NULL,
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    telefone character varying(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT cliente_pkey PRIMARY KEY (id)
)