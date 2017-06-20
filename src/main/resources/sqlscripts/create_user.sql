-- Table: public."app_user"

-- DROP TABLE public."app_user";

CREATE TABLE public."app_user"
(
    id integer NOT NULL,
    name varchar(100) COLLATE pg_catalog."default" NOT NULL,
    email varchar(100) COLLATE pg_catalog."default" NOT NULL,
    username varchar(100) COLLATE pg_catalog."default" NOT NULL,
    password text COLLATE pg_catalog."default" NOT NULL,
    address text COLLATE pg_catalog."default" NOT NULL,
    mobile integer NOT NULL,
    type varchar(10) COLLATE pg_catalog."default" NOT NULL,
    gender varchar(1) COLLATE pg_catalog."default",
    "date_of_birth" date,
    "pan_number" varchar(20) COLLATE pg_catalog."default",
    "month_experience" integer,
    "year_experience" integer,
    CONSTRAINT app_user_pkey PRIMARY KEY (id),
    CONSTRAINT app_email UNIQUE (email, username)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."app_user"
    OWNER to postgres;