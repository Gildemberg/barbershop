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
  `AGEND_COD_USR` int NOT NULL,
  `AGEND_COD_CAL` int NOT NULL,
  PRIMARY KEY (`AGEND_COD`),
  KEY `AGEND_COD_CAL_idx` (`AGEND_COD_CAL`),
  KEY `AGEND_COD_USR_idx` (`AGEND_COD_USR`),
  CONSTRAINT `AGEND_COD_CAL` FOREIGN KEY (`AGEND_COD_CAL`) REFERENCES `calendario` (`CAL_COD`),
  CONSTRAINT `AGEND_COD_USR` FOREIGN KEY (`AGEND_COD_USR`) REFERENCES `usuario` (`USR_COD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `calendario`
--

DROP TABLE IF EXISTS `calendario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calendario` (
  `CAL_COD` int NOT NULL AUTO_INCREMENT,
  `CAL_COD_EMP` int NOT NULL,
  `CAL_HORA` varchar(5) NOT NULL,
  `CAL_DIA` varchar(2) NOT NULL,
  `CAL_MES` varchar(2) NOT NULL,
  `CAL_ANO` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`CAL_COD`),
  KEY `idEmpresa_idx` (`CAL_COD_EMP`),
  CONSTRAINT `idEmpresa` FOREIGN KEY (`CAL_COD_EMP`) REFERENCES `empresa` (`EMP_COD`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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

-- Dump completed on 2024-03-18 20:38:32
