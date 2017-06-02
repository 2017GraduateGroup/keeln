-- MySQL dump 10.13  Distrib 5.7.9, for Win32 (AMD64)
--
-- Host: localhost    Database: db_kellen
-- ------------------------------------------------------
-- Server version	5.7.12-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `evaluate`
--

DROP TABLE IF EXISTS `evaluate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evaluate` (
  `evaluate_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评价编号',
  `content` varchar(400) NOT NULL COMMENT '评价内容',
  `scenic_region_id` bigint(20) NOT NULL COMMENT '旅游景点编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '评价用户编号',
  `gmt_creat` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '最近修改时间',
  PRIMARY KEY (`evaluate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='旅游景点评价表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluate`
--

LOCK TABLES `evaluate` WRITE;
/*!40000 ALTER TABLE `evaluate` DISABLE KEYS */;
/*!40000 ALTER TABLE `evaluate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scenic_region`
--

DROP TABLE IF EXISTS `scenic_region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scenic_region` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `title` varchar(45) DEFAULT NULL COMMENT '标题',
  `grade` varchar(45) DEFAULT NULL COMMENT '景区级别',
  `price_min` varchar(45) DEFAULT NULL COMMENT '最低价格',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `url` varchar(200) DEFAULT NULL COMMENT '网址',
  `area` int(11) DEFAULT NULL,
  `hot_flag` int(11) DEFAULT NULL COMMENT '热度(1-5)',
  `imgurl` varchar(200) DEFAULT NULL COMMENT '图片地址',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '最后一次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scenic_region`
--

LOCK TABLES `scenic_region` WRITE;
/*!40000 ALTER TABLE `scenic_region` DISABLE KEYS */;
INSERT INTO `scenic_region` VALUES (1,'乐和乐都主题公园','','176','重庆市永川区卫星湖街道凤龙路999号','http://www.ly.com/scenery/BookSceneryTicket_31087.html',NULL,NULL,'http://pic4.40017.cn/scenery/destination/2016/07/14/15/J1apPk_240x135_00.jpg','2017-05-14 10:48:41','2017-05-14 10:48:41'),(2,'重庆海昌加勒比海水世界','AAAA','30','重庆市南岸区崇文路35号加勒比海水世界客服电话：023-86969999','http://www.ly.com/scenery/BookSceneryTicket_28270.html',NULL,NULL,'http://pic4.40017.cn/scenery/destination/2016/07/20/15/6FiWtL_240x135_00.jpg','2017-05-14 10:48:41','2017-05-14 10:48:41'),(3,'金源方特科幻公园','AAAA','110','重庆市江北区董家溪','http://www.ly.com/scenery/BookSceneryTicket_12508.html',NULL,NULL,'http://pic4.40017.cn/scenery/destination/2016/08/09/14/XbKcwB_240x135_00.jpg','2017-05-14 10:48:41','2017-05-14 10:48:41'),(4,'重庆南山植物园','AAAA','45','重庆市南岸区南山植物园路101号','http://www.ly.com/scenery/BookSceneryTicket_8026.html',NULL,NULL,'http://pic4.40017.cn/scenery/destination/2017/02/15/13/c9C0Vy_240x135_00.jpg','2017-05-14 10:48:41','2017-05-14 10:48:41'),(5,'重庆统景温泉风景区','AAAA','88','重庆渝北区统景镇景泉路66号','http://www.ly.com/scenery/BookSceneryTicket_2796.html',NULL,NULL,'http://pic4.40017.cn/scenery/destination/2016/07/27/20/gTYUHd_240x135_00.jpg','2017-05-14 10:48:41','2017-05-14 10:48:41'),(6,'重庆神龙峡','','80','重庆市南川区','http://www.ly.com/scenery/BookSceneryTicket_26666.html',NULL,NULL,'http://pic4.40017.cn/scenery/destination/2016/07/21/16/Wqc1fk_240x135_00.jpg','2017-05-14 10:48:41','2017-05-14 10:48:41'),(7,'重庆黑山谷','AAAAA','90','重庆市万盛区黑山镇境内','http://www.ly.com/scenery/BookSceneryTicket_8020.html',NULL,NULL,'http://pic4.40017.cn/scenery/destination/2016/08/03/16/9dFozt_240x135_00.jpg','2017-05-14 10:48:41','2017-05-14 10:48:41'),(8,'金佛山','AAAAA','100','重庆市南川区金佛山西坡','http://www.ly.com/scenery/BookSceneryTicket_2287.html',NULL,NULL,'http://pic4.40017.cn/scenery/destination/2016/07/21/16/0JgDgz_240x135_00.jpg','2017-05-14 10:48:42','2017-05-14 10:48:42'),(9,'重庆市游乐园','','39','重庆市石板坡长江大桥南坪南桥头','http://www.ly.com/scenery/BookSceneryTicket_28958.html',NULL,NULL,'http://pic4.40017.cn/scenery/destination/2016/07/21/16/aTBFlY_240x135_00.jpg','2017-05-14 10:48:42','2017-05-14 10:48:42'),(10,'重庆金刀峡景区','AAAA','90','重庆市北碚区康宁路12号','http://www.ly.com/scenery/BookSceneryTicket_1484.html',NULL,NULL,'http://pic4.40017.cn/scenery/destination/2016/07/25/09/zYcRA2_240x135_00.jpg','2017-05-14 10:48:42','2017-05-14 10:48:42');
/*!40000 ALTER TABLE `scenic_region` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `user_name` varchar(45) NOT NULL COMMENT '用户名',
  `password` varchar(60) DEFAULT NULL COMMENT '用户密码',
  `nick_name` varchar(45) DEFAULT NULL COMMENT '昵称',
  `user_gender` char(5) DEFAULT NULL COMMENT '性别',
  `user_identify_id` int(11) NOT NULL COMMENT '用户身份编号',
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `fk_user_user_identify_idx` (`user_identify_id`),
  CONSTRAINT `fk_user_user_identify` FOREIGN KEY (`user_identify_id`) REFERENCES `user_identify` (`identify_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_identify`
--

DROP TABLE IF EXISTS `user_identify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_identify` (
  `identify_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '身份编号',
  `identify_name` varchar(45) NOT NULL COMMENT '身份名称',
  PRIMARY KEY (`identify_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_identify`
--

LOCK TABLES `user_identify` WRITE;
/*!40000 ALTER TABLE `user_identify` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_identify` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'db_kellen'
--

--
-- Dumping routines for database 'db_kellen'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-22  8:48:03
