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

CREATE TABLE `inorder` (
  `inId` char(50) NOT NULL,
  `preId` char(50) DEFAULT NULL,
  `orderType` char(50) DEFAULT NULL,
  `userId` char(50) DEFAULT NULL,
  `userName` char(50) DEFAULT NULL,
  `gender` int(2) DEFAULT '0',
  `cellPhone` char(50) DEFAULT NULL,
  `IDnumber` char(50) DEFAULT NULL,
  `roomId` char(50) DEFAULT NULL,
  `inTime` char(50) DEFAULT NULL,
  `outTime` char(50) DEFAULT NULL,
  `status` char(10) DEFAULT NULL,
  `duration` char(50) DEFAULT NULL,
  `createrBy` char(50) DEFAULT NULL,
  `createrDate` char(50) DEFAULT NULL,
  `modifiedBy` char(50) DEFAULT NULL,
  `modifiedDate` char(50) DEFAULT NULL,
  PRIMARY KEY (`inId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `inorder` */

insert  into `inorder`(`inId`,`preId`,`orderType`,`userId`,`userName`,`gender`,`cellPhone`,`IDnumber`,`roomId`,`inTime`,`outTime`,`status`,`duration`,`createrBy`,`createrDate`,`modifiedBy`,`modifiedDate`) values 
('INON19060420583050000',NULL,'钟点房',NULL,'张三',1,'18255147511','342222199308142815','A001','2019-06-04 09:09',NULL,'入住',NULL,'mww','2019-06-04 20:58',NULL,'2019-06-04 21:40:51'),
('INON19060420585250000',NULL,'正常订单',NULL,'李四',0,'1825514751101','34222219930814281505','A003','2019-06-04 10:10',NULL,'入住',NULL,'mww','2019-06-04 20:58',NULL,NULL),
('INON19060420595080000',NULL,'活动订单',NULL,'王五',1,'1825514751102','341222199407052507','A003','2019-06-05 12:03','2019-06-04 21:44:13','结单',NULL,'mww','2019-06-04 20:59','mww','2019-06-04 21:44:13'),
('INON19060421002230000',NULL,'钟点房',NULL,'王二',1,'15955786721','34222219930814281501','A004','2019-06-04 14:14',NULL,'入住',NULL,'mww','2019-06-04 21:00',NULL,NULL),
('INON19060421004380000','PRE001','正常订单',NULL,'mww',1,'18255147511','34222219930814281501','A005','2019-05-29 21:47:12','2019-06-04 21:44:13','结单',NULL,'mww','2019-06-04 21:00','mww','2019-06-04 21:44:13');

/*Table structure for table `preorder` */

DROP TABLE IF EXISTS `preorder`;

CREATE TABLE `preorder` (
  `preId` char(50) NOT NULL,
  `orderType` char(50) DEFAULT NULL,
  `userId` char(50) DEFAULT NULL,
  `userName` char(50) DEFAULT NULL,
  `gender` int(2) DEFAULT '0',
  `cellPhone` char(50) DEFAULT NULL,
  `roomType` char(50) DEFAULT NULL,
  `preInTime` char(50) DEFAULT NULL,
  `preOutTime` char(50) DEFAULT NULL,
  `status` char(10) DEFAULT NULL,
  `remarks` varchar(5000) DEFAULT NULL,
  `createrBy` char(50) DEFAULT NULL,
  `createrDate` char(50) DEFAULT NULL,
  `arrivalTime` char(50) DEFAULT NULL,
  PRIMARY KEY (`preId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `preorder` */

insert  into `preorder`(`preId`,`orderType`,`userId`,`userName`,`gender`,`cellPhone`,`roomType`,`preInTime`,`preOutTime`,`status`,`remarks`,`createrBy`,`createrDate`,`arrivalTime`) values 
('PRE001','正常订单','1','mww',1,'18255147511','单间','2019-05-29 21:47:12','2019-05-30 12:00:00','结单','单间','mww','2019-05-30 12:00:00','2019-05-30 12:00:00'),
('PRE002','活动订单','2','wys',0,'15556926080','标间','2019-05-28 21:48:09','2019-05-28 21:48:09','创建','标间','mww','2019-05-30 12:00:00','2019-05-30 12:00:00'),
('PRE003','钟点房订单','1','mww',1,'18255147511','大床房','2019-05-28 21:48:09','2019-05-28 21:48:09','创建','大床房','mww','2019-05-30 12:00:00','2019-05-30 12:00:00'),
('PRE004','正常订单','2','wys',0,'18255147511','大床房','2019-05-28 21:48:09','2019-05-28 21:48:09','创建','大床房','mww','2019-05-30 12:00:00','2019-05-30 12:00:00');

/*Table structure for table `room` */

DROP TABLE IF EXISTS `room`;

CREATE TABLE `room` (
  `roomId` char(50) NOT NULL,
  `roomType` char(50) DEFAULT NULL,
  `status` char(2) DEFAULT NULL,
  PRIMARY KEY (`roomId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `room` */

insert  into `room`(`roomId`,`roomType`,`status`) values 
('A001','单间','闲置'),
('A002','标间','闲置'),
('A003','单间','闲置'),
('A004','大床房','闲置'),
('A005','单间','闲置'),
('A006','大床房','闲置');

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
