DROP TABLE IF EXISTS product;

CREATE TABLE product
(
    id                 INT          NOT NULL auto_increment,
    identifier         VARCHAR(36)  NOT NULL,
    category_id        VARCHAR(36)  NOT NULL,
    name               VARCHAR(255) NOT NULL,
    image_path         VARCHAR(255),
    image_name         VARCHAR(100),
    color              VARCHAR(100),
    sell_price         DOUBLE       NOT NULL,
    manufacturer_price DOUBLE       NOT NULL,
    description        text,
    delete_flg         BIT(1)       NOT NULL DEFAULT 0 COMMENT '0: not deleted, 1: deleted',
    expire_date        DATETIME     NOT NULL,
    created_at         DATETIME     NOT NULL,
    updated_at         DATETIME              DEFAULT NULL,
    PRIMARY KEY (id)
)
    CHARACTER SET utf8mb4
    collate utf8mb4_general_ci
;

CREATE UNIQUE INDEX product_identify
    ON product (identifier);

INSERT INTO `product` (identifier, category_id, name, image_path, image_name, color, sell_price, manufacturer_price,
                       description, delete_flg, expire_date, created_at, updated_at)
VALUES ('2a166ff0-6492-4cb5-bec1-7beab517418d',
        '2a166ff0-6492-4cb5-bec1-7beab5177wrt',
        'product_01',
        null,
        null,
        null,
        20000,
        15000,
        null,
        0,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        null)