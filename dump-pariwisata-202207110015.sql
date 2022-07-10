-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: pariwisata
-- ------------------------------------------------------
-- Server version	5.5.5-10.6.8-MariaDB

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
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotel` (
  `kode_hotel` varchar(15) NOT NULL,
  `nama_hotel` varchar(200) NOT NULL,
  `harga` int(11) NOT NULL,
  `alamat_hotel` varchar(250) NOT NULL,
  PRIMARY KEY (`kode_hotel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES ('KH0001','Hotel Grand Vilia',250000,'Jl. Telaver No.1, Langgur, Kei Kecil, Kabupaten Maluku Tenggara, Maluku '),('KH0002','Pandawa',570000,'Kei');
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `isi_akomodasi`
--

DROP TABLE IF EXISTS `isi_akomodasi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `isi_akomodasi` (
  `id_pembayaran` varchar(12) NOT NULL,
  `tgl_checkin` date NOT NULL,
  `tgl_checkout` date NOT NULL,
  `nama_hotel` varchar(30) NOT NULL,
  `harga_hotel` int(11) NOT NULL,
  `lama_inap` int(11) NOT NULL,
  `total_hotel` int(11) NOT NULL,
  `nama_transportasi` varchar(30) NOT NULL,
  `harga_transportasi` int(11) NOT NULL,
  `total_transportasi` int(11) NOT NULL,
  `lama_hari` int(11) NOT NULL,
  `total_wisata` int(11) NOT NULL,
  UNIQUE KEY `uniq` (`id_pembayaran`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `isi_akomodasi`
--

LOCK TABLES `isi_akomodasi` WRITE;
/*!40000 ALTER TABLE `isi_akomodasi` DISABLE KEYS */;
INSERT INTO `isi_akomodasi` VALUES ('IT0001','2021-06-02','2021-06-03','Hotel Grand Vilia',250000,2,500000,'Honda Beat',100000,2,200000,70000),('IT0002','2021-06-11','2021-06-15','Hotel Grand Vilia',250000,4,1000000,'Honda Beat',100000,4,400000,40000),('IT0003','2021-06-11','2021-06-12','Hotel Grand Vilia',250000,2,500000,'Honda Beat',100000,2,200000,70000),('IT0004','2021-06-16','2021-06-17','Hotel Grand Vilia',250000,2,500000,'Honda Beat',100000,2,200000,20000);
/*!40000 ALTER TABLE `isi_akomodasi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `isi_oleh_oleh`
--

DROP TABLE IF EXISTS `isi_oleh_oleh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `isi_oleh_oleh` (
  `id_pembayaran` varchar(12) NOT NULL,
  `kode_barang` varchar(12) NOT NULL,
  `harga` int(11) NOT NULL,
  `qty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `isi_oleh_oleh`
--

