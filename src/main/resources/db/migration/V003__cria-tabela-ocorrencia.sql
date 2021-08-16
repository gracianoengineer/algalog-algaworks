create table ocorrencia (
	id bigserial not null,
	entrega_id int8 not null,
	descricao varchar(255) not null,
	data_registro timestamp not null,
	CONSTRAINT ocorrencia_pkey PRIMARY KEY (id),
	CONSTRAINT ocorrencia_fk FOREIGN KEY (entrega_id) REFERENCES entrega(id)
);