CREATE DATABASE  IF NOT EXISTS `dbbarbearia` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `dbbarbearia`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dbbarbearia
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `agendamento`
--

DROP TABLE IF EXISTS `agendamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agendamento` (
  `AGEND_COD` int NOT NULL AUTO_INCREMENT,
  `AGEND_USR_COD` int NOT NULL,
  `AGEND_EMP_COD` int NOT NULL,
  `AGEND_DATA` varchar(45) NOT NULL,
  `AGEND_HORA` varchar(45) NOT NULL,
  PRIMARY KEY (`AGEND_COD`),
  KEY `AGEND_USR_COD_idx` (`AGEND_USR_COD`),
  KEY `AGEND_EMP_COD_idx` (`AGEND_EMP_COD`),
  CONSTRAINT `AGEND_EMP_COD` FOREIGN KEY (`AGEND_EMP_COD`) REFERENCES `empresa` (`EMP_COD`),
  CONSTRAINT `AGEND_USR_COD` FOREIGN KEY (`AGEND_USR_COD`) REFERENCES `usuario` (`USR_COD`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresa` (
  `EMP_COD` int NOT NULL AUTO_INCREMENT,
  `EMP_CNPJ` varchar(19) NOT NULL,
  `EMP_NOME` varchar(150) NOT NULL,
  `EMP_END` varchar(150) DEFAULT NULL,
  `EMP_EMAIL` varchar(150) DEFAULT NULL,
  `EMP_TEL` varchar(150) DEFAULT NULL,
  `EMP_LOGIN` varchar(150) DEFAULT NULL,
  `EMP_SENHA` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`EMP_COD`),
  UNIQUE KEY `EMP_CNPJ` (`EMP_CNPJ`),
  UNIQUE KEY `EMP_NOME` (`EMP_NOME`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `USR_COD` int NOT NULL AUTO_INCREMENT,
  `USR_CPF` varchar(15) NOT NULL,
  `USR_NOME` varchar(150) NOT NULL,
  `USR_EMAIL` varchar(100) DEFAULT NULL,
  `USR_CEL` varchar(15) DEFAULT NULL,
  `USR_LOGIN` varchar(100) DEFAULT NULL,
  `USR_SENHA` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`USR_COD`),
  UNIQUE KEY `USR_CPF` (`USR_CPF`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-24 13:26:56
