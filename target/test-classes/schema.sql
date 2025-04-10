CREATE TABLE IF NOT EXISTS product
(
        product_id         INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
        product_name       VARCHAR(128) NOT NULL,
        category           VARCHAR(32)  NOT NULL,
        image_url          VARCHAR(256) NOT NULL,
        price              INT          NOT NULL,
        stock              INT          NOT NULL,
        description        VARCHAR(1024),
        created_date       TIMESTAMP    NOT NULL,
        last_modified_date TIMESTAMP    NOT NULL
);

CREATE TABLE IF NOT EXISTS users
(
        user_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
        email VARCHAR(256) NOT NULL UNIQUE,
        password VARCHAR(256) NOT NULL,
        created_date TIMESTAMP NOT NULL,
        last_modified_date TIMESTAMP NOT NULL
);

-- Orders
CREATE TABLE orders
(
    order_id            INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id             INT NOT NULL unique,
    total_amount INT NOT NULL, -- 訂單總費用
    created_date       TIMESTAMP    NOT NULL,
    last_modified_date TIMESTAMP    NOT NULL
);

CREATE TABLE order_item
(
	order_item_id INT NOT NULL primary KEY AUTO_INCREMENT,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity int not null, -- 商品數量
    amount int not null  -- 商品費用
)
