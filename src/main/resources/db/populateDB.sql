DELETE FROM votes;
DELETE FROM menu_items;
DELETE FROM restaurants;
DELETE FROM dishes;
DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name) VALUES
  ('admin_1'),
  ('admin_2'),
  ('user_1'),
  ('user_2'),
  ('user_3');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_ADMIN', 100000),
  ('ROLE_ADMIN', 100001),
  ('ROLE_USER', 100002),
  ('ROLE_USER', 100003),
  ('ROLE_USER', 100004);

INSERT INTO dishes (description, price) VALUES
  ('dish_01', 100),
  ('dish_02', 200),
  ('dish_03', 50),
  ('dish_04', 70),
  ('dish_05', 150),
  ('dish_06', 210),
  ('dish_07', 90),
  ('dish_08', 120),
  ('dish_09', 1000),
  ('dish_10', 10);

INSERT INTO restaurants (name) VALUES
  ('restaurant_1'),
  ('restaurant_2'),
  ('restaurant_3'),
  ('restaurant_4'),
  ('restaurant_5');

INSERT INTO menu_items (dish_id, restaurant_id, added) VALUES
  (100005, 100015, '2001-01-01 01:11:11'),
  (100006, 100015, '2001-01-01 01:12:12'),
  (100005, 100017, '2001-01-01 01:13:13'),
  (100008, 100017, '2001-01-01 01:14:14');

INSERT INTO votes (user_id, restaurant_id, taken) VALUES
  (100002, 100017, '2000-01-01 01:01:01');
