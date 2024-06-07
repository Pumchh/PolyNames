


CREATE TABLE IF NOT EXISTS `card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `word` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
)


INSERT INTO `sport` (`id`, `name`, `required_participants`) VALUES
	(1, 'Ordinateur'),
	(2, 'Chaise'),
    (3, 'Table');