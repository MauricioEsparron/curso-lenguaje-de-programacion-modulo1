CREATE DATABASE  IF NOT EXISTS `bd_banca` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_banca`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_banca
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Dumping data for table `tb_atencion`
--

LOCK TABLES `tb_atencion` WRITE;
/*!40000 ALTER TABLE `tb_atencion` DISABLE KEYS */;
INSERT INTO `tb_atencion` VALUES (1,1,1,'Creación de tarjeta'),(2,2,2,'Creación de tarjeta');
/*!40000 ALTER TABLE `tb_atencion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_cliente`
--

LOCK TABLES `tb_cliente` WRITE;
/*!40000 ALTER TABLE `tb_cliente` DISABLE KEYS */;
INSERT INTO `tb_cliente` VALUES (1,'Enrique','Castro','84397681','961241422'),(2,'Aurora','Milo','49130599','910392168'),(3,'Thunder','Sky','52025753','983405487'),(4,'Pepito','Ronin','10687636','991664602'),(5,'Fernando','Castro','78935624','968357145'),(6,'Nicolas','Borie','88643725','938817324'),(7,'Alexandra','Martinez','96732183','935022754'),(8,'José','Gomez','12345678','111333666'),(11,'Dina','Cordova','96372936','993567273');
/*!40000 ALTER TABLE `tb_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_movimiento`
--

LOCK TABLES `tb_movimiento` WRITE;
/*!40000 ALTER TABLE `tb_movimiento` DISABLE KEYS */;
INSERT INTO `tb_movimiento` VALUES (1,'472143',3,'3204',2,'2020-08-22','2699',1400),(2,'305960',6,'2699',1,'2020-03-22','3204',2300),(3,'729621',3,'1048',4,'2020-01-15','7966',4500),(6,'233132',4,'6666',3,'2022-06-26','3204',100),(8,'472143',4,'3204',4,'2020-08-22','2699',1300);
/*!40000 ALTER TABLE `tb_movimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_operacion`
--

LOCK TABLES `tb_operacion` WRITE;
/*!40000 ALTER TABLE `tb_operacion` DISABLE KEYS */;
INSERT INTO `tb_operacion` VALUES (1,'Préstamo'),(2,'Transacción'),(3,'Depósito'),(4,'Retiro');
/*!40000 ALTER TABLE `tb_operacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_tarjeta`
--

LOCK TABLES `tb_tarjeta` WRITE;
/*!40000 ALTER TABLE `tb_tarjeta` DISABLE KEYS */;
INSERT INTO `tb_tarjeta` VALUES ('111111',2,2,'4444','2022-06-11','2022-06-25',1500),('166118',2,1,'7966','2019-03-04','2024-03-04',7500),('222222',3,1,'5555','2022-06-18','2022-06-23',200),('233132',1,1,'6666','2022-06-25','2021-06-30',0),('305960',1,2,'2699','2021-02-12','2026-02-12',4500),('321546',5,1,'8335','2022-10-21','2027-10-21',7500),('333333',11,4,'2222','2022-04-25','2022-06-25',3000),('424242',1,3,'1234','2022-06-26','2022-06-30',200),('472143',1,1,'3204','2020-02-19','2025-02-19',100),('729621',3,4,'1048','2018-07-20','2023-07-20',1500);
/*!40000 ALTER TABLE `tb_tarjeta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_tipocuenta`
--

LOCK TABLES `tb_tipocuenta` WRITE;
/*!40000 ALTER TABLE `tb_tipocuenta` DISABLE KEYS */;
INSERT INTO `tb_tipocuenta` VALUES (1,'Cuenta de Ahorro'),(2,'Cuenta Corriente'),(3,'Cuenta en Dólares'),(4,'Cuenta Nómina');
/*!40000 ALTER TABLE `tb_tipocuenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_tipousuario`
--

LOCK TABLES `tb_tipousuario` WRITE;
/*!40000 ALTER TABLE `tb_tipousuario` DISABLE KEYS */;
INSERT INTO `tb_tipousuario` VALUES (1,'Recepcionista'),(2,'Administrador');
/*!40000 ALTER TABLE `tb_tipousuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` VALUES (1,'Fernando','Cácerez Gatillón','92234774','982345121','U001','1001',1),(2,'Carlos','Santa Cruz','95374884','915664241','U002','1002',1),(3,'Marc','Baldeon','93233716','976531451','A001','1001',2);
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bd_banca'
--

--
-- Dumping routines for database 'bd_banca'
--
/*!50003 DROP PROCEDURE IF EXISTS `usp_listarTarjetaxCliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listarTarjetaxCliente`(xClient int)
begin
select  t.numtb_tarjeta,c.nombre,tc.descripcion,t.num_cuenta,t.fecha_afiliacion,t.fecha_caducidad,t.saldo
from tb_cliente c inner join tb_tarjeta t inner join tb_tipocuenta tc 
on t.cod_tipocuenta = tc.codtb_tipocuenta and
   c.codtb_cliente = t.cod_cliente
where cod_cliente = xClient;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listarTarjetaxTipoCuenta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listarTarjetaxTipoCuenta`(xTipCuenta int)
begin
select  t.numtb_tarjeta,c.nombre,tc.descripcion,t.num_cuenta,t.fecha_afiliacion,t.fecha_caducidad,t.saldo
from tb_cliente c inner join tb_tarjeta t inner join tb_tipocuenta tc 
on t.cod_tipocuenta = tc.codtb_tipocuenta and
   c.codtb_cliente = t.cod_cliente
