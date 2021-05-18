
CREATE TABLE public.bank (
    id bigint NOT NULL,
    name character varying(255)
);

ALTER TABLE public.bank OWNER TO postgres;

CREATE SEQUENCE public.banktr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.banktr_seq OWNER TO postgres;

CREATE TABLE public.banktransaction (
    id bigint NOT NULL,
    summ double precision,
    trdate timestamp without time zone,
    bank1_id bigint,
    bank2_id bigint,
    org1_id bigint,
    org2_id bigint,
    user_id bigint
);

ALTER TABLE public.banktransaction OWNER TO postgres;


CREATE TABLE public.organization (
    id bigint NOT NULL,
    name character varying(255),
    bank_id bigint
);

ALTER TABLE public.organization OWNER TO postgres;

CREATE TABLE public.users (
    id bigint NOT NULL,
    login character varying(255),
    name character varying(255),
    password character varying(255),
    bank_id bigint
);

ALTER TABLE public.users OWNER TO postgres;

INSERT INTO public.bank (id, name) VALUES (1, 'Bank1');
INSERT INTO public.bank (id, name) VALUES (2, 'Bank2');

INSERT INTO public.organization (id, name, bank_id) VALUES (1, 'Org 1', 1);
INSERT INTO public.organization (id, name, bank_id) VALUES (2, 'Org 2', 2);

--INSERT INTO public.rs_schema_version (installed_rank, version, description, type, script, checksum, installed_by, installed_on, execution_time, success) VALUES (1, '1', '<< Flyway Baseline >>', 'BASELINE', '<< Flyway Baseline >>', NULL, 'postgres', '2021-05-18 11:26:32.052118', 0, true);

INSERT INTO public.users (id, login, name, password, bank_id) VALUES (1, 'user1', 'user1', 'user1', 1);
INSERT INTO public.users (id, login, name, password, bank_id) VALUES (2, 'user2', 'user2', 'user2', 2);

ALTER TABLE ONLY public.bank
    ADD CONSTRAINT bank_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.banktransaction
    ADD CONSTRAINT banktransaction_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.organization
    ADD CONSTRAINT organization_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fk70ydkxfrm4moluygpc9srcn28 FOREIGN KEY (bank_id) REFERENCES public.bank(id);

ALTER TABLE ONLY public.banktransaction
    ADD CONSTRAINT fk9ehnlb8g5b28gdhcm2emwfcvg FOREIGN KEY (org1_id) REFERENCES public.organization(id);

ALTER TABLE ONLY public.banktransaction
    ADD CONSTRAINT fkhskfiy3r7pnn2h0p1dllwb1cp FOREIGN KEY (user_id) REFERENCES public.users(id);

ALTER TABLE ONLY public.organization
    ADD CONSTRAINT fkka5brb07bsd4252sw1tf4km0s FOREIGN KEY (bank_id) REFERENCES public.bank(id);

ALTER TABLE ONLY public.banktransaction
    ADD CONSTRAINT fkpc6ew1ve6rsc8hd27sdd1bvgm FOREIGN KEY (org2_id) REFERENCES public.organization(id);

ALTER TABLE ONLY public.banktransaction
    ADD CONSTRAINT fkrvfvtj0tk6rwe5wgxok2beytw FOREIGN KEY (bank1_id) REFERENCES public.bank(id);

ALTER TABLE ONLY public.banktransaction
    ADD CONSTRAINT fksx6yonc1nnhmw1hkr0fl6g8b0 FOREIGN KEY (bank2_id) REFERENCES public.bank(id);
