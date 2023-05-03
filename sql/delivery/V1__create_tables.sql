CREATE SCHEMA users;
CREATE SCHEMA organization;
CREATE SCHEMA delivery;
CREATE SCHEMA product;
CREATE SCHEMA catalog;


CREATE TABLE catalog.address (
    id               BIGSERIAL PRIMARY KEY,
    city             VARCHAR(255),
    rayon            VARCHAR(255),
    street           VARCHAR(255),
    house_number     VARCHAR(255),
    apartment_number VARCHAR(255),
    area_index       VARCHAR(255),
    full_address     TEXT
);

CREATE TABLE organization.organization (
    id                BIGSERIAL PRIMARY KEY,
    name              VARCHAR(255),
    owner_fio         VARCHAR(255),
    office_address_id BIGINT references catalog.address(id),
    inn               VARCHAR(255),
    ogrn              VARCHAR(255),
    kpp               VARCHAR(255),
    phone_number      VARCHAR(255),
    website           VARCHAR(255)
);

CREATE TABLE users.role (
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE users.usr (
    id              BIGSERIAL PRIMARY KEY,
    fio             VARCHAR(255),
    phone_number    VARCHAR(255),
    email           VARCHAR(255),
    create_date     TIMESTAMPTZ,
    update_date     TIMESTAMPTZ,
    is_deleted      BOOLEAN,
    password        TEXT
);

CREATE TABLE users.user_details (
    id              BIGSERIAL PRIMARY KEY,
    user_id         BIGINT references users.usr(id),
    address_id      BIGINT references catalog.address(id),
    organization_id BIGINT references organization.organization(id),
    rating          DECIMAL
);

CREATE TABLE users.user_roles (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT references users.usr(id),
    role_id BIGINT references users.role
);

CREATE TABLE users.user_session (
    id                    BIGSERIAL PRIMARY KEY,
    user_id               BIGINT references users.usr(id),
    ip_address            VARCHAR(255),
    create_date           TIMESTAMPTZ,
    last_activity         TIMESTAMPTZ,
    is_active             BOOLEAN,
    expiration_term_date  TIMESTAMPTZ
);

CREATE TABLE organization.shop (
    id               BIGSERIAL PRIMARY KEY,
    administrator_id BIGINT references users.usr(id),
    organization_id  BIGINT references organization.organization(id),
    name             VARCHAR(255),
    address_id       BIGINT references catalog.address(id),
    open_time        TIME,
    close_time       TIME
);

CREATE TABLE organization.shop_staff (
    id       BIGSERIAL PRIMARY KEY,
    shop_id  BIGINT references organization.shop(id),
    staff_id BIGINT references users.usr(id)
);

CREATE TABLE product.product (
    id            BIGSERIAL PRIMARY KEY,
    name          VARCHAR(255),
    price         NUMERIC,
    proteins      NUMERIC,
    fats          NUMERIC,
    carbohydrates NUMERIC,
    description   TEXT,
    weight        NUMERIC,
    producer      TEXT
);

CREATE TABLE product.dish (
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(255),
    description TEXT,
    create_date DATE
);

CREATE TABLE product.ingredient (
    id           BIGSERIAL PRIMARY KEY,
    name         VARCHAR(255)
);

CREATE TABLE product.dish_ingredients (
    id            BIGSERIAL PRIMARY KEY,
    ingredient_id BIGINT references product.ingredient(id),
    dish_id       BIGINT references product.dish(id),
    grams_number  NUMERIC
);

CREATE TABLE product.products_ingredient (
    id            BIGSERIAL PRIMARY KEY,
    ingredient_id BIGINT references product.ingredient(id),
    product_id    BIGINT references product.product(id)
);

CREATE TABLE product.shop_products (
    id         BIGSERIAL PRIMARY KEY,
    product_id BIGINT references product.product(id),
    shop_id    BIGINT references organization.shop(id),
    count      BIGINT
);

CREATE TABLE delivery.order (
    id                       BIGSERIAL PRIMARY KEY,
    address_id               BIGINT references catalog.address(id),
    buyer_id                 BIGINT references users.usr(id),
    cost                     NUMERIC,
    order_date_time          TIMESTAMPTZ,
    shop_id                  BIGINT references organization.shop(id),
    order_assembly_date_time TIMESTAMPTZ
);

CREATE TABLE delivery.delivery_status (
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(255)
);

INSERT INTO delivery.delivery_status VALUES (1, 'Заказ принят'),
                                            (2, 'Заказ собран'),
                                            (3, 'Курьер забрал заказ'),
                                            (4, 'Курьер в пути'),
                                            (5, 'Курьер на месте'),
                                            (6, 'Завершено'),
                                            (7, 'Отменено');

CREATE TABLE delivery.delivery (
    id                  BIGSERIAL PRIMARY KEY,
    courier_id          BIGINT references users.usr(id),
    status_id           BIGINT references delivery.delivery_status(id),
    order_id            BIGINT references delivery.order(id),
    picked_up_date_time TIMESTAMPTZ,
    delivery_date_time  TIMESTAMPTZ
);

CREATE TABLE delivery.order_products (
    id               BIGSERIAL PRIMARY KEY,
    order_id         BIGINT references delivery.order(id),
    shop_products_id BIGINT references product.shop_products(id),
    count            INTEGER
);