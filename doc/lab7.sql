--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.1
-- Dumped by pg_dump version 12.0

-- Started on 2020-02-13 10:23:06 MSK

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

--
-- TOC entry 185 (class 1259 OID 2805174)
-- Name: bank; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bank (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.bank OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 2805187)
-- Name: bankaccount; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bankaccount (
    id bigint NOT NULL,
    bank_id bigint,
    accountnumber bigint,
    balance double precision
);


ALTER TABLE public.bankaccount OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 2805179)
-- Name: client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.client (
    id bigint NOT NULL,
    bank_id bigint,
    firstname character varying(255),
    lastname character varying(255),
    phonenumber character varying(255),
    email character varying(255)
);


ALTER TABLE public.client OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 2805192)
-- Name: client_bankaccount; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.client_bankaccount (
    client_id bigint NOT NULL,
    bankaccounts_id bigint NOT NULL
);


ALTER TABLE public.client_bankaccount OWNER TO postgres;

--
-- TOC entry 2279 (class 2606 OID 2805178)
-- Name: bank bank_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bank
    ADD CONSTRAINT bank_pkey PRIMARY KEY (id);


--
-- TOC entry 2283 (class 2606 OID 2805191)
-- Name: bankaccount bankaccount_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bankaccount
    ADD CONSTRAINT bankaccount_pkey PRIMARY KEY (id);


--
-- TOC entry 2281 (class 2606 OID 2805186)
-- Name: client client_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id);


-- Completed on 2020-02-13 10:23:06 MSK

--
-- PostgreSQL database dump complete
--

