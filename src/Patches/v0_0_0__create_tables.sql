CREATE SEQUENCE users_sequence START 1;

CREATE TABLE users (
    id              integer PRIMARY KEY DEFAULT nextval('users_sequence'),
    username        varchar(40) NOT NULL,
    password        varchar(20) NOT NULL,
    email           varchar(40) NOT NULL,
    zip             integer,
    town            varchar(40),
    address         varchar(40),
    phone           integer,
    deleted boolean NOT NULL DEFAULT false
);

CREATE SEQUENCE workers_sequence START 1;

CREATE TABLE workers (
    id              integer PRIMARY KEY DEFAULT nextval('workers_sequence'),
    name            varchar(40) NOT NULL,
    email           varchar(40),
    salary          integer,
    zip             integer,
    town            varchar(40),
    address         varchar(40),
    phone           integer,
    deleted boolean NOT NULL DEFAULT false
);

CREATE SEQUENCE authentication_sequence START 1;

CREATE TABLE authentication (
    id              integer PRIMARY KEY DEFAULT nextval('authentication_sequence'),
    userd_id        integer references users (id),
    storeage        boolean,
    products        boolean,
    allergen        boolean,
    machines        boolean,
    orders          boolean,
    workers         boolean,
    admin           boolean,
    deleted boolean NOT NULL DEFAULT false
);

CREATE SEQUENCE allergens_sequence START 1;

CREATE TABLE allergens (
    id              integer PRIMARY KEY DEFAULT nextval('allergens_sequence'),
    name            varchar(40) NOT NULL,
    deleted boolean NOT NULL DEFAULT false
);

CREATE SEQUENCE ingredient_type_sequence START 1;

CREATE TABLE ingredient_type (
    id              integer PRIMARY KEY DEFAULT nextval('ingredient_type_sequence'),
    name            varchar(40) NOT NULL,
    allergens_id   integer references allergens (id),
    deleted boolean NOT NULL DEFAULT false
);

CREATE SEQUENCE machine_sequence START 1;

CREATE TABLE machine (
    id              integer PRIMARY KEY DEFAULT nextval('machine_sequence'),
    name            varchar(40) NOT NULL,
    deleted boolean NOT NULL DEFAULT false
);

CREATE SEQUENCE product_type_sequence START 1;

CREATE TABLE product_type (
    id              integer PRIMARY KEY DEFAULT nextval('product_type_sequence'),
    name            varchar(40) NOT NULL,
    allergens_id   integer references allergens (id),
    weight          integer,
    time            integer,
    value           integer,
    cost            integer,
    deleted boolean NOT NULL DEFAULT false
);

CREATE SEQUENCE machine_product_sequence START 1;

CREATE TABLE machine_product (
    id              integer PRIMARY KEY DEFAULT nextval('machine_product_sequence'),
    machine_id   integer references machine (id),
    product_type_id   integer references product_type (id),
    time            integer,
    deleted boolean NOT NULL DEFAULT false
);

CREATE SEQUENCE ingredient_sequence START 1;

CREATE TABLE ingredient (
    id              integer PRIMARY KEY DEFAULT nextval('ingredient_sequence'),
    name            varchar(40) NOT NULL,
    ingredient_type_id   integer references ingredient_type (id),
    arrived   DATE DEFAULT now(),
    expire            DATE DEFAULT now() ,
    weight            integer,
    source            varchar(40),
    value            integer,
    deleted boolean NOT NULL DEFAULT false
);

CREATE SEQUENCE receipt_sequence START 1;

CREATE TABLE receipt (
    id              integer PRIMARY KEY DEFAULT nextval('receipt_sequence'),
    product_type_id   integer references product_type (id),
    ingredient_type_id   integer references ingredient_type (id),
    wieght            integer,
    deleted boolean NOT NULL DEFAULT false
);

CREATE SEQUENCE product_sequence START 1;

CREATE TABLE product (
    id              integer PRIMARY KEY DEFAULT nextval('product_sequence'),
    product_type_id   integer references product_type (id),
    production_date   DATE DEFAULT now(),
    wieght        integer,
    instorage     boolean default false,
    deleted boolean NOT NULL DEFAULT false
);

CREATE SEQUENCE product_ingredient_sequence START 1;

CREATE TABLE product_ingredient (
    id              integer PRIMARY KEY DEFAULT nextval('product_ingredient_sequence'),
    product_id   integer references product (id),
    ingredient_id   integer references ingredient (id),
    deleted boolean NOT NULL DEFAULT false
);

CREATE SEQUENCE orders_sequence START 1;

CREATE TABLE orders (
    id              integer PRIMARY KEY DEFAULT nextval('orders_sequence'),
    name            varchar(40) NOT NULL,
    costumer        varchar(40),
    price           integer,
    done            boolean,
    order_time      DATE DEFAULT now(),
    end_time        DATE DEFAULT now(),
    deleted boolean NOT NULL DEFAULT false
);

CREATE SEQUENCE order_product_sequence START 1;

CREATE TABLE order_product (
    id              integer PRIMARY KEY DEFAULT nextval('order_product_sequence'),
    oder_id   integer references orders (id),
    product_type_id    integer references product_type (id),
    weight            integer,
    price            integer,
    done           boolean,
    production_time   DATE,
    deleted boolean NOT NULL DEFAULT false
);

CREATE SEQUENCE supplier_sequence START 1;

CREATE TABLE supplier (
    id              integer PRIMARY KEY DEFAULT nextval('supplier_sequence'),
    name            varchar(40) NOT NULL,
    phone            varchar(40),
    zip            integer,
    town            varchar(40),
    address            varchar(40),
    deleted boolean NOT NULL DEFAULT false
);

CREATE SEQUENCE supplier_order_sequence START 1;

CREATE TABLE supplier_order (
    id              integer PRIMARY KEY DEFAULT nextval('supplier_order_sequence'),
    supplier_id   integer references supplier (id),
    order_id   integer references orders (id),
    date            Date default now(),
    transfer_price           integer,
    order_price            integer,
    deleted boolean NOT NULL DEFAULT false
);

CREATE SEQUENCE worklog_sequence START 1;

CREATE TABLE worklog (
    id              integer PRIMARY KEY DEFAULT nextval('worklog_sequence'),
    worker_id   integer references workers (id),
    date            Date default now(),
    hour           integer,
    deleted boolean NOT NULL DEFAULT false
);

INSERT INTO users(username, password, email, zip, town, address, phone) VALUES ('Admin', 'Admin', 'e.dominik1995@gmail.com', 6000, 'Kecskemét', 'Kullai köz 12', 305640832)
