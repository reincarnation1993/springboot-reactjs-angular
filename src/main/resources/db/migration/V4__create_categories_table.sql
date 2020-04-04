DROP TABLE IF EXISTS `categories`;

CREATE TABLE `categories`
(
    id            INT          NOT NULL auto_increment,
    identifier    VARCHAR(36)  NOT NULL,
    category_name VARCHAR(255) NOT NULL,
    delete_flg    BIT(1)       NOT NULL DEFAULT 0 COMMENT '0: not deleted, 1: deleted',
    created_at    DATETIME     NOT NULL,
    updated_at    DATETIME              DEFAULT NULL,
    PRIMARY KEY (id)
)
    CHARACTER SET utf8mb4
    collate utf8mb4_general_ci
;

CREATE UNIQUE INDEX category_identify
    ON categories (identifier);