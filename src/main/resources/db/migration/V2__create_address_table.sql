DROP TABLE IF EXISTS `address`;

CREATE TABLE `address`
(
    id          INT         NOT NULL auto_increment,
    identifier  VARCHAR(36) NOT NULL,
    province_id VARCHAR(36) NOT NULL COMMENT 'tỉnh/thành phố',
    village_id  VARCHAR(36) NOT NULL COMMENT 'quận/huyện',
    district_id VARCHAR(36) NOT NULL COMMENT 'xã/phường/thị trấn',
    delete_flg  BIT(1)      NOT NULL DEFAULT 0 COMMENT '0: not deleted, 1: deleted',
    created_at  DATETIME    NOT NULL,
    updated_at  DATETIME             DEFAULT NULL,
    PRIMARY KEY (id)
)
    CHARACTER SET utf8mb4
    collate utf8mb4_general_ci
;

CREATE UNIQUE INDEX address_identify
    ON address (identifier);