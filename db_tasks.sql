-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.22-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para db_tasks
CREATE DATABASE IF NOT EXISTS `db_tasks` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `db_tasks`;

-- Volcando estructura para tabla db_tasks.tasks
CREATE TABLE IF NOT EXISTS `tasks` (
  `idtask` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL DEFAULT '',
  `state` tinyint(4) NOT NULL,
  `date_execution` date NOT NULL,
  `time_execution` time NOT NULL,
  `iduserone` int(11) NOT NULL,
  `idusertwo` int(11) NOT NULL,
  PRIMARY KEY (`idtask`),
  KEY `iduserone` (`iduserone`),
  KEY `idusertwo` (`idusertwo`),
  CONSTRAINT `tasks_ibfk_1` FOREIGN KEY (`iduserone`) REFERENCES `users` (`iduser`),
  CONSTRAINT `tasks_ibfk_2` FOREIGN KEY (`idusertwo`) REFERENCES `users` (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla db_tasks.tasks: ~0 rows (aproximadamente)
DELETE FROM `tasks`;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` (`idtask`, `description`, `state`, `date_execution`, `time_execution`, `iduserone`, `idusertwo`) VALUES
	(1, 'Task #3', 0, '2022-05-12', '09:12:00', 1, 2);
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;

-- Volcando estructura para tabla db_tasks.users
CREATE TABLE IF NOT EXISTS `users` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `idusertype` int(11) DEFAULT NULL,
  `idstate` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`iduser`),
  KEY `idusertype` (`idusertype`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`idusertype`) REFERENCES `usertype` (`idusertype`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla db_tasks.users: ~3 rows (aproximadamente)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`iduser`, `username`, `password`, `name`, `lastname`, `idusertype`, `idstate`) VALUES
	(1, 'admin', '123', 'Admin', 'Admin', 1, 0),
	(2, 'User One', '123', 'User', 'One', 2, 0),
	(3, 'User Two', '202cb962ac59075b964b07152d234b70', 'User', 'Two', 2, 0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Volcando estructura para tabla db_tasks.usertype
CREATE TABLE IF NOT EXISTS `usertype` (
  `idusertype` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(50) NOT NULL,
  PRIMARY KEY (`idusertype`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla db_tasks.usertype: ~2 rows (aproximadamente)
DELETE FROM `usertype`;
/*!40000 ALTER TABLE `usertype` DISABLE KEYS */;
INSERT INTO `usertype` (`idusertype`, `description`) VALUES
	(1, 'Admin'),
	(2, 'Employe');
/*!40000 ALTER TABLE `usertype` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
