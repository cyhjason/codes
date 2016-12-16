/*
SQLyog Ultimate v8.32 
MySQL - 5.6.21-log : Database - ssm-demo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ssm-demo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ssm-demo`;

/*Table structure for table `sy_area` */

DROP TABLE IF EXISTS `sy_area`;

CREATE TABLE `sy_area` (
  `areaId` bigint(20) unsigned NOT NULL COMMENT '国家ID',
  `areaNameCn` varchar(50) NOT NULL COMMENT '国家中文名称',
  `areaNameEn` varchar(50) NOT NULL COMMENT '国家英文名称',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`areaId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sy_area` */

insert  into `sy_area`(`areaId`,`areaNameCn`,`areaNameEn`,`createTime`,`updateTime`) values (96824775296417791,'中国台湾','Chinese TaiWan','2016-10-19 11:07:19','2016-10-26 23:45:42'),(96824775296417793,'中国','Chinese','2016-10-19 11:09:56','2016-10-26 23:45:55'),(96824775296417794,'日本','Jp','2016-10-19 11:11:21','2016-10-26 23:52:33'),(96824775296417795,'美国','En','2016-10-19 11:11:21',NULL),(96824775296417796,'德国','DE','2016-10-19 11:11:21','2016-10-26 23:54:52'),(96824775296417797,'加拿大','JiaNaDa','2016-10-19 12:49:38','2016-11-12 15:01:23'),(96824775296417799,'123','Jia','2016-10-19 12:50:30','2016-11-12 14:38:54'),(96824775296417817,'印度','IND','2016-10-19 13:15:49','2016-11-12 14:38:50'),(96824775296417818,'荷兰','AS','2016-10-19 16:06:31','2016-10-28 14:42:32'),(96824775296417823,'澳大利亚','ASTY','2016-10-20 15:22:29','2016-10-28 14:42:40'),(96824775296417825,'澳大利亚','ASAS','2016-10-20 15:23:04','2016-10-28 14:16:47'),(96824775296417828,'澳大利亚','Australia','2016-10-20 15:24:56','2016-10-28 14:17:18'),(96824775296417829,'澳大利亚','Australia','2016-10-20 15:25:52','2016-10-28 14:58:23'),(96824775296417967,'印度','YinDU','2016-10-26 23:36:10','2016-10-28 15:52:48'),(96824775296417993,'美国','ACC','2016-10-28 15:54:00','2016-11-16 08:51:42'),(96897123584311296,'','','2016-12-01 14:28:43',NULL),(96897123584311298,'','','2016-12-01 14:29:04',NULL),(96897123584321321,'','','2016-12-01 14:29:17',NULL),(96897123584321322,'96897123584321323','','2016-12-01 14:40:12',NULL),(96915984698310658,'','','2016-12-14 15:31:35',NULL);

/*Table structure for table `sy_company` */

DROP TABLE IF EXISTS `sy_company`;

CREATE TABLE `sy_company` (
  `companyId` bigint(20) unsigned NOT NULL COMMENT '用户ID',
  `username` varchar(20) NOT NULL COMMENT '登陆用户名称',
  `password` varchar(32) DEFAULT NULL COMMENT '登陆密码',
  `companyName` varchar(64) DEFAULT NULL COMMENT '企业名称',
  `companyType` tinyint(4) NOT NULL COMMENT '用户类型：1、管理员；2、生产商；3、出口商、4、进口商；5、代理商、6、经销商；',
  `companyContactsName` varchar(64) DEFAULT NULL COMMENT '联系人姓名',
  `companyContactsTel` varchar(16) NOT NULL COMMENT '联系人电话',
  `companyContactsEmail` varchar(64) NOT NULL COMMENT '联系人邮箱',
  `companyContactsMobile` varchar(16) DEFAULT NULL COMMENT '联系人手机',
  `companyWorkAddress` varchar(256) DEFAULT NULL COMMENT '企业办公地址',
  `companyRegisterAddress` varchar(256) DEFAULT NULL COMMENT '企业注册地址',
  `companyLegal` varchar(64) DEFAULT NULL COMMENT '企业法人',
  `companyLegalTel` varchar(16) DEFAULT NULL COMMENT '企业法人手机',
  `companyLicenseImg` varchar(256) DEFAULT NULL COMMENT '营业执照',
  `companyComment` varchar(256) DEFAULT NULL COMMENT '备注说明',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `lastOpTime` datetime DEFAULT NULL COMMENT '最后一次操作时间',
  `companyStatus` tinyint(4) DEFAULT '1' COMMENT '企业状态：1-未激活；2-正常；3-禁用',
  PRIMARY KEY (`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业信息';

/*Data for the table `sy_company` */

insert  into `sy_company`(`companyId`,`username`,`password`,`companyName`,`companyType`,`companyContactsName`,`companyContactsTel`,`companyContactsEmail`,`companyContactsMobile`,`companyWorkAddress`,`companyRegisterAddress`,`companyLegal`,`companyLegalTel`,`companyLicenseImg`,`companyComment`,`createTime`,`lastOpTime`,`companyStatus`) values (96824775296417832,'admin','202CB962AC59075B964B07152D234B70','成都贸易',4,'张三','','13666160551@qq.com','13666160556','123','123','123','13666160556',NULL,NULL,'2016-10-21 16:51:53','2016-12-14 16:05:28',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
