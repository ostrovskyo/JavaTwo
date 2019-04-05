CREATE SCHEMA IF NOT EXISTS shoppinglist DEFAULT CHARACTER SET utf8;
USE shoppinglist;

CREATE TABLE IF NOT EXISTS products
(
  id           BIGINT       NOT NULL AUTO_INCREMENT,
  category     VARCHAR(50),
  name         VARCHAR(50)  NOT NULL,
  price        FLOAT,
  discount     FLOAT,
  description  VARCHAR(100) NULL,
  actual_price FLOAT,
  created      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0;

CREATE TABLE IF NOT EXISTS shopping_carts
(
  id     BIGINT      NOT NULL AUTO_INCREMENT,
  name   VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0;

CREATE TABLE products_shopping_carts
(
  id               bigint(20) NOT NULL AUTO_INCREMENT,
  product_id       bigint(20) NOT NULL,
  shopping_cart_id bigint(20) NOT NULL,
  created          timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  KEY fk_products_shopping_carts_product_id (product_id),
  KEY fk_products_shopping_carts_shopping_cart_id (shopping_cart_id),
  CONSTRAINT fk_products_shopping_carts_product_id FOREIGN KEY (product_id) REFERENCES products (id),
  CONSTRAINT fk_products_shopping_carts_shopping_cart_id FOREIGN KEY (shopping_cart_id) REFERENCES shopping_carts (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0;
