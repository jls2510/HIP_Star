CREATE DATABASE  IF NOT EXISTS `heavens` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `heavens`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: heavens
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `bsc5`
--

DROP TABLE IF EXISTS `bsc5`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bsc5` (
  `HR` int(11) NOT NULL,
  `Name` varchar(12) DEFAULT NULL,
  `DM` varchar(12) DEFAULT NULL,
  `HD` int(11) DEFAULT NULL,
  `SAO` int(11) DEFAULT NULL,
  `FK5` int(11) DEFAULT NULL,
  `IRflag` varchar(5) DEFAULT NULL,
  `r_IRflag` varchar(5) DEFAULT NULL,
  `Multiple` varchar(5) DEFAULT NULL,
  `ADS` int(11) DEFAULT NULL,
  `ADScomp` varchar(255) DEFAULT NULL,
  `VarID` varchar(12) DEFAULT NULL,
  `RAh1900` int(11) DEFAULT NULL,
  `RAm1900` int(11) DEFAULT NULL,
  `RAs1900` decimal(12,2) DEFAULT NULL,
  `DE-1900` varchar(5) DEFAULT NULL,
  `DEd1900` int(11) DEFAULT NULL,
  `DEm1900` int(11) DEFAULT NULL,
  `DEs1900` int(11) DEFAULT NULL,
  `RAh` int(11) DEFAULT NULL,
  `RAm` int(11) DEFAULT NULL,
  `RAs` decimal(12,2) DEFAULT NULL,
  `DE` varchar(5) DEFAULT NULL,
  `DEd` int(11) DEFAULT NULL,
  `DEm` int(11) DEFAULT NULL,
  `DEs` int(11) DEFAULT NULL,
  `GLON` decimal(12,2) DEFAULT NULL,
  `GLAT` decimal(12,2) DEFAULT NULL,
  `Vmag` decimal(12,2) DEFAULT NULL,
  `n_Vmag` varchar(5) DEFAULT NULL,
  `u_Vmag` varchar(255) DEFAULT NULL,
  `B-V` decimal(12,2) DEFAULT NULL,
  `u_B-V` varchar(255) DEFAULT NULL,
  `U-B` decimal(12,2) DEFAULT NULL,
  `u_U-B` varchar(255) DEFAULT NULL,
  `R-I` decimal(12,2) DEFAULT NULL,
  `n_R-I` varchar(5) DEFAULT NULL,
  `SpType` varchar(25) DEFAULT NULL,
  `n_SpType` varchar(5) DEFAULT NULL,
  `pmRA____*` decimal(65,30) DEFAULT NULL,
  `pmDE` decimal(65,30) DEFAULT NULL,
  `n_Parallax` varchar(5) DEFAULT NULL,
  `Parallax` decimal(65,30) DEFAULT NULL,
  `RadVel` int(11) DEFAULT NULL,
  `n_RadVel` varchar(5) DEFAULT NULL,
  `l_RotVel` varchar(5) DEFAULT NULL,
  `RotVel` int(11) DEFAULT NULL,
  `u_RotVel` varchar(5) DEFAULT NULL,
  `Dmag` decimal(12,2) DEFAULT NULL,
  `Sep` decimal(12,2) DEFAULT NULL,
  `MultID` varchar(5) DEFAULT NULL,
  `MultCnt` int(11) DEFAULT NULL,
  `NoteFlag` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`HR`),
  KEY `HD` (`HD`),
  KEY `Vmag` (`Vmag`),
  KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-25 12:30:01
