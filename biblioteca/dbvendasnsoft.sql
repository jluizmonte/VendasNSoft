-- MySQL dump 10.13  Distrib 8.0.17, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: dbvendasnsoft
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `tbl_cliente`
--

DROP TABLE IF EXISTS `tbl_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_cliente` (
  `pk_id_cliente` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `cli_nome` varchar(300) NOT NULL,
  `cli_endereco` varchar(350) NOT NULL,
  `cli_bairro` varchar(300) NOT NULL,
  `cli_cidade` varchar(200) NOT NULL,
  `cli_uf` varchar(2) NOT NULL,
  `cli_cep` varchar(9) NOT NULL,
  `cli_telefone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`pk_id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_cliente`
--

LOCK TABLES `tbl_cliente` WRITE;
/*!40000 ALTER TABLE `tbl_cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_forma_pagamento`
--

DROP TABLE IF EXISTS `tbl_forma_pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_forma_pagamento` (
  `pk_id_for_pag` bigint(11) NOT NULL AUTO_INCREMENT,
  `descricao_for_pag` varchar(255) NOT NULL DEFAULT '',
  `desconto_for_pag` float NOT NULL DEFAULT '0',
  `parcelas_for_pag` int(11) NOT NULL DEFAULT '0',
  `situacao_for_pag` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`pk_id_for_pag`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_forma_pagamento`
--

LOCK TABLES `tbl_forma_pagamento` WRITE;
/*!40000 ALTER TABLE `tbl_forma_pagamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_forma_pagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_marca`
--

DROP TABLE IF EXISTS `tbl_marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_marca` (
  `pk_id_marca` int(11) NOT NULL AUTO_INCREMENT,
  `marca` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`pk_id_marca`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_marca`
--

LOCK TABLES `tbl_marca` WRITE;
/*!40000 ALTER TABLE `tbl_marca` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_produto`
--

DROP TABLE IF EXISTS `tbl_produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_produto` (
  `pk_id_produto` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `pro_nome` varchar(300) NOT NULL,
  `pro_descricao` varchar(255) DEFAULT NULL,
  `pro_estoque` int(11) NOT NULL,
  `pro_valor` double(5,2) NOT NULL DEFAULT '0.00',
  `pro_valor_venda` double(5,2) NOT NULL DEFAULT '0.00',
  `pro_valor_unitario` double(5,2) DEFAULT NULL,
  `pro_marca` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`pk_id_produto`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_produto`
--

LOCK TABLES `tbl_produto` WRITE;
/*!40000 ALTER TABLE `tbl_produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_usuario`
--

DROP TABLE IF EXISTS `tbl_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_usuario` (
  `pk_id_usuario` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `usu_nome` varchar(200) NOT NULL,
  `usu_login` varchar(100) NOT NULL,
  `usu_senha` varchar(20) NOT NULL,
  PRIMARY KEY (`pk_id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_usuario`
--

LOCK TABLES `tbl_usuario` WRITE;
/*!40000 ALTER TABLE `tbl_usuario` DISABLE KEYS */;
INSERT INTO `tbl_usuario` VALUES (1,'José','admin','admin');
/*!40000 ALTER TABLE `tbl_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_vendas`
--

DROP TABLE IF EXISTS `tbl_vendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_vendas` (
  `pk_id_vendas` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `fk_cliente` bigint(20) unsigned NOT NULL DEFAULT '0',
  `ven_data_venda` date NOT NULL,
  `ven_valor_liquido` double(6,2) NOT NULL DEFAULT '0.00',
  `ven_valor_bruto` double(6,2) NOT NULL DEFAULT '0.00',
  `ven_desconto` double(6,2) NOT NULL DEFAULT '0.00',
  `ven_forma_pagamento` varchar(55) NOT NULL DEFAULT '',
  `ven_parcelas` varchar(55) NOT NULL DEFAULT '',
  PRIMARY KEY (`pk_id_vendas`) USING BTREE,
  KEY `fkcliente` (`fk_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_vendas`
--

LOCK TABLES `tbl_vendas` WRITE;
/*!40000 ALTER TABLE `tbl_vendas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_vendas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_vendas_produtos`
--

DROP TABLE IF EXISTS `tbl_vendas_produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_vendas_produtos` (
  `pk_id_venda_produto` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `fk_produto` bigint(20) unsigned NOT NULL DEFAULT '0',
  `fk_vendas` bigint(20) unsigned NOT NULL DEFAULT '0',
  `ven_pro_valor` double(6,2) NOT NULL DEFAULT '0.00',
  `ven_pro_quantidade` int(11) NOT NULL,
  PRIMARY KEY (`pk_id_venda_produto`) USING BTREE,
  KEY `fkprodutos` (`fk_produto`),
  KEY `fkvendas` (`fk_vendas`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_vendas_produtos`
--

LOCK TABLES `tbl_vendas_produtos` WRITE;
/*!40000 ALTER TABLE `tbl_vendas_produtos` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_vendas_produtos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-15 15:09:18
