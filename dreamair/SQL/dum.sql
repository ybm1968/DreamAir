-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: joeun
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `admin_no` int NOT NULL AUTO_INCREMENT,
  `admin_id` varchar(100) NOT NULL DEFAULT 'ADMIN',
  `admin_pw` varchar(200) NOT NULL,
  PRIMARY KEY (`admin_no`,`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='상품(항공권) 입출고';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `airport`
--

DROP TABLE IF EXISTS `airport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airport` (
  `airport_no` int NOT NULL AUTO_INCREMENT,
  `airport_code` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL COMMENT '국제 OR 국내',
  PRIMARY KEY (`airport_no`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airport`
--

LOCK TABLES `airport` WRITE;
/*!40000 ALTER TABLE `airport` DISABLE KEYS */;
INSERT INTO `airport` VALUES (1,'ICN','인천','국제'),(2,'GMP','김포','국제'),(3,'CJU','제주','국내'),(4,'RSU','여수','국내'),(5,'PUS','부산','국내'),(6,'KIX','오사카','국제'),(7,'ZRH','취리히','국제'),(8,'DPS','발리','국제');
/*!40000 ALTER TABLE `airport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auth`
--

DROP TABLE IF EXISTS `auth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auth` (
  `auth_no` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) NOT NULL,
  `auth` varchar(100) NOT NULL,
  PRIMARY KEY (`auth_no`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='권한';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth`
--

LOCK TABLES `auth` WRITE;
/*!40000 ALTER TABLE `auth` DISABLE KEYS */;
INSERT INTO `auth` VALUES (46,'user','ROLE_USER'),(47,'admin','ROLE_USER'),(48,'admin','ROLE_ADMIN'),(49,'sgij56','ROLE_USER');
/*!40000 ALTER TABLE `auth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board` (
  `board_no` int NOT NULL AUTO_INCREMENT,
  `writer` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` text,
  `reg_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `upd_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `views` int NOT NULL DEFAULT '0',
  `user_no` int NOT NULL DEFAULT '0',
  `admin_no` int NOT NULL DEFAULT '0',
  `like` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`board_no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='게시판';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,'d','ed','d','2023-11-06 03:41:53','2023-11-06 03:41:53','2023-11-06 03:41:53',4,0,0,0),(2,'d','d','d','2023-11-06 03:42:04','2023-11-06 03:42:04','2023-11-06 03:42:04',44,0,0,0);
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `booking_no` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `seat_no` varchar(10) NOT NULL,
  `user_no` int NOT NULL,
  `user_no2` int NOT NULL DEFAULT '0',
  `product_no` int NOT NULL,
  `route_no` int NOT NULL,
  `pas_count` int NOT NULL,
  `round_trip` varchar(50) NOT NULL,
  `status` varchar(100) NOT NULL,
  `reg_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `upd_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`booking_no`,`name`),
  KEY `FK_seat_TO_booking_1` (`seat_no`),
  KEY `FK_seat_TO_booking_2` (`user_no`),
  KEY `FK_seat_TO_booking_3` (`user_no2`),
  KEY `FK_product_TO_booking_1` (`product_no`),
  KEY `FK_product_TO_booking_2` (`route_no`),
  CONSTRAINT `FK_product_TO_booking_1` FOREIGN KEY (`product_no`) REFERENCES `product` (`product_no`),
  CONSTRAINT `FK_product_TO_booking_2` FOREIGN KEY (`route_no`) REFERENCES `product` (`route_no`),
  CONSTRAINT `FK_seat_TO_booking_1` FOREIGN KEY (`seat_no`) REFERENCES `seat` (`seat_no`),
  CONSTRAINT `FK_seat_TO_booking_2` FOREIGN KEY (`user_no`) REFERENCES `seat` (`user_no`),
  CONSTRAINT `FK_seat_TO_booking_3` FOREIGN KEY (`user_no2`) REFERENCES `seat` (`user_no2`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='예매';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `cart_no` int NOT NULL AUTO_INCREMENT,
  `product_no` int NOT NULL,
  `user_no` int DEFAULT NULL,
  `user_no2` int DEFAULT NULL,
  `cart_cnt` int NOT NULL,
  PRIMARY KEY (`cart_no`),
  KEY `FK_product_TO_cart_1` (`product_no`),
  KEY `FK_users_TO_cart_1` (`user_no`),
  KEY `FK_user2_TO_cart_1` (`user_no2`),
  CONSTRAINT `FK_product_TO_cart_1` FOREIGN KEY (`product_no`) REFERENCES `product` (`product_no`),
  CONSTRAINT `FK_user2_TO_cart_1` FOREIGN KEY (`user_no2`) REFERENCES `user2` (`user_no2`),
  CONSTRAINT `FK_users_TO_cart_1` FOREIGN KEY (`user_no`) REFERENCES `users` (`user_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='장바구니';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `comment_no` int NOT NULL AUTO_INCREMENT,
  `board_no` int NOT NULL,
  `parent_table` varchar(50) NOT NULL,
  `parent_no` int NOT NULL,
  `writer` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `group_no` int DEFAULT '0',
  `super_no` int DEFAULT '0',
  `depth_no` int NOT NULL DEFAULT '0',
  `seq_no` int NOT NULL DEFAULT '0',
  `reg_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `upd_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `sub_count` int DEFAULT '0',
  PRIMARY KEY (`comment_no`),
  KEY `FK_board_TO_comment_1` (`board_no`),
  CONSTRAINT `FK_board_TO_comment_1` FOREIGN KEY (`board_no`) REFERENCES `board` (`board_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='댓글';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file` (
  `file_no` int NOT NULL AUTO_INCREMENT,
  `board_no` int NOT NULL,
  `parent_table` varchar(50) NOT NULL,
  `parent_no` int NOT NULL,
  `file_name` text NOT NULL,
  `origin_name` text,
  `file_path` text NOT NULL,
  `file_size` int NOT NULL DEFAULT '0',
  `reg_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `upd_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `file_code` int NOT NULL,
  PRIMARY KEY (`file_no`),
  KEY `FK_board_TO_file_1` (`board_no`),
  CONSTRAINT `FK_board_TO_file_1` FOREIGN KEY (`board_no`) REFERENCES `board` (`board_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='파일';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (1,2,'board',2,'27ff5080-3c63-4223-bf9d-e86193cf82f5_g흐음.png','g흐음.png','C:/upload/27ff5080-3c63-4223-bf9d-e86193cf82f5_g흐음.png',3665,'2023-11-06 03:42:04','2023-11-06 03:42:04',0);
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight` (
  `flight_no` int NOT NULL AUTO_INCREMENT,
  `flight_name` varchar(20) NOT NULL,
  `route_no` int NOT NULL,
  `seat_Max` int NOT NULL,
  `seat_remaining` int NOT NULL DEFAULT '0',
  `seat_used` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`flight_no`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (1,'air0001',1,20,0,0),(2,'air0002',2,20,0,0),(3,'air0003',3,20,0,0),(4,'air0004',4,20,0,0),(5,'air0001',5,20,0,0),(6,'air0002',6,20,0,0),(7,'air0003',7,20,0,0),(8,'air0004',8,20,0,0);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mileage`
--

DROP TABLE IF EXISTS `mileage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mileage` (
  `user_id` varchar(100) NOT NULL,
  `mileage` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='마일리지';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mileage`
--

LOCK TABLES `mileage` WRITE;
/*!40000 ALTER TABLE `mileage` DISABLE KEYS */;
INSERT INTO `mileage` VALUES ('admin',500000),('sgij56',0),('user',0);
/*!40000 ALTER TABLE `mileage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passengers`
--

DROP TABLE IF EXISTS `passengers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passengers` (
  `passenger_no` int NOT NULL AUTO_INCREMENT,
  `PIN_TYPE` int NOT NULL,
  `passenger_name` varchar(100) NOT NULL,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `gender` varchar(20) NOT NULL,
  `birth` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `booking_no` int DEFAULT NULL,
  `seat_no` varchar(10) DEFAULT NULL,
  `product_no` int NOT NULL,
  `route_no` int NOT NULL,
  PRIMARY KEY (`passenger_no`,`PIN_TYPE`,`passenger_name`),
  KEY `FK_passengers_TO_seat_1` (`passenger_name`) /*!80000 INVISIBLE */,
  KEY `FK_passengers_TO_ticket_2` (`passenger_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='탑승객';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passengers`
--

LOCK TABLES `passengers` WRITE;
/*!40000 ALTER TABLE `passengers` DISABLE KEYS */;
/*!40000 ALTER TABLE `passengers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passport`
--

DROP TABLE IF EXISTS `passport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passport` (
  `passport_no` varchar(200) NOT NULL,
  `PIN_TYPE` int NOT NULL COMMENT '1 - 주민등록증 / 2 - 여권 / 3 - 운전면허증',
  `user_id` varchar(100) NOT NULL,
  `Lastname` varchar(100) NOT NULL,
  `firstname` varchar(200) NOT NULL,
  `nationality` varchar(200) NOT NULL,
  `expiration_date` varchar(200) NOT NULL,
  PRIMARY KEY (`passport_no`),
  KEY `FK_PIN_TO_passport_1` (`PIN_TYPE`),
  CONSTRAINT `FK_PIN_TO_passport_1` FOREIGN KEY (`PIN_TYPE`) REFERENCES `pin` (`PIN_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='여권 정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passport`
--

LOCK TABLES `passport` WRITE;
/*!40000 ALTER TABLE `passport` DISABLE KEYS */;
INSERT INTO `passport` VALUES ('1',2,'userlee','lee','user','KOREA','2024/11/06'),('2',2,'sgij56','jung','seulgi','KOREA','2024/11/06');
/*!40000 ALTER TABLE `passport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persistent_logins`
--

DROP TABLE IF EXISTS `persistent_logins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persistent_logins`
--

LOCK TABLES `persistent_logins` WRITE;
/*!40000 ALTER TABLE `persistent_logins` DISABLE KEYS */;
/*!40000 ALTER TABLE `persistent_logins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pin`
--

DROP TABLE IF EXISTS `pin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pin` (
  `PIN_TYPE` int NOT NULL,
  `pin_name` varchar(50) NOT NULL,
  PRIMARY KEY (`PIN_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='신분증';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pin`
--

LOCK TABLES `pin` WRITE;
/*!40000 ALTER TABLE `pin` DISABLE KEYS */;
INSERT INTO `pin` VALUES (1,'주민등록증'),(2,'운전면허증'),(3,'여권');
/*!40000 ALTER TABLE `pin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_no` int NOT NULL AUTO_INCREMENT COMMENT '순번(상품)',
  `product_id` varchar(20) NOT NULL COMMENT '상품 아이디(코드)',
  `route_no` int NOT NULL,
  `name` varchar(100) NOT NULL,
  `product_cat` varchar(100) NOT NULL,
  `product_price` int NOT NULL,
  `departure` varchar(20) NOT NULL,
  `destination` varchar(20) NOT NULL,
  `product_regdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `product_upddate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `description` varchar(200) DEFAULT NULL COMMENT '상품 설명',
  `unitsInStock` int NOT NULL COMMENT '재고 수',
  `file` varchar(100) DEFAULT NULL COMMENT '상품 이미지',
  `cart_no` int DEFAULT NULL COMMENT '장바구니 번호',
  `cart_cnt` int DEFAULT NULL COMMENT '장바구니 상품 수량',
  PRIMARY KEY (`product_no`,`product_id`),
  KEY `FK_product_TO_booking_2` (`route_no`),
  CONSTRAINT `FK_route_TO_product_1` FOREIGN KEY (`route_no`) REFERENCES `route` (`route_no`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='상품(항공권)';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'P0001',1,'김포-제주','항공권',50000,'김포','제주','2023-11-05 15:00:00','2023-11-05 15:00:00','김포-제주 항공권 입니다.',50,NULL,NULL,NULL),(2,'P0002',2,'김포-울산','항공권',50000,'김포','울산','2023-11-05 15:00:00','2023-11-05 15:00:00','김포-울산 항공권 입니다.',50,NULL,NULL,NULL),(3,'P0003',3,'김포-부산','항공권',50000,'김포','부산','2023-11-05 15:00:00','2023-11-05 15:00:00','김포-부산 항공권 입니다.',50,NULL,NULL,NULL),(4,'P0004',4,'김포-여수','항공권',50000,'김포','여수','2023-11-05 15:00:00','2023-11-05 15:00:00','김포-여수 항공권 입니다.',50,NULL,NULL,NULL),(5,'P0005',5,'제주-김포','항공권',50000,'제주','김포','2023-11-05 15:00:00','2023-11-05 15:00:00','제주-김포 항공권 입니다.',50,NULL,NULL,NULL),(6,'P0006',6,'울산-김포','항공권',50000,'울산','김포','2023-11-05 15:00:00','2023-11-05 15:00:00','울산-김포 항공권 입니다.',50,NULL,NULL,NULL),(7,'P0007',7,'부산-김포','항공권',50000,'부산','김포','2023-11-05 15:00:00','2023-11-05 15:00:00','부산-김포 항공권 입니다.',50,NULL,NULL,NULL),(8,'P0008',8,'여수-김포','항공권',50000,'여수','김포','2023-11-05 15:00:00','2023-11-05 15:00:00','여수-김포 항공권 입니다.',10,NULL,NULL,NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_io`
--

DROP TABLE IF EXISTS `product_io`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_io` (
  `io_no` int NOT NULL AUTO_INCREMENT,
  `product_no` int NOT NULL,
  `route_no` int NOT NULL,
  `booking_no` int NOT NULL,
  `amount` int NOT NULL,
  `type` varchar(100) NOT NULL,
  PRIMARY KEY (`io_no`),
  KEY `FK_product_TO_product_io_1` (`product_no`),
  KEY `FK_product_TO_product_io_2` (`route_no`),
  KEY `FK_booking_TO_product_io_1` (`booking_no`),
  CONSTRAINT `FK_booking_TO_product_io_1` FOREIGN KEY (`booking_no`) REFERENCES `booking` (`booking_no`),
  CONSTRAINT `FK_product_TO_product_io_1` FOREIGN KEY (`product_no`) REFERENCES `product` (`product_no`),
  CONSTRAINT `FK_product_TO_product_io_2` FOREIGN KEY (`route_no`) REFERENCES `product` (`route_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_io`
--

LOCK TABLES `product_io` WRITE;
/*!40000 ALTER TABLE `product_io` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_io` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `route` (
  `route_no` int NOT NULL AUTO_INCREMENT,
  `departure` varchar(50) NOT NULL,
  `destination` varchar(50) NOT NULL,
  `departure_time` varchar(50) NOT NULL,
  `destination_time` varchar(50) NOT NULL,
  `departure_date` varchar(50) NOT NULL,
  `destination_date` varchar(50) NOT NULL,
  PRIMARY KEY (`route_no`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='노선';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` VALUES (1,'김포','제주','10:00','11:00','2023/11/06','2023/11/06'),(2,'김포','울산','10:00','11:00','2023/11/06','2023/11/06'),(3,'김포','부산','10:00','11:00','2023/11/06','2023/11/06'),(4,'김포','여수','10:00','11:00','2023/11/06','2023/11/06'),(5,'제주','김포','15:00','16:00','2023/11/06','2023/11/06'),(6,'울산','김포','15:00','16:00','2023/11/06','2023/11/06'),(7,'부산','김포','15:00','16:00','2023/11/06','2023/11/06'),(8,'여수','김포','15:00','16:00','2023/11/06','2023/11/06');
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat` (
  `seat_no` varchar(10) NOT NULL,
  `user_no` int NOT NULL,
  `user_no2` int NOT NULL,
  `booking_no` int NOT NULL,
  `product_no` int NOT NULL,
  `route_no` int NOT NULL,
  `passenger_name` varchar(100) NOT NULL,
  `flight_no` int NOT NULL,
  `seat_class` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`seat_no`),
  KEY `FK_seat_TO_booking_2` (`user_no`) /*!80000 INVISIBLE */,
  KEY `FK_seat_TO_booking_3` (`user_no2`),
  KEY `FK_booking_TO_seat_1` (`booking_no`),
  KEY `FK_booking_TO_seat_2` (`product_no`),
  KEY `FK_booking_TO_seat_3` (`route_no`),
  KEY `FK_passengers_TO_seat_1` (`passenger_name`),
  CONSTRAINT `FK_booking_TO_seat_1` FOREIGN KEY (`booking_no`) REFERENCES `booking` (`booking_no`),
  CONSTRAINT `FK_booking_TO_seat_2` FOREIGN KEY (`product_no`) REFERENCES `booking` (`product_no`),
  CONSTRAINT `FK_booking_TO_seat_3` FOREIGN KEY (`route_no`) REFERENCES `booking` (`route_no`),
  CONSTRAINT `FK_passengers_TO_seat_1` FOREIGN KEY (`passenger_name`) REFERENCES `passengers` (`passenger_name`),
  CONSTRAINT `FK_user2_TO_seat_1` FOREIGN KEY (`user_no2`) REFERENCES `user2` (`user_no2`),
  CONSTRAINT `FK_users_TO_seat_1` FOREIGN KEY (`user_no`) REFERENCES `users` (`user_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='좌석';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `ticket_no` int NOT NULL AUTO_INCREMENT,
  `PIN_TYPE` int NOT NULL,
  `passenger_no` int NOT NULL,
  `passenger_name` varchar(100) NOT NULL,
  `departure` varchar(50) NOT NULL,
  `destination` varchar(50) NOT NULL,
  `boarding` varchar(50) NOT NULL COMMENT '탑승 시간',
  `departure_time` varchar(50) NOT NULL,
  `destination_time` varchar(50) NOT NULL,
  `duration` varchar(20) NOT NULL,
  `checked_in` int NOT NULL,
  `is_boarded` int NOT NULL DEFAULT '0',
  `route_no` int DEFAULT NULL,
  `boarding_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '실제 탑승 시간',
  `departure_date` varchar(50) NOT NULL,
  `destination_date` varchar(50) NOT NULL,
  PRIMARY KEY (`ticket_no`),
  KEY `FK_passengers_TO_ticket_1` (`passenger_no`),
  KEY `FK_passengers_TO_ticket_2` (`passenger_no`) /*!80000 INVISIBLE */,
  KEY `FK_passengers_TO_ticket_3` (`passenger_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='탑승권';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user2`
--

DROP TABLE IF EXISTS `user2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user2` (
  `user_no2` int NOT NULL AUTO_INCREMENT,
  `phone` varchar(20) NOT NULL,
  `user_pw` varchar(200) NOT NULL,
  `status` varchar(20) NOT NULL DEFAULT '1',
  `user_id` varchar(100) NOT NULL DEFAULT 'GUEST-',
  PRIMARY KEY (`user_no2`,`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='비회원';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user2`
--

LOCK TABLES `user2` WRITE;
/*!40000 ALTER TABLE `user2` DISABLE KEYS */;
INSERT INTO `user2` VALUES (1,'01000000000','123456','GUEST','GUEST');
/*!40000 ALTER TABLE `user2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_no` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) NOT NULL,
  `user_pw` varchar(200) NOT NULL,
  `name` varchar(100) NOT NULL,
  `address` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(200) NOT NULL,
  `reg_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `upd_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` varchar(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_no`,`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='회원';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (43,'userlee','$2a$10$DWyBTmeFeAqKcGQxZ0cjhOdVZzisUtkcawxNOpcTnX1O...4v/bi2','이유저','인천시 부평구','01029405797','z____yn@naver.com','2023-11-06 01:02:02','2023-11-06 01:02:02','0'),(44,'admin','$2a$10$AIyoKnzRQNejoY0ySfyRLOmCFrFj3AfarR2EIr4fzDXDtoabl7rI2','관리자','인천시 부평구','01000000000','sample@email.com','2023-11-06 01:12:59','2023-11-06 01:12:59','0'),(45,'sgij56','$2a$10$vRnwDBxHcexmOjZtqIyA5OZcCN19Yf67hC20QHTWraWmqqG31jrsa','정슬기','인천시 부평구','01000000000','sample@email.com','2023-11-06 06:13:25','2023-11-06 06:13:25','0');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-06 15:52:07