DROP TABLE IF EXISTS `manufacturer`;

CREATE TABLE `manufacturer`
(
    id                       INT          NOT NULL auto_increment,
    identifier               VARCHAR(36)  NOT NULL,
    manufacturer_name        VARCHAR(255) NOT NULL,
    manufacturer_mobile      VARCHAR(11)  NOT NULL,
    manufacturer_address     VARCHAR(255) NOT NULL,
    manufacturer_description VARCHAR(255),
    delete_flg               BIT(1)       NOT NULL DEFAULT 0 COMMENT '0: not deleted, 1: deleted',
    created_at               DATETIME     NOT NULL,
    updated_at               DATETIME              DEFAULT NULL,
    PRIMARY KEY (id)
)
    CHARACTER SET utf8mb4
    collate utf8mb4_general_ci
;

CREATE UNIQUE INDEX manufacturer_identify
    ON manufacturer (identifier);