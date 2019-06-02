/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.7.21-log : Database - wys_hotel
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wys_hotel` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `wys_hotel`;

/*Table structure for table `inorder` */

DROP TABLE IF EXISTS `inorder`;

CREATE TABLE `preorder` (
  `inId` char(50) NOT NULL,
  `orderType` char(50) DEFAULT NULL,
  `userId` char(50) DEFAULT NULL,
  `userName` char(50) DEFAULT NULL,
  `gender` int(2) DEFAULT '0',
  `cellPhone` char(50) DEFAULT NULL,
  `IDnumber` char(50) DEFAULT NULL,
  `roomId` char(50) DEFAULT NULL,
  `inTime` datetime DEFAULT NULL,
  `outTime` datetime DEFAULT NULL,
  `status` char(10) DEFAULT NULL,
  `duration` time DEFAULT NULL,
  PRIMARY KEY (`inId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `inorder` */

insert  into `inorder`(`inId`,`orderType`,`userId`,`userName`,`gender`,`cellPhone`,`IDnumber`,`roomId`,`inTime`,`outTime`,`status`,`duration`) values 
('04399111-e700-4317-a57c-f70de15c45e5','Scene',NULL,'孟旺旺',1,'1825514751101','34222219930814281501','A002','2019-05-10 00:00:00','2019-05-11 00:00:00','10',NULL),
('ec8ab13a-f1c0-4d1c-bdc5-74c3936c3b8c','Scene',NULL,'孟旺旺01',1,'18255147511','34222219930814281501','A002','2019-05-11 00:00:00','2019-05-26 00:00:00','10',NULL),
('IN0001','Online',NULL,NULL,NULL,NULL,NULL,'A001','2019-05-29 21:47:12','2019-05-30 12:00:00','10','00:00:12'),
('IN002','Telephone',NULL,NULL,NULL,NULL,NULL,'A002','2019-05-28 21:48:09','2019-05-29 21:48:15','10','00:00:12'),
('INON002019060110:35:4983586.33461499611','Scene',NULL,'孟旺旺01',1,'1825514751101','34222219930814281501','A001','2019-06-02 00:00:00','2019-06-15 00:00:00','10',NULL);

/*Table structure for table `room` */

DROP TABLE IF EXISTS `room`;

CREATE TABLE `room` (
  `roomId` char(50) NOT NULL,
  `roomType` char(50) DEFAULT NULL,
  `status` char(2) DEFAULT NULL,
  PRIMARY KEY (`roomId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `room` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `gender` int(2) DEFAULT '0',
  `userName` char(50) DEFAULT NULL,
  `userPassword` char(50) DEFAULT NULL,
  `userType` char(20) DEFAULT 'common',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`userId`,`gender`,`userName`,`userPassword`,`userType`) values 
(1,0,'mww','123','admin'),
(2,0,'wys','123456','common');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
