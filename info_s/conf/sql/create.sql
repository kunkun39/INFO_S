SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(120) default NULL,
  `contact_way` varchar(255) default '',
  `username` varchar(48) default '',
  `password` varchar(48) default '',
  `enabled` tinyint(1) default '0' COMMENT '1 for YES or 0 for NO',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
ALTER TABLE `system_user` ADD INDEX  system_user_index_name(`name`);

DROP TABLE IF EXISTS `system_role`;
CREATE TABLE `system_role` (
  `id` int(11) NOT NULL auto_increment,
  `role_type` varchar(255) default NULL,
  `user_id` int(11) default NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES system_user (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `db_conf`;
CREATE TABLE `db_conf` (
  `id` int(11) NOT NULL auto_increment,
  `db_host` varchar(40) default NULL,
  `db_port` varchar(5) default NULL,
  `db_name` varchar(20) default NULL,
  `db_type` varchar(4) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `infogather_project`;
CREATE TABLE `infogather_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(5) NOT NULL,
  `project_random_key` varchar(4) COLLATE utf8_bin DEFAULT NULL,
  `project_name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `infogather_item`;
CREATE TABLE `infogather_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `item_key` varchar(20) COLLATE utf8_bin NOT NULL,
  `item_name` varchar(20) COLLATE utf8_bin NOT NULL,
  `project_id` int(5) DEFAULT NULL,
  `metadata_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `infogather_metadata`;
CREATE TABLE `infogather_metadata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `data_name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `user_id` int(5) DEFAULT NULL,
  `project_id` int(5) DEFAULT NULL,
  `isused` int(2) DEFAULT NULL,
  `content` text COLLATE utf8_bin,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


DROP TABLE IF EXISTS `db_bak_history`;
CREATE TABLE `db_bck_history` (
  `id` int(11) NOT NULL auto_increment,
  `bak_time` datetime default NULL,
  `bak_year` varchar(4) default NULL,
  `bak_code` varchar(4) default NULL,
  `bak_project_id` int(11) default NULL,
  `bak_db_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  FOREIGN KEY (`bak_project_id`) REFERENCES infogater_project (`id`),
  FOREIGN KEY (`bak_db_id`) REFERENCES db_conf (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


SET FOREIGN_KEY_CHECKS=1;