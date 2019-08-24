CREATE DATABASE  IF NOT EXISTS `hospital_management` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `hospital_management`;
-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hospital_management
-- ------------------------------------------------------
-- Server version	5.7.26-log

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
-- Table structure for table `apointment`
--

DROP TABLE IF EXISTS `apointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `apointment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `drName` varchar(45) DEFAULT NULL,
  `drPhone` int(12) DEFAULT NULL,
  `dID` int(12) DEFAULT NULL,
  `fName` varchar(45) DEFAULT NULL,
  `lName` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` int(12) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apointment`
--

LOCK TABLES `apointment` WRITE;
/*!40000 ALTER TABLE `apointment` DISABLE KEYS */;
INSERT INTO `apointment` VALUES (1,'Monir',193100000,0,'salauddin','ahmed','salauddin@gmail.com',975420,'Male','dhaka',NULL),(2,'Dr. Robiul ISlam',987,0,'jitu ','ahmed','jitu@gmail.com',35867,'Male','dghfnhgfngn',NULL),(3,NULL,0,0,'gfgh','fhtgh','thtrrts5',360,'Female','fhtgh','2019-08-27'),(4,'Dr. salauddin',123456,0,'Habib','Ahmed','habib',89656450,'Male','awrewgy4ryh','2019-08-29'),(5,'Dr. salauddin',123456,0,'jitu','ahmed','jitu@gmail.com',7657645,'Male','asghgjy','2019-08-28'),(6,'Dr. salauddin',123456,0,'Habib','ahmed','jitu@gmail.com',534430,'Female','3rereg','2019-08-21');
/*!40000 ALTER TABLE `apointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctors`
--

DROP TABLE IF EXISTS `doctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `doctors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` int(12) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `Specialist` varchar(45) DEFAULT NULL,
  `msg` varchar(100) DEFAULT NULL,
  `psd` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
/*!40000 ALTER TABLE `doctors` DISABLE KEYS */;
INSERT INTO `doctors` VALUES (1,'Monir','monir@gmail.com',193100000,'Male','MEDICINE','sdyewyiduxkbjewdedewdx',NULL),(2,'Dr. salauddin','salauddin@gmail.com',123456,'Male','SURGERY','Very lazy man',NULL),(3,'Dr. Robiul ISlam','robiul@gmail.com',987,'Male','MEDICINE','sffh gjhgm',NULL),(4,'Faruk','faruk',2443564,'Male','SURGERY','fghfhbthtrhgrtgh',NULL),(5,'rabbi','rabbi@gmail.com',97452,'Male','SURGERY','thjtrhtrhytr','rabbi');
/*!40000 ALTER TABLE `doctors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'hospital_management'
--

--
-- Dumping routines for database 'hospital_management'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-24 14:16:34