LOCK TABLES `isi_oleh_oleh` WRITE;
/*!40000 ALTER TABLE `isi_oleh_oleh` DISABLE KEYS */;
INSERT INTO `isi_oleh_oleh` VALUES ('IP0001','KB0001',25000,2),('IP0001','KB0002',80000,1),('IP0002','KB0002',80000,2);
/*!40000 ALTER TABLE `isi_oleh_oleh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `isi_wisata`
--

DROP TABLE IF EXISTS `isi_wisata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `isi_wisata` (
  `id_pembayaran` varchar(12) NOT NULL,
  `kode_wisata` varchar(12) NOT NULL,
  `harga` int(11) NOT NULL,
  KEY `id_pembayaran` (`id_pembayaran`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `isi_wisata`
--

LOCK TABLES `isi_wisata` WRITE;
/*!40000 ALTER TABLE `isi_wisata` DISABLE KEYS */;
INSERT INTO `isi_wisata` VALUES ('IT0001','KW0001',20000),('IT0001','KW0002',50000),('IT0002','KW0001',20000),('IT0002','KW0001',20000),('IT0003','KW0001',20000),('IT0003','KW0002',50000),('IT0004','KW0001',20000);
/*!40000 ALTER TABLE `isi_wisata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nota`
--

DROP TABLE IF EXISTS `nota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nota` (
  `id_pembayaran` varchar(12) NOT NULL,
  `tgl` date NOT NULL,
  `id_pengunjung` varchar(20) NOT NULL,
  `id_pegawai` varchar(12) NOT NULL,
  PRIMARY KEY (`id_pembayaran`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota`
--

LOCK TABLES `nota` WRITE;
/*!40000 ALTER TABLE `nota` DISABLE KEYS */;
INSERT INTO `nota` VALUES ('IT0001','2021-06-01','34658866','KP0001'),('IT0002','2021-06-01','346588661','KP0001'),('IT0003','2021-06-10','34658866','KP0002'),('IT0004','2021-06-16','346588661','KP0001');
/*!40000 ALTER TABLE `nota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nota_oleh_oleh`
--

DROP TABLE IF EXISTS `nota_oleh_oleh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nota_oleh_oleh` (
  `id_pembayaran` varchar(12) NOT NULL,
  `tgl` date NOT NULL,
  `id_pengunjung` varchar(20) NOT NULL,
  `id_pegawai` varchar(12) NOT NULL,
  PRIMARY KEY (`id_pembayaran`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota_oleh_oleh`
--

LOCK TABLES `nota_oleh_oleh` WRITE;
/*!40000 ALTER TABLE `nota_oleh_oleh` DISABLE KEYS */;
INSERT INTO `nota_oleh_oleh` VALUES ('IP0001','2021-06-01','346588661','KP0001'),('IP0002','2019-06-16','34658866','KP0001');
/*!40000 ALTER TABLE `nota_oleh_oleh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oleh_oleh`
--

DROP TABLE IF EXISTS `oleh_oleh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oleh_oleh` (
  `kode_barang` varchar(15) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `Harga` int(11) NOT NULL,
  `stok` int(11) NOT NULL,
  `Alamat` varchar(200) NOT NULL,
  PRIMARY KEY (`kode_barang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oleh_oleh`
--

LOCK TABLES `oleh_oleh` WRITE;
/*!40000 ALTER TABLE `oleh_oleh` DISABLE KEYS */;
INSERT INTO `oleh_oleh` VALUES ('KB0001','kacang botol',25000,50,'kei'),('KB0002','baju festival meti kei',80000,600,'langgur');
/*!40000 ALTER TABLE `oleh_oleh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pegawai`
--

DROP TABLE IF EXISTS `pegawai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pegawai` (
  `id_pegawai` varchar(15) NOT NULL,
  `nama_pegawai` varchar(35) NOT NULL,
  `username` varchar(35) NOT NULL,
  `password` varchar(35) NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `role` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_pegawai`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pegawai`
--

LOCK TABLES `pegawai` WRITE;
/*!40000 ALTER TABLE `pegawai` DISABLE KEYS */;
INSERT INTO `pegawai` VALUES ('KP0001','Nasrul Matdoan','1','1','081617590996','Jl. Damai','owner'),('KP0002','Dewi','2','2','066556','Depok','admin'),('KP0003','Dewi','3','3','066556','Depok','operator'),('KP0004','Dewi','4','4','066556','Depok','finance');
/*!40000 ALTER TABLE `pegawai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pengunjung`
--

DROP TABLE IF EXISTS `pengunjung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pengunjung` (
  `nik` varchar(20) NOT NULL,
  `nama_pengunjung` varchar(35) NOT NULL,
  `jenis_kelamin` varchar(15) NOT NULL,
  `alamat` varchar(150) NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  `tujuan_wisata` varchar(200) NOT NULL,
  PRIMARY KEY (`nik`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pengunjung`
--

LOCK TABLES `pengunjung` WRITE;
/*!40000 ALTER TABLE `pengunjung` DISABLE KEYS */;
INSERT INTO `pengunjung` VALUES ('34658866','Wulan','Perempuan','Kp. Cikapek','08176348788','kei'),('346588661','Ismail','Laki-Laki','Kp. Gedong','08176348788','Kei');
/*!40000 ALTER TABLE `pengunjung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transportasi`
--

DROP TABLE IF EXISTS `transportasi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transportasi` (
  `kd_transportasi` varchar(15) NOT NULL,
  `jenis_transportasi` varchar(50) NOT NULL,
  `nama_transportasi` varchar(50) NOT NULL,
  `harga` int(11) NOT NULL,
  PRIMARY KEY (`kd_transportasi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transportasi`
--

LOCK TABLES `transportasi` WRITE;
/*!40000 ALTER TABLE `transportasi` DISABLE KEYS */;
INSERT INTO `transportasi` VALUES ('KT0001','Motor','Honda Beat',100000);
/*!40000 ALTER TABLE `transportasi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wisata`
--

DROP TABLE IF EXISTS `wisata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wisata` (
  `kode_wisata` varchar(15) NOT NULL,
  `nama_wisata` varchar(50) NOT NULL,
  `harga` int(12) NOT NULL,
  `alamat` varchar(150) NOT NULL,
  PRIMARY KEY (`kode_wisata`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wisata`
--

LOCK TABLES `wisata` WRITE;
/*!40000 ALTER TABLE `wisata` DISABLE KEYS */;
INSERT INTO `wisata` VALUES ('KW0001','Gua Hawang',20000,'Desa Letvuan, Kabupaten Maluku Tenggara, Propinsi Maluku'),('KW0002','Pantai Kei',50000,'Maluku Tenggara');
/*!40000 ALTER TABLE `wisata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'pariwisata'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-11  0:15:39
