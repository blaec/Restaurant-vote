DROP TABLE votes IF EXISTS;
DROP TABLE menu_items IF EXISTS;
DROP TABLE dishes IF EXISTS;
DROP TABLE restaurants IF EXISTS;
DROP TABLE users IF EXISTS;
DROP SEQUENCE global_seq IF EXISTS;

CREATE SEQUENCE global_seq AS INTEGER START WITH 100000;

CREATE TABLE users
(
  id               INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
  name             VARCHAR(255)            NOT NULL,
  role             VARCHAR(255)            NOT NULL
);

CREATE TABLE dishes
(
  id               INTEGER GENERATED BY DEFAULT AS SEQUENCE global_seq PRIMARY KEY,
  description      VARCHAR(255)            NOT NULL,
  price            INTEGER                 NOT NULL
);

CREATE TABLE restaurants
(
  id               INTEGER GENERATED BY DEFAULT AS SEQUENCE global_seq PRIMARY KEY,
  name             VARCHAR(255)            NOT NULL
);

CREATE TABLE menu_items
(
  id               INTEGER GENERATED BY DEFAULT AS SEQUENCE global_seq PRIMARY KEY,
  dish_id          INTEGER                 NOT NULL,
  restaurant_id    INTEGER                 NOT NULL,
  added            TIMESTAMP               NOT NULL,
  FOREIGN KEY (dish_id) REFERENCES dishes (id) ON DELETE CASCADE,
  FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX meal_item_unique_dish_and_restaurant_idx ON menu_items (dish_id, restaurant_id);

CREATE TABLE votes
(
  id               INTEGER GENERATED BY DEFAULT AS SEQUENCE global_seq PRIMARY KEY,
  user_id          INTEGER                 NOT NULL,
  restaurant_id    INTEGER                 NOT NULL,
  taken            TIMESTAMP               NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
  FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX votes_unique_user_id_idx ON votes (user_id);