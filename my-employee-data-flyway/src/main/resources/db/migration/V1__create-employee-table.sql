CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `department` varchar(55) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
);