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
  `drEmail` varchar(45) DEFAULT NULL,
  `fName` varchar(45) DEFAULT NULL,
  `lName` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` int(12) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apointment`
--

LOCK TABLES `apointment` WRITE;
/*!40000 ALTER TABLE `apointment` DISABLE KEYS */;
INSERT INTO `apointment` VALUES (2,'Dr. Robiul ISlam',987,'0','jitu ','ahmed','jitu@gmail.com',35867,'Male','dghfnhgfngn',NULL),(4,'Dr. salauddin',123456,'0','Habib','Ahmed','habib',89656450,'Male','awrewgy4ryh','2019-08-29'),(6,'Dr. salauddin',123456,'0','Habib','ahmed','jitu@gmail.com',534430,'Female','3rereg','2019-08-21'),(8,'Faruk',2443564,'faruk','Habib','','habib',89656450,'Male','','2019-08-29'),(9,'Dr. Jitu',9876544,'jitu@gmail.com','hasan','ali','hasan@gmail.com',13450,'Male','asfsdg','2019-09-10'),(10,'Dr. Asif  abdullah',134,'assif@gmail.com','fatema','akter','fatema@gmail.com',98765430,'Female','Khoksha, Kushtia','2019-09-14'),(12,'Dr. Jitu',9876544,'jitu@gmail.com','Abbas','uddin','abbas@gmail.com',98765,'Male','wetgrg','2019-09-15');
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
/*!40000 ALTER TABLE `doctors` DISABLE KEYS */;
INSERT INTO `doctors` VALUES (5,'Dr. Rabbi','rabbi@gmail.com',97452,'Male','SURGERY','MBBS','rabbi'),(6,'Dr. Enamul Haque','enamul@gmail.com',123455,'Male','GASTROENTEROLOGY ','MBBS, FCPS, PCS,BCS','enamul'),(7,'Dr. Ashraful islam','ashraf@gmail.com',987654,'Male','GASTROENTEROLOGY ','MBBS, PCS','ashraf'),(8,'Dr. Asif  abdullah','assif@gmail.com',134,'Male','SURGERY','MBBS','asif'),(9,'Dr. Jitu','jitu@gmail.com',9876544,'Male','PSYCHIATRY','MBBS, FCPS','jitu'),(10,'Dr. Jahid Raiham','jahid@gmail.com',8765,'Male','DENTISTRY','MBBS, BCS, FCPS','jahid');
/*!40000 ALTER TABLE `doctors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `massage`
--

DROP TABLE IF EXISTS `massage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `massage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `subject` varchar(45) DEFAULT NULL,
  `msg` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `massage`
--

LOCK TABLES `massage` WRITE;
/*!40000 ALTER TABLE `massage` DISABLE KEYS */;
INSERT INTO `massage` VALUES (1,'name','email@gmail.com','topic','achbd'),(2,'','','',''),(3,'safds','dsfd','sdd','sdv'),(4,'sdgrfg','dsgd','dsgdfgf','fgfdgfd');
/*!40000 ALTER TABLE `massage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `patient` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `drName` varchar(45) DEFAULT NULL,
  `drEmail` varchar(45) DEFAULT NULL,
  `drPhone` int(11) DEFAULT NULL,
  `drGender` varchar(45) DEFAULT NULL,
  `mdcn1` varchar(45) DEFAULT NULL,
  `rule1` varchar(45) DEFAULT NULL,
  `mdcn2` varchar(45) DEFAULT NULL,
  `rule2` varchar(45) DEFAULT NULL,
  `mdcn3` varchar(45) DEFAULT NULL,
  `rule3` varchar(45) DEFAULT NULL,
  `mdcn4` varchar(45) DEFAULT NULL,
  `rule4` varchar(45) DEFAULT NULL,
  `mdcn5` varchar(45) DEFAULT NULL,
  `rule5` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (2,'jitu ','jitu@gmail.com',35867,'Male',NULL,NULL,NULL,0,NULL,'edfs','1-2-4','desf','2-3-4','wrewr','2-3-4','erwewr','2-3-4','wrewer','2-3-4'),(3,'gfgh','thtrrts5',360,'Female','2019-08-27','rabbi','rabbi@gmail.com',97452,'Male','sfdgag','2-3-4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,NULL,'habib',89656450,'Male','2019-08-29','rabbi','rabbi@gmail.com',97452,'Male','as','2-3-4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'Habib','jitu@gmail.com',534430,'Female','2019-08-21',NULL,NULL,0,NULL,'sdcd12','2-3-4','sdf','3-5-5','','','','','',''),(11,'saidur','said@gmail.com',43210,'Male','2019-09-14','Dr. Jitu','jitu@gmail.com',9876544,'Male','sasas','1-3-3','efedv','1-2-3','adfesf','2-1-3','','','','');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
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

-- Dump completed on 2019-09-14  0:49:18
