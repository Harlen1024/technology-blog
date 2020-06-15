-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: users
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bilibili`
--

DROP TABLE IF EXISTS `bilibili`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bilibili` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `ups` varchar(100) DEFAULT NULL,
  `info` text,
  `part` varchar(100) DEFAULT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `play` varchar(45) DEFAULT NULL,
  `barrage` varchar(45) DEFAULT NULL,
  `date` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bilibili`
--

LOCK TABLES `bilibili` WRITE;
/*!40000 ALTER TABLE `bilibili` DISABLE KEYS */;
INSERT INTO `bilibili` VALUES (1,'字幕君交流场所','<meta data-vue-meta=\"true\" itemprop=\"image\" content=\"http://static.hdslb.com/images/transparent.gif\">','碧诗',' kami.im 直男过气网红 # av362830 “We Are Star Dust” ',NULL,NULL,'721220','38507','2009-09-09 09:09:09'),(2,'字幕君交流场所','<meta data-vue-meta=\"true\" itemprop=\"image\" content=\"http://static.hdslb.com/images/transparent.gif\">','碧诗',' kami.im 直男过气网红 # av362830 “We Are Star Dust” ',NULL,NULL,'2140863','50497','2009-09-09 09:09:09'),(3,'2012地球便当之日宣传片','<meta data-vue-meta=\"true\" itemprop=\"image\" content=\"http://i1.hdslb.com/bfs/archive/9d916d187a48a85febfd6cfdbd1e527d63f177c4.jpg\">','碧诗',' kami.im 直男过气网红 # av362830 “We Are Star Dust” ',NULL,NULL,'1765335','11617','2009-06-26 15:11:36'),(4,'[思密达]无敌金馆长.','<meta data-vue-meta=\"true\" itemprop=\"image\" content=\"http://i0.hdslb.com/bfs/archive/00a48770fc0a2f57934e2c64a73e9f8128851235.jpg\">','碧诗',' kami.im 直男过气网红 # av362830 “We Are Star Dust” ',NULL,NULL,'728463','5609','2009-06-26 15:15:45'),(5,'音乐与弹幕同步 3.⑤','<meta data-vue-meta=\"true\" itemprop=\"image\" content=\"http://i1.hdslb.com/bfs/archive/b6cfbbecb0faa3e8b56ca4ba43844f0835ec21c4.jpg\">','AR-32763',' ALL MEMORIES ARE LOST IN TIME LIKE TEARS IN RAIN ',NULL,NULL,'335025','2674','2009-07-03 19:10:16'),(6,'【FATE相关】CRUCIS FATAL FAKE MV 《Faker》','<meta data-vue-meta=\"true\" itemprop=\"image\" content=\"http://i1.hdslb.com/bfs/archive/ef521697c031bd2b0aab5c8aab3abe1ea0ca63b9.jpg\">','bishi',NULL,NULL,NULL,'290693','6676','2009-07-09 01:15:33'),(7,'【初音ミク(40mP)】巨大少女','<meta data-vue-meta=\"true\" itemprop=\"image\" content=\"http://i0.hdslb.com/bfs/archive/771b5fb45e06b84257459a09ae9c79e5757ddfbf.jpg\">','hpkm4036',NULL,NULL,NULL,'298246','6747','2009-07-09 14:07:51'),(8,'多那路多信仰风化曲','<meta data-vue-meta=\"true\" itemprop=\"image\" content=\"http://i0.hdslb.com/bfs/archive/cce2e2090ebd254f7cc9065905277ffac292b17c.jpg\">','hpkm4036',NULL,NULL,NULL,'141280','2984','2009-07-09 15:59:12'),(9,'蓝蓝路的土耳其进行曲','<meta data-vue-meta=\"true\" itemprop=\"image\" content=\"http://i0.hdslb.com/bfs/archive/4853ac0167fa3f453652c319a3532251936165d8.jpg\">','烤夜雀',' http://thvideo.tv/ http://weibo.com/akyuuka 东方讨论群：126762408 ',NULL,NULL,'99947','1740','2009-07-09 16:56:50'),(10,'樱花大战COSPLAY～非常逼真','<meta data-vue-meta=\"true\" itemprop=\"image\" content=\"http://i0.hdslb.com/bfs/archive/a76b4969d24fc8604c449d98950352c313ae5d1d.jpg\">','saber酱',' 个人微博：http://weibo.com/saberchanchan/ ',NULL,NULL,'95610','1624','2009-07-09 17:02:50'),(11,'美少女伪娘～～～','<meta data-vue-meta=\"true\" itemprop=\"image\" content=\"http://i2.hdslb.com/bfs/archive/71ff13448b503b0cb7e6cf720fc4b60a10b20096.jpg\">','saber酱',' 个人微博：http://weibo.com/saberchanchan/ ',NULL,NULL,'31180','258','2009-07-09 17:10:22'),(12,'【海猫鸣泣之时 散】EP5 OP','<meta data-vue-meta=\"true\" itemprop=\"image\" content=\"http://i2.hdslb.com/bfs/archive/602a15a3128f7a3a8d080a303ccf17699ea363f3.jpg\">','Myon喵',NULL,'1/2',NULL,NULL,NULL,'2009-07-09 20:21:31');
/*!40000 ALTER TABLE `bilibili` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-01 18:27:15
