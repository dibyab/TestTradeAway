-- Table: public."user"

-- DROP TABLE public."user";

CREATE TABLE public."user"
(
    id integer NOT NULL,
    name character varying(100)[] COLLATE pg_catalog."default" NOT NULL,
    email character varying(100)[] COLLATE pg_catalog."default" NOT NULL,
    username character varying(100)[] COLLATE pg_catalog."default" NOT NULL,
    password text COLLATE pg_catalog."default" NOT NULL,
    address text COLLATE pg_catalog."default" NOT NULL,
    mobile integer NOT NULL,
    type character varying(10)[] COLLATE pg_catalog."default" NOT NULL,
    gender character varying(1)[] COLLATE pg_catalog."default",
    "dateOfBirth" date,
    "panNumber" character varying(20)[] COLLATE pg_catalog."default",
    "monthExperience" integer,
    "yearExperience" integer,
    CONSTRAINT user_pkey PRIMARY KEY (id),
    CONSTRAINT email UNIQUE (email, username)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."user"
    OWNER to postgres;