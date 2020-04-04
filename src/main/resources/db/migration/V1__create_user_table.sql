DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`
(
    id            INT          NOT NULL auto_increment,
    identifier    VARCHAR(36)  NOT NULL,
    user_name     VARCHAR(255) NOT NULL,
    password      VARCHAR(255) NOT NULL,
    email         VARCHAR(255),
    avatar_path   VARCHAR(255),
    avatar_name   VARCHAR(255),
    date_of_birth DATETIME,
    address_id    VARCHAR(36),
    delete_flg    BIT(1)       NOT NULL DEFAULT 0 COMMENT '0: not deleted, 1: deleted',
    created_at    DATETIME     NOT NULL,
    updated_at    DATETIME              DEFAULT NULL,
    PRIMARY KEY (id),
    CONSTRAINT user_unique UNIQUE (user_name)
)
    CHARACTER SET utf8mb4
    collate utf8mb4_general_ci
;

CREATE UNIQUE INDEX user_identify
    ON user (identifier);

-- pass : 123456
INSERT INTO `user`
( identifier
, user_name
, password
, email
, avatar_path
, avatar_name
, date_of_birth
, address_id
, delete_flg
, created_at)
VALUES ( UUID()
       , 'hoangdp.git.01'
       , '$2a$10$83OM3vEVWKZrXCcL6UBFS.f2l5hbH5Xl4hCZXEw2lxcaazk6Zy3TO'
       , 'hoangdp.git.01@gmail.com'
       , null
       , 'avatar_hoangdp'
       , DATE('1993-08-24')
       , null
       , 0
       , CURDATE())
;