CREATE TABLE public.entrega (
	id bigserial NOT NULL,
	cliente_id int8 NOT NULL,
	taxa int8 NOT NULL,
	status varchar(20) NOT NULL,
	data_pedido timestamp NOT NULL,
	data_finalizacao timestamp NULL,
	destinatario_nome varchar(60) NOT NULL,
	destinatario_logradouro varchar(255) NOT NULL,
	destinatario_numero varchar(30) NOT NULL,
	destinatario_complemento varchar(60) NOT NULL,
	destinatario_bairro varchar(30) NOT NULL,
	CONSTRAINT entrega_pkey PRIMARY KEY (id),
	CONSTRAINT entrega_fk FOREIGN KEY (cliente_id) REFERENCES public.cliente(id)
);