CREATE DATABASE  IF NOT EXISTS `atm_service` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `atm_service`;

CREATE TABLE `atm_service` (
  `name` varchar(45) DEFAULT NULL,
  `account_number` varchar(45) NOT NULL,
  `balance` int(10) DEFAULT NULL,
  `pin` int(10) DEFAULT NULL,
  `overdraft_balance` int(10) DEFAULT NULL,
  PRIMARY KEY (`account_number`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

INSERT INTO `atm_service` VALUES
	('David','123456789',1000,1234,200),
	('John','987654321',1200,4321,150);


--Used mysql workbench to create table and database