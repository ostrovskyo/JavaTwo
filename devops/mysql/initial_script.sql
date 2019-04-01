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
  amount FLOAT,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0;

CREATE TABLE IF NOT EXISTS products_shopping_carts
(
  id               BIGINT NOT NULL AUTO_INCREMENT,
  product_id       BIGINT NOT NULL,
  shopping_cart_id BIGINT NOT NULL,
  created          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0;

