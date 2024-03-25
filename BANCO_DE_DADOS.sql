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
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agendamento`
--

LOCK TABLES `agendamento` WRITE;
/*!40000 ALTER TABLE `agendamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `agendamento` ENABLE KEYS */;
UNLOCK TABLES;

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
  `EMP_DESC` varchar(200) DEFAULT NULL,
  `EMP_REG1` varchar(45) DEFAULT NULL,
  `EMP_REG2` varchar(45) DEFAULT NULL,
  `EMP_REG3` varchar(45) DEFAULT NULL,
  `EMP_REG4` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`EMP_COD`),
  UNIQUE KEY `EMP_CNPJ` (`EMP_CNPJ`),
  UNIQUE KEY `EMP_NOME` (`EMP_NOME`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (1,'123','Barbearia Du\' Mário','Rua da Amora - Av. Castelo Branco - 263 - PA/BA','dumario@gmail.com','(75) 9 9999-0000','dumario','dumario','Inaugurada em 2023, A Barbearia Du\' Mário tem realizado diversos cortes em diversos clientes.','Proibido fumar','Proibido menores de 5','Proibido ofensas','Sem fiado'),(2,'456','Barbearia Brutus','Rua da Harmonia - Av. Juscelino Kubitheck - 543 - AL','brutus@gmail.com','(82) 9 8888-1111','brutus','brutus','Inaugurada em 2013, A Barbearia Brutus tem realizado diversos cortes em diversos clientes.','Proibido ficar sem camisa','Proibido entrar de capacete','Proibido xingar','Sem fiado'),(3,'789','Barbearia in1998','Rua da Independencia - 245 - Centro - Paulo Afonso/BA','in1998@gmail.com','(75) 9 0000-1111','in1998','in1998','Inaugurada em 1998, A Barbearia in 1998 tem realizado diversos cortes em diversos clientes.','Proibido fumar','Proibido beber','Proibido gritar','Sem fiado');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-25 16:40:56
