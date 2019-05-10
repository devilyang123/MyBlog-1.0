/*
SQLyog Ultimate v12.4.1 (64 bit)
MySQL - 5.7.22 : Database - blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blog` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `blog`;

/*Table structure for table `tb_blog` */

DROP TABLE IF EXISTS `tb_blog`;

CREATE TABLE `tb_blog` (
  `blog_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(20) DEFAULT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `comments` int(11) DEFAULT '0',
  `content` longtext,
  `create_time` datetime DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `logic` int(11) DEFAULT '0',
  `read_num` int(11) DEFAULT '0',
  `summary_` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_top` int(11) DEFAULT '0',
  PRIMARY KEY (`blog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `tb_blog` */

insert  into `tb_blog`(`blog_id`,`category_id`,`category_name`,`comments`,`content`,`create_time`,`img_url`,`logic`,`read_num`,`summary_`,`title`,`update_time`,`is_top`) values 
(19,1,'Java',0,'<p>\r\n	爱仕达多\r\n</p>\r\n<p>\r\n	<img src=\"http://192.168.231.129/1557503590410.jpg\" alt=\"\" />\r\n</p>','2019-05-10 23:54:02','1557503626663.jpg',0,0,'','测试','2019-05-10 23:54:02',0),
(20,1,'Java',0,'<p>\r\n	爱仕达多\r\n</p>\r\n<p>\r\n	<img src=\"http://192.168.231.129/1557503590410.jpg\" alt=\"\" />\r\n</p>','2019-05-10 23:54:15','1557503639145.jpg',0,2,'','测试','2019-05-10 23:54:15',0);

/*Table structure for table `tb_category` */

DROP TABLE IF EXISTS `tb_category`;

CREATE TABLE `tb_category` (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `tb_category` */

insert  into `tb_category`(`category_id`,`name`) values 
(1,'Java'),
(2,'SpringBoot'),
(3,'Other'),
(4,'SpringCloud');

/*Table structure for table `tb_comment` */

DROP TABLE IF EXISTS `tb_comment`;

CREATE TABLE `tb_comment` (
  `comment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `blog_id` bigint(20) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

/*Data for the table `tb_comment` */

/*Table structure for table `tb_count` */

DROP TABLE IF EXISTS `tb_count`;

CREATE TABLE `tb_count` (
  `count_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `count` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`count_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_count` */

insert  into `tb_count`(`count_id`,`count`) values 
(1,0);

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `desc_` varchar(255) DEFAULT NULL,
  `born` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `user_name` varchar(255) NOT NULL,
  `active_code` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

insert  into `tb_user`(`user_id`,`desc_`,`born`,`create_time`,`email`,`gender`,`img_url`,`nick_name`,`password`,`phone`,`update_time`,`user_name`,`active_code`) values 
(18,NULL,NULL,'2019-01-08 14:15:55','1695540137@qq.com',NULL,NULL,NULL,'c41d7c66e1b8404545aa3a0ece2006ac',NULL,'2019-01-08 14:15:55','admin',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
