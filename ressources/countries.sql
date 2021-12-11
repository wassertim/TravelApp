SET
SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET
time_zone = "+00:00";

CREATE
DATABASE IF NOT EXISTS `m151` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE
`m151`;

CREATE TABLE `countries`
(
    `id`    int(11) NOT NULL AUTO_INCREMENT,
    `title` varchar(50) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `countries` (`title`)
VALUES ('AFGHANISTAN'),
       ('ALBANIA'),
       ('ALGERIA'),
       ('AMERICAN SAMOA'),
       ('ANDORRA'),
       ('ANGOLA'),
       ('ANGUILLA'),
       ('ANTARCTICA'),
       ('ANTIGUA AND BARBUDA');

CREATE TABLE `travel_destination`
(
    `id`    int(11) NOT NULL AUTO_INCREMENT,
    `benutzer`   varchar(50) NOT NULL,
    `country_id` int(11) NOT NULL,
    FOREIGN KEY (`country_id`) REFERENCES countries (`id`) ON DELETE CASCADE,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