where cod_tipocuenta = xTipCuenta;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listarTarjetaxUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listarTarjetaxUsuario`(xClient int)
begin
select  t.numtb_tarjeta,c.nombre,tc.descripcion,t.num_cuenta,t.fecha_afiliacion,t.fecha_caducidad,t.saldo
from tb_cliente c inner join tb_tarjeta t inner join tb_tipocuenta tc 
on t.cod_tipocuenta = tc.codtb_tipocuenta and
   c.codtb_cliente = t.cod_cliente
where cod_cliente = xClient;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listarTipoCuenta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listarTipoCuenta`(xCTipoCuenta int)
begin
select  t.numtb_tarjeta,concat(c.nombre,' ',c.apellido) as 'Nombre Completo',tc.descripcion,t.num_cuenta,t.fecha_afiliacion,t.fecha_caducidad,t.saldo
from tb_cliente c inner join tb_tarjeta t inner join tb_tipocuenta tc 
on t.cod_tipocuenta = tc.codtb_tipocuenta and
   c.codtb_cliente = t.cod_cliente
where codtb_tipocuenta = xCTipoCuenta;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listarTipoOperacion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listarTipoOperacion`(xTipoOperacion int)
begin
Select  m.codtb_movimiento,t.numtb_tarjeta,concat(c.nombre,' ',c.apellido) as 'Cliente',t.num_cuenta,o.descripcion,m.fecha_movimiento,m.cuenta_destino,m.monto
from tb_movimiento m  inner join tb_cliente c inner join tb_tarjeta t inner join tb_tipocuenta tc  inner join tb_operacion o
on t.cod_tipocuenta = tc.codtb_tipocuenta and
   c.codtb_cliente = t.cod_cliente and
   t.num_cuenta = m.num_cuenta and
   o.codtb_operacion = m.cod_operacion
   
where codtb_operacion = xTipoOperacion;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listarUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listarUsuario`(xtipo int)
begin
select  u.codtb_usuario,concat(u.nombre,' ',u.apellido) as 'Nombre Completo',u.dni, u.telefono,u.usuario, u.clave,t.descripcion
from tb_usuario u inner join tb_tipousuario t 
on u.cod_tipousuario = t.codtb_tipousuario
where cod_tipousuario = xtipo;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listarUsuarioxTipoCuenta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listarUsuarioxTipoCuenta`(xTipCuenta int)
begin
select  t.numtb_tarjeta,c.nombre,tc.descripcion,t.num_cuenta,t.fecha_afiliacion,t.fecha_caducidad,t.saldo
from tb_cliente c inner join tb_tarjeta t inner join tb_tipocuenta tc 
on t.cod_tipocuenta = tc.codtb_tipocuenta and
   c.codtb_cliente = t.cod_cliente
where cod_tipocuenta = xTipCuenta;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_validarUsuarioLogeo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_validarUsuarioLogeo`(usr char(4), clave char(4))
select * from tb_usuario where usuario = usr and clave = clave ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-28 10:18:33
