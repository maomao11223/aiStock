-- product
INSERT INTO product (product_name, category, image_url, price, stock, description, created_date, last_modified_date) VALUES ('蘋果（澳洲）', 'FOOD', 'https://cdn.pixabay.com/photo/2014/02/01/17/28/apple-256261__480.jpg', 20, 10, '這是來自澳洲的蘋果！', '2020-03-01 02:41:28', '2022-03-01 02:41:32');
INSERT INTO product (product_name, category, image_url, price, stock, description, created_date, last_modified_date) VALUES ('蘋果（日本）', 'FOOD', 'https://cdn.pixabay.com/photo/2014/02/01/17/28/apple-256261__480.jpg', 70, 109, '這是來自日本的蘋果！', '2021-03-02 02:41:28', '2022-03-01 02:41:32');
INSERT INTO product (product_name, category, image_url, price, stock, description, created_date, last_modified_date) VALUES ('這是蘋果喔', 'FOOD', 'https://cdn.pixabay.com/photo/2014/02/01/17/28/apple-256261__480.jpg', 25, 100, '這是蘋果！', '2025-03-01 01:41:28', '2022-03-01 02:41:32');
INSERT INTO product (product_name, category, image_url, price, stock, description, created_date, last_modified_date) VALUES ('TOYOTA', 'CAR', 'https://cdn.pixabay.com/photo/2014/02/01/17/28/apple-256261__480.jpg', 20900, 1, '這是TOYOTA', '2024-03-11 02:41:28', '2022-03-01 02:41:32');
INSERT INTO product (product_name, category, image_url, price, stock, description, created_date, last_modified_date) VALUES ('BMW', 'CAR', 'https://cdn.pixabay.com/photo/2014/02/01/17/28/apple-256261__480.jpg', 20000, 102, 'BMW', '2026-03-01 12:41:28', '2022-03-01 02:41:32');
INSERT INTO product (product_name, category, image_url, price, stock, description, created_date, last_modified_date) VALUES ('mini', 'CAR', 'https://cdn.pixabay.com/photo/2014/02/01/17/28/apple-256261__480.jpg', 199990, 90, 'MINI COPPER', '2028-03-01 02:41:18', '2022-03-01 02:41:32');
-- order
INSERT INTO orders (user_id, total_amount, created_date, last_modified_date) VALUES (6,100110,'2024-03-11 02:41:28', '2022-03-01 02:41:32');
INSERT INTO order_item (order_id, product_id, quantity, amount) VALUES(1,4,2,60);
INSERT INTO order_item (order_id, product_id, quantity, amount) VALUES(1,6,5,50);
INSERT INTO order_item (order_id, product_id, quantity, amount) VALUES(1,7,1,1000);

