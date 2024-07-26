-- Creating the 'customer' table
CREATE TABLE IF NOT EXISTS public.customer
(
    id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    name CHARACTER VARYING(255) COLLATE pg_catalog."default",
    CONSTRAINT customer_pkey PRIMARY KEY (id)
);

-- Creating the 'item' table
CREATE TABLE IF NOT EXISTS public.item
(
    id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    name CHARACTER VARYING(255) COLLATE pg_catalog."default",
    price DOUBLE PRECISION NOT NULL,
    CONSTRAINT item_pkey PRIMARY KEY (id)
);

-- Creating the 'sale' table
CREATE TABLE IF NOT EXISTS public.sale
(
    id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    date TIMESTAMP(6) WITHOUT TIME ZONE,
    quantity INTEGER NOT NULL,
    total_amount DOUBLE PRECISION NOT NULL,
    customer_id BIGINT,
    item_id BIGINT,
    CONSTRAINT sale_pkey PRIMARY KEY (id),
    CONSTRAINT fk_item FOREIGN KEY (item_id)
        REFERENCES public.item (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_customer FOREIGN KEY (customer_id)
        REFERENCES public.customer (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

