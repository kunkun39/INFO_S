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

DROP TABLE IF EXISTS `main_db_conf`;
CREATE TABLE `main_db_conf` (
  `id` int(11) NOT NULL auto_increment,
  `conf_key` varchar(20) default NULL,
  `conf_value` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `sub_db_conf`;
CREATE TABLE `sub_db_conf` (
  `id` int(11) NOT NULL auto_increment,
  `sub_host` varchar(40) default NULL,
  `sub_port` varchar(5) default NULL,
  `sub_name` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `db_back_history`;
CREATE TABLE `db_back_history` (
  `id` int(11) NOT NULL auto_increment,
  `bak_time` datetime default NULL,
  `bak_year` varchar(4) default NULL,
  `bak_code` varchar(4) default NULL,
  `bak_project_id` int(11) default NULL,
  `bak_subdb_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  FOREIGN KEY (`bak_project_id`) REFERENCES infogater_project (`id`),
  FOREIGN KEY (`bak_subdb_id`) REFERENCES sub_db_conf (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `infogater_project`;
CREATE TABLE `infogater_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


SET FOREIGN_KEY_CHECKS=1;