SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user` (
  `id` int(11) NOT NULL auto_increment,
  `timestamp` timestamp default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
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
  `timestamp` timestamp default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `role_type` varchar(255) default NULL,
  `user_id` int(11) default NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES system_user (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

SET FOREIGN_KEY_CHECKS=1;