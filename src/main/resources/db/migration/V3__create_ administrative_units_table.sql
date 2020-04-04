DROP TABLE IF EXISTS `province`;

CREATE TABLE `province`
(
    id         INT          NOT NULL auto_increment,
    identifier VARCHAR(36)  NOT NULL,
    name       VARCHAR(255) NOT NULL,
    type       INT(1)       NOT NULL COMMENT '0: tỉnh, 1: thành phố',
    delete_flg BIT(1)       NOT NULL DEFAULT 0 COMMENT '0: not deleted, 1: deleted',
    created_at DATETIME     NOT NULL,
    updated_at DATETIME              DEFAULT NULL,
    PRIMARY KEY (id)
)
    CHARACTER SET utf8mb4
    collate utf8mb4_general_ci
;
CREATE UNIQUE INDEX province_identify
    ON province (identifier);

DROP TABLE IF EXISTS `district`;

CREATE TABLE `district`
(
    id          INT          NOT NULL auto_increment,
    identifier  VARCHAR(36)  NOT NULL,
    name        VARCHAR(255) NOT NULL,
    type        INT(1)       NOT NULL COMMENT '0: quận, 1: huyện',
    province_id VARCHAR(36)  NOT NULL,
    delete_flg  BIT(1)       NOT NULL DEFAULT 0 COMMENT '0: not deleted, 1: deleted',
    created_at  DATETIME     NOT NULL,
    updated_at  DATETIME              DEFAULT NULL,
    PRIMARY KEY (id)
)
    CHARACTER SET utf8mb4
    collate utf8mb4_general_ci
;
CREATE UNIQUE INDEX district_identify
    ON district (identifier);

DROP TABLE IF EXISTS `village`;

CREATE TABLE `village`
(
    id          INT          NOT NULL auto_increment,
    identifier  VARCHAR(36)  NOT NULL,
    name        VARCHAR(255) NOT NULL,
    type        INT(1)       NOT NULL COMMENT '0: xã, 1: phường, 2: thị trấn',
    district_id VARCHAR(36)  NOT NULL,
    delete_flg  BIT(1)       NOT NULL DEFAULT 0 COMMENT '0: not deleted, 1: deleted',
    created_at  DATETIME     NOT NULL,
    updated_at  DATETIME              DEFAULT NULL,
    PRIMARY KEY (id)
)
    CHARACTER SET utf8mb4
    collate utf8mb4_general_ci
;
CREATE UNIQUE INDEX village_identify
    ON village (identifier);