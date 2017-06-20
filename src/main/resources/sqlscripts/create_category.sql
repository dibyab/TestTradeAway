CREATE TABLE public."category"
(
    id INTEGER NOT NULL,
    categoryName CHARACTER (100) NOT NULL

)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."app_user"
    OWNER to postgres;

INSERT INTO category VALUES  ( '1' , 'Electronics') ;
INSERT INTO category VALUES  ( '2' , 'Fashion') ;