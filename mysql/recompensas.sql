use recompensas;

-- MariaDB dump 10.19  Distrib 10.4.27-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: recompensas
-- ------------------------------------------------------
-- Server version	10.4.27-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `articulos`
--

DROP TABLE IF EXISTS `articulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articulos` (
  `idArticulo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `precio` float NOT NULL,
  `puntos` int(11) NOT NULL,
  PRIMARY KEY (`idArticulo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulos`
--

LOCK TABLES `articulos` WRITE;
/*!40000 ALTER TABLE `articulos` DISABLE KEYS */;
INSERT INTO `articulos` VALUES (1,'billetera',345.5,3),(2,'libreta',45,1),(3,'pluma fuente',500,5);
/*!40000 ALTER TABLE `articulos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compras` (
  `idCompra` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) NOT NULL,
  `idArticulo` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCompra`),
  KEY `fk_articulos_has_usuarios_articulos1` (`idArticulo`),
  KEY `fk_articulos_has_usuarios_usuarios1` (`id`),
  CONSTRAINT `fk_articulos_has_usuarios_articulos1` FOREIGN KEY (`idArticulo`) REFERENCES `articulos` (`idArticulo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_articulos_has_usuarios_usuarios1` FOREIGN KEY (`id`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
INSERT INTO `compras` VALUES (1,6,1,1);
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `items` (
  `idItem` int(11) NOT NULL AUTO_INCREMENT,
  `item` varchar(45) NOT NULL,
  `puntos` int(11) NOT NULL,
  PRIMARY KEY (`idItem`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (1,'billetera',15),(2,'lentes',10),(3,'bufanda',3);
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfiles`
--

DROP TABLE IF EXISTS `perfiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfiles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `perfil` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfiles`
--

LOCK TABLES `perfiles` WRITE;
/*!40000 ALTER TABLE `perfiles` DISABLE KEYS */;
INSERT INTO `perfiles` VALUES (1,'ADMINISTRADOR'),(2,'SUPERVISOR'),(3,'USUARIO');
/*!40000 ALTER TABLE `perfiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puntos`
--

DROP TABLE IF EXISTS `puntos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `puntos` (
  `id` int(11) NOT NULL,
  `puntos` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_puntos_usuarios1` FOREIGN KEY (`id`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puntos`
--

LOCK TABLES `puntos` WRITE;
/*!40000 ALTER TABLE `puntos` DISABLE KEYS */;
INSERT INTO `puntos` VALUES (6,3);
/*!40000 ALTER TABLE `puntos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recompensas`
--

DROP TABLE IF EXISTS `recompensas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recompensas` (
  `idRecompensa` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) NOT NULL,
  `idItem` int(11) NOT NULL,
  PRIMARY KEY (`idRecompensa`),
  KEY `fk_usuarios_has_recompensas_recompensas1` (`idItem`),
  KEY `fk_usuarios_has_recompensas_usuarios1` (`id`),
  CONSTRAINT `fk_usuarios_has_recompensas_recompensas1` FOREIGN KEY (`idItem`) REFERENCES `items` (`idItem`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarios_has_recompensas_usuarios1` FOREIGN KEY (`id`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recompensas`
--

LOCK TABLES `recompensas` WRITE;
/*!40000 ALTER TABLE `recompensas` DISABLE KEYS */;
/*!40000 ALTER TABLE `recompensas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarioperfil`
--

DROP TABLE IF EXISTS `usuarioperfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarioperfil` (
  `idUsuario` int(11) NOT NULL,
  `idPerfil` int(11) NOT NULL,
  KEY `fk_Perfiles1` (`idPerfil`),
  KEY `fk_Usuarios1` (`idUsuario`),
  CONSTRAINT `fk_Perfiles1` FOREIGN KEY (`idPerfil`) REFERENCES `perfiles` (`id`),
  CONSTRAINT `fk_Usuarios1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarioperfil`
--

LOCK TABLES `usuarioperfil` WRITE;
/*!40000 ALTER TABLE `usuarioperfil` DISABLE KEYS */;
INSERT INTO `usuarioperfil` VALUES (6,1);
/*!40000 ALTER TABLE `usuarioperfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `estatus` int(11) NOT NULL DEFAULT 1,
  `fechaRegistro` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (6,'Moises Arias','ammoises@gmail.com','moises','$2a$10$QT9XB6xCFwmZqvRbvhRgjOex5RFlcwX27jiHPYC/J2JEf9tLPldPO',1,'2023-06-19');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-22 15:26:01
