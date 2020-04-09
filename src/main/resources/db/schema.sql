-- DROP TABLE IF EXISTS `hibernate_sequence`;
-- CREATE TABLE `hibernate_sequence` (
--   `next_val` bigint(20) DEFAULT NULL
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `jpa_entity_data`;
CREATE TABLE `jpa_entity_data` (
  `p_id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `save_time` datetime DEFAULT NULL,
  PRIMARY KEY (`p_id`),
  UNIQUE KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `jpa_info`;
CREATE TABLE `jpa_info` (
  `id` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `birth_day` datetime DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tdemo`;
CREATE TABLE `tdemo` (
  `id` int(11) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `sex` varchar(6) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `sex` varchar(6) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;