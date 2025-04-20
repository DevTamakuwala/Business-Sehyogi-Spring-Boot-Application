-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: businesssehyogi
-- ------------------------------------------------------
-- Server version	9.0.0

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
-- Table structure for table `post_payment`
--

DROP TABLE IF EXISTS `post_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_payment` (
  `payment_id` int NOT NULL,
  `post_id` int NOT NULL,
  PRIMARY KEY (`payment_id`,`post_id`),
  KEY `FKo9nqvnhpkgyrj94hdyggr6ejj` (`post_id`),
  CONSTRAINT `FKo9nqvnhpkgyrj94hdyggr6ejj` FOREIGN KEY (`post_id`) REFERENCES `tbl_post` (`postId`),
  CONSTRAINT `FKr9ef3kx4p2u9xqyflmmcr1qyp` FOREIGN KEY (`payment_id`) REFERENCES `tbl_payment` (`payment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_payment`
--

LOCK TABLES `post_payment` WRITE;
/*!40000 ALTER TABLE `post_payment` DISABLE KEYS */;
INSERT INTO `post_payment` VALUES (24,1),(25,1),(26,1),(27,1),(1,2),(2,2),(3,2),(4,2),(5,2),(6,2),(7,2),(8,2),(9,2),(10,2),(11,2),(12,2),(13,2),(14,2),(15,2),(16,2),(17,2),(18,2),(19,2),(20,2),(21,2),(22,2),(23,2),(28,2),(29,2),(30,2),(31,2),(32,2),(33,2);
/*!40000 ALTER TABLE `post_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_admin`
--

DROP TABLE IF EXISTS `tbl_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_admin` (
  `adminId` int NOT NULL AUTO_INCREMENT,
  `adminEmail` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `admin_email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_admin`
--

LOCK TABLES `tbl_admin` WRITE;
/*!40000 ALTER TABLE `tbl_admin` DISABLE KEYS */;
INSERT INTO `tbl_admin` VALUES (1,'businesssehyogi@gmail.com','$2a$12$sVRRyo.06NyIKczEXZKXseZfbQKLFo.ggrU3HixafrUd.qzD0Jgh2',NULL);
/*!40000 ALTER TABLE `tbl_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_comments`
--

DROP TABLE IF EXISTS `tbl_comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_comments` (
  `commentId` int NOT NULL AUTO_INCREMENT,
  `date_and_time` datetime(6) NOT NULL,
  `visible` bit(1) NOT NULL,
  `post_id` int NOT NULL,
  `user_id` int NOT NULL,
  `comment` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`commentId`),
  KEY `FKqp3cucj23w3aybm8k5utxb6k0` (`post_id`),
  KEY `FK35mi83hesodt968d2i0x1cavn` (`user_id`),
  CONSTRAINT `FK35mi83hesodt968d2i0x1cavn` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`userId`),
  CONSTRAINT `FKqp3cucj23w3aybm8k5utxb6k0` FOREIGN KEY (`post_id`) REFERENCES `tbl_post` (`postId`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_comments`
--

LOCK TABLES `tbl_comments` WRITE;
/*!40000 ALTER TABLE `tbl_comments` DISABLE KEYS */;
INSERT INTO `tbl_comments` VALUES (1,'2024-11-17 01:56:52.524839',_binary '',7,29,'Nice idea'),(2,'2024-11-17 01:57:44.400164',_binary '',7,29,'Nice idea'),(3,'2024-11-17 01:59:01.343562',_binary '',1,29,'Nice idea'),(4,'2024-11-17 01:59:08.758123',_binary '',2,29,'Nice idea'),(5,'2024-11-17 01:59:16.662330',_binary '',3,29,'Nice idea'),(7,'2024-11-24 12:05:38.789839',_binary '',5,13,'helloo'),(8,'2024-11-24 12:06:16.621109',_binary '',5,13,'helloo'),(9,'2024-11-24 12:06:41.064610',_binary '',5,13,'helloo'),(10,'2024-11-24 12:06:57.713695',_binary '',5,13,'hello'),(11,'2024-11-24 21:27:27.987550',_binary '',5,13,'Hello'),(12,'2024-11-24 21:49:03.452025',_binary '',17,13,'Hello'),(13,'2024-11-24 23:39:01.096062',_binary '',5,29,'Hello'),(14,'2024-11-25 00:03:23.329834',_binary '',3,13,'hellooo'),(16,'2024-11-25 01:49:09.856589',_binary '',1,13,'hellooo'),(17,'2024-11-25 01:51:18.387146',_binary '',1,13,'hellooo'),(18,'2024-11-25 01:53:54.644747',_binary '',1,13,'hellooo'),(20,'2024-11-25 02:02:18.997638',_binary '',7,13,'hellooo+'),(22,'2024-11-25 02:03:16.668510',_binary '',1,13,'helloooo'),(23,'2024-11-25 02:16:11.127998',_binary '',2,13,'hellooo'),(24,'2024-11-25 02:16:16.658046',_binary '',2,13,'heyyy'),(25,'2024-11-25 02:45:32.861136',_binary '',1,13,'hello'),(26,'2024-11-25 02:47:20.494431',_binary '',1,13,'hello'),(27,'2024-11-25 02:47:55.105205',_binary '',1,13,'hello'),(28,'2024-11-25 02:48:20.914365',_binary '',1,13,'helloo'),(29,'2024-11-25 05:51:28.171735',_binary '',1,13,'hiii'),(30,'2024-11-25 08:41:25.310536',_binary '',1,29,'Hello'),(31,'2024-11-25 09:52:19.544667',_binary '',1,13,'hello'),(32,'2024-11-25 10:04:22.673943',_binary '',1,13,'hello'),(33,'2024-11-25 10:04:34.032265',_binary '',1,13,'nice '),(34,'2024-11-25 10:17:13.460118',_binary '',1,13,'hello'),(35,'2024-11-25 10:17:23.607824',_binary '',2,13,'nice post'),(36,'2024-11-25 10:18:28.524048',_binary '',1,13,'hi'),(37,'2024-11-25 11:07:45.507531',_binary '',1,13,'ijkjl'),(38,'2024-11-26 23:06:47.372377',_binary '',1,13,'dlaksdfjas'),(39,'2024-11-26 23:17:06.071470',_binary '',1,13,'Helloo'),(40,'2024-11-26 23:17:32.094669',_binary '',1,13,'asdf'),(41,'2024-11-26 23:17:36.172062',_binary '',1,13,'dsf'),(42,'2024-11-26 23:18:01.806229',_binary '',1,13,'asdfsd'),(43,'2024-11-26 23:23:56.493889',_binary '',1,13,'helloo job'),(44,'2024-11-26 23:39:48.841801',_binary '',4,13,'new comment'),(45,'2024-11-27 12:50:37.907933',_binary '',2,59,'what an idea'),(46,'2024-11-27 13:10:15.666102',_binary '',1,13,'Nice Post'),(47,'2024-11-29 23:42:45.708193',_binary '',3,29,'good post'),(48,'2024-11-29 23:43:25.686627',_binary '',3,29,'good post'),(49,'2024-11-29 23:44:09.677590',_binary '',3,29,'good idea'),(50,'2024-11-29 23:45:42.164180',_binary '',3,29,'good'),(51,'2024-11-29 23:46:08.850821',_binary '',4,29,'nice one'),(52,'2024-11-29 23:48:16.128691',_binary '',2,29,'hii'),(53,'2024-11-30 11:43:52.803806',_binary '',22,29,'nice');
/*!40000 ALTER TABLE `tbl_comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_connections`
--

DROP TABLE IF EXISTS `tbl_connections`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_connections` (
  `connectionId` int NOT NULL AUTO_INCREMENT,
  `status` varchar(255) NOT NULL,
  `co_founder_or_investor_user_id` int NOT NULL,
  `founder_user_id` int NOT NULL,
  PRIMARY KEY (`connectionId`),
  KEY `FK6c1t7crnpyaw7na3aonxg9950` (`co_founder_or_investor_user_id`),
  KEY `FKpfxmmvihf82bghdvof5k4f6oq` (`founder_user_id`),
  CONSTRAINT `FK6c1t7crnpyaw7na3aonxg9950` FOREIGN KEY (`co_founder_or_investor_user_id`) REFERENCES `tbl_user` (`userId`),
  CONSTRAINT `FKpfxmmvihf82bghdvof5k4f6oq` FOREIGN KEY (`founder_user_id`) REFERENCES `tbl_user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_connections`
--

LOCK TABLES `tbl_connections` WRITE;
/*!40000 ALTER TABLE `tbl_connections` DISABLE KEYS */;
INSERT INTO `tbl_connections` VALUES (1,'Accept',7,6),(2,'Accept',7,11),(4,'Accept',7,13),(6,'Accept',59,29),(7,'Accept',12,29),(8,'Accept',12,29),(10,'Accept',79,29),(11,'Accept',11,29);
/*!40000 ALTER TABLE `tbl_connections` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_history`
--

DROP TABLE IF EXISTS `tbl_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_history` (
  `historyId` int NOT NULL AUTO_INCREMENT,
  `change_date` datetime(6) DEFAULT NULL,
  `old_contact` decimal(38,0) DEFAULT NULL,
  `old_email` varchar(100) DEFAULT NULL,
  `old_password` varchar(100) DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`historyId`),
  KEY `FK5mn74oeeri5qk3143ng60ulxj` (`user_id`),
  CONSTRAINT `FK5mn74oeeri5qk3143ng60ulxj` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_history`
--

LOCK TABLES `tbl_history` WRITE;
/*!40000 ALTER TABLE `tbl_history` DISABLE KEYS */;
INSERT INTO `tbl_history` VALUES (1,'2024-11-23 23:59:25.899200',1111111111,'devmtamakuwala2424@gmail.com','businesssehyogi@123',6);
/*!40000 ALTER TABLE `tbl_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_images`
--

DROP TABLE IF EXISTS `tbl_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_images` (
  `imageId` int NOT NULL AUTO_INCREMENT,
  `imageName` varchar(255) DEFAULT NULL,
  `post_id` int NOT NULL,
  PRIMARY KEY (`imageId`),
  KEY `FK5dtpe8i5k2kf08l2roeua5txr` (`post_id`),
  CONSTRAINT `FK5dtpe8i5k2kf08l2roeua5txr` FOREIGN KEY (`post_id`) REFERENCES `tbl_post` (`postId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_images`
--

LOCK TABLES `tbl_images` WRITE;
/*!40000 ALTER TABLE `tbl_images` DISABLE KEYS */;
INSERT INTO `tbl_images` VALUES (1,'MyImage.jpg',2),(2,'MyImage.jpg',3);
/*!40000 ALTER TABLE `tbl_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_interest_area`
--

DROP TABLE IF EXISTS `tbl_interest_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_interest_area` (
  `interestAreaId` int NOT NULL AUTO_INCREMENT,
  `areaName` varchar(255) DEFAULT NULL,
  `area_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`interestAreaId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_interest_area`
--

LOCK TABLES `tbl_interest_area` WRITE;
/*!40000 ALTER TABLE `tbl_interest_area` DISABLE KEYS */;
INSERT INTO `tbl_interest_area` VALUES (1,'IT',NULL),(2,'MedTech',NULL),(3,'HealthTech',NULL);
/*!40000 ALTER TABLE `tbl_interest_area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_interested_posts`
--

DROP TABLE IF EXISTS `tbl_interested_posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_interested_posts` (
  `interestedPostId` int NOT NULL AUTO_INCREMENT,
  `investor_id` int NOT NULL,
  `post_id` int NOT NULL,
  PRIMARY KEY (`interestedPostId`),
  KEY `FK506q5j05m039jq2ytetirl2hf` (`investor_id`),
  KEY `FKhdemty29l85i3t6q3lwfc1xws` (`post_id`),
  CONSTRAINT `FK506q5j05m039jq2ytetirl2hf` FOREIGN KEY (`investor_id`) REFERENCES `tbl_investors` (`investorId`),
  CONSTRAINT `FKhdemty29l85i3t6q3lwfc1xws` FOREIGN KEY (`post_id`) REFERENCES `tbl_post` (`postId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_interested_posts`
--

LOCK TABLES `tbl_interested_posts` WRITE;
/*!40000 ALTER TABLE `tbl_interested_posts` DISABLE KEYS */;
INSERT INTO `tbl_interested_posts` VALUES (1,3,7),(7,1,22);
/*!40000 ALTER TABLE `tbl_interested_posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_invested`
--

DROP TABLE IF EXISTS `tbl_invested`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_invested` (
  `investId` int NOT NULL AUTO_INCREMENT,
  `investor_id` int NOT NULL,
  `post_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`investId`),
  KEY `FKmtpmb0ew436cgs6imsohvd6c7` (`investor_id`),
  KEY `FKpo0f1reyufmu8x8a511ibi0sc` (`post_id`),
  KEY `FK46klt418nnwkni0le500fxs6b` (`user_id`),
  CONSTRAINT `FK46klt418nnwkni0le500fxs6b` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`userId`),
  CONSTRAINT `FKmtpmb0ew436cgs6imsohvd6c7` FOREIGN KEY (`investor_id`) REFERENCES `tbl_investors` (`investorId`),
  CONSTRAINT `FKpo0f1reyufmu8x8a511ibi0sc` FOREIGN KEY (`post_id`) REFERENCES `tbl_post` (`postId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_invested`
--

LOCK TABLES `tbl_invested` WRITE;
/*!40000 ALTER TABLE `tbl_invested` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_invested` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_investor_interested_areas`
--

DROP TABLE IF EXISTS `tbl_investor_interested_areas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_investor_interested_areas` (
  `investorInterestedAreaId` int NOT NULL AUTO_INCREMENT,
  `area_id` int NOT NULL,
  `investor_id` int NOT NULL,
  PRIMARY KEY (`investorInterestedAreaId`),
  KEY `FK80sivapmpm9vf0ir5d6qq48w9` (`area_id`),
  KEY `FKdpruaavlpni5jwce8sac83yxu` (`investor_id`),
  CONSTRAINT `FK80sivapmpm9vf0ir5d6qq48w9` FOREIGN KEY (`area_id`) REFERENCES `tbl_interest_area` (`interestAreaId`),
  CONSTRAINT `FKdpruaavlpni5jwce8sac83yxu` FOREIGN KEY (`investor_id`) REFERENCES `tbl_investors` (`investorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_investor_interested_areas`
--

LOCK TABLES `tbl_investor_interested_areas` WRITE;
/*!40000 ALTER TABLE `tbl_investor_interested_areas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_investor_interested_areas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_investors`
--

DROP TABLE IF EXISTS `tbl_investors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_investors` (
  `investorId` int NOT NULL AUTO_INCREMENT,
  `topInvestedCompanies` varchar(255) DEFAULT NULL,
  `totalInvestedAmount` decimal(38,2) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`investorId`),
  UNIQUE KEY `UKduurlbpxgffg1763hfc2jmt0h` (`user_id`),
  CONSTRAINT `FKpml5ms171pugmjc12tbg1vf90` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_investors`
--

LOCK TABLES `tbl_investors` WRITE;
/*!40000 ALTER TABLE `tbl_investors` DISABLE KEYS */;
INSERT INTO `tbl_investors` VALUES (1,'Zomato, Sepepto',50000000.00,11),(3,'Flipkart uber',5000000.00,79);
/*!40000 ALTER TABLE `tbl_investors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_likes`
--

DROP TABLE IF EXISTS `tbl_likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_likes` (
  `likeId` int NOT NULL AUTO_INCREMENT,
  `post_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`likeId`),
  KEY `FKeyqq46bikb6s68e5m4yx9arj1` (`post_id`),
  KEY `FK292clhjxn5hhjr4e902945e4` (`user_id`),
  CONSTRAINT `FK292clhjxn5hhjr4e902945e4` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`userId`),
  CONSTRAINT `FKeyqq46bikb6s68e5m4yx9arj1` FOREIGN KEY (`post_id`) REFERENCES `tbl_post` (`postId`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_likes`
--

LOCK TABLES `tbl_likes` WRITE;
/*!40000 ALTER TABLE `tbl_likes` DISABLE KEYS */;
INSERT INTO `tbl_likes` VALUES (1,1,6),(2,2,6),(3,3,6),(4,5,6),(5,10,6),(6,12,6),(7,12,7),(8,12,11),(9,12,12),(10,12,13),(12,1,6),(13,1,7),(15,1,12),(18,4,6),(23,16,13),(49,2,13),(50,3,13),(54,1,13),(88,2,29),(89,1,29),(90,6,29),(110,1,11),(112,5,11),(116,6,11),(118,9,29),(119,10,29),(120,11,29),(121,13,29),(122,14,29),(123,15,29),(124,39,29),(128,23,84);
/*!40000 ALTER TABLE `tbl_likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_links`
--

DROP TABLE IF EXISTS `tbl_links`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_links` (
  `linkId` int NOT NULL AUTO_INCREMENT,
  `link` varchar(255) DEFAULT NULL,
  `post_id` int NOT NULL,
  PRIMARY KEY (`linkId`),
  KEY `FK7ref7373xqd4efpa2iowjqglc` (`post_id`),
  CONSTRAINT `FK7ref7373xqd4efpa2iowjqglc` FOREIGN KEY (`post_id`) REFERENCES `tbl_post` (`postId`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_links`
--

LOCK TABLES `tbl_links` WRITE;
/*!40000 ALTER TABLE `tbl_links` DISABLE KEYS */;
INSERT INTO `tbl_links` VALUES (1,'https://youtu.be/d33a1pK4OYs?feature=shared',2),(2,'https://youtu.be/8QDORHQvdu8?feature=shared',3),(3,'https://youtu.be/d33a1pK4OYs?feature=shared',3),(4,'vs dvjkbh',13),(5,'jbnvbjkbv',13),(6,'lsjjvbswjbj',13),(7,'vgjn',14),(8,'https://www.irena.org/',15),(9,'https://hbr.org/topic/subject/remote-work',15),(10,'https://www.youtube.com/shorts/oBHhQD_FzZQ',16),(11,'https://music.youtube.com/watch?v=0DNCCl3sCjY&list=RDAMVM0DNCCl3sCjY',17),(12,'https://www.youtube.com/watch?v=YQmhMioCpeI',33),(13,'',34),(14,'',35),(15,'',36),(16,'',37),(17,'',38);
/*!40000 ALTER TABLE `tbl_links` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_payment`
--

DROP TABLE IF EXISTS `tbl_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_payment` (
  `payment_id` int NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `paymentDateTime` datetime(6) DEFAULT NULL,
  `transactionId` varchar(255) DEFAULT NULL,
  `payment_date_time` datetime(6) DEFAULT NULL,
  `transaction_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_payment`
--

LOCK TABLES `tbl_payment` WRITE;
/*!40000 ALTER TABLE `tbl_payment` DISABLE KEYS */;
INSERT INTO `tbl_payment` VALUES (1,150.5,'2024-10-05 14:30:00.000000','txn_1234567890',NULL,NULL),(2,150.5,'2024-10-05 14:30:00.000000','txn_1234567890',NULL,NULL),(3,150.5,'2024-10-05 14:30:00.000000','txn_1234567890',NULL,NULL),(4,150.5,'2024-11-24 17:03:47.326042','txn_1732448024736',NULL,NULL),(5,150.5,'2024-11-24 17:04:00.124921','txn_1732448037532',NULL,NULL),(6,150.5,'2024-11-24 17:13:20.324620','txn_1732448597749',NULL,NULL),(7,150.5,'2024-11-24 17:15:37.318574','txn_1732448734731',NULL,NULL),(8,150.5,'2024-11-24 17:22:22.673608','txn_1732449140096',NULL,NULL),(9,150.5,'2024-11-24 18:25:07.413825','txn_1732452904849',NULL,NULL),(10,150.5,'2024-11-24 21:19:22.336076','txn_1732463362339',NULL,NULL),(11,150.5,'2024-11-24 21:27:17.812795','txn_1732463837814',NULL,NULL),(12,150.5,'2024-11-24 21:33:01.674475','txn_1732464179709',NULL,NULL),(13,150.5,'2024-11-24 21:40:19.221528','txn_1732464619223',NULL,NULL),(14,150.5,'2024-11-24 21:40:31.291050','txn_1732464629318',NULL,NULL),(15,150.5,'2024-11-24 21:48:38.663639','txn_1732465118664',NULL,NULL),(16,150.5,'2024-11-24 23:39:03.522320','txn_1732471741139',NULL,NULL),(17,150.5,'2024-11-24 23:51:44.660626','txn_1732472502281',NULL,NULL),(18,150.5,'2024-11-24 23:52:27.611139','txn_1732472545233',NULL,NULL),(19,150.5,'2024-11-25 00:46:10.205804','txn_1732475767847',NULL,NULL),(20,150.5,'2024-11-25 00:46:21.961601','txn_1732475779601',NULL,NULL),(21,150.5,'2024-11-25 02:16:02.823442','txn_1732481160498',NULL,NULL),(22,150.5,'2024-11-25 02:48:52.754134','txn_1732483130049',NULL,NULL),(23,150.5,'2024-11-25 11:20:23.430381','txn_1732513823433',NULL,NULL),(24,150.5,'2024-11-27 11:19:16.096136','txn_1234567890',NULL,NULL),(25,150.5,'2024-11-27 11:19:24.481275','txn_1234567890',NULL,NULL),(26,150.5,'2024-11-27 11:19:30.860985','txn_1234567890',NULL,NULL),(27,150.5,'2024-11-27 11:19:52.529372','txn_1234567890',NULL,NULL),(28,150.5,'2024-11-27 12:21:14.455269','txn_1732690274390',NULL,NULL),(29,150.5,'2024-11-27 12:28:49.900334','txn_1732690729903',NULL,NULL),(30,150.5,'2024-11-27 12:38:55.725731','txn_1732691335036',NULL,NULL),(31,150.5,'2024-11-28 23:59:44.479095','txn_1732818584917',NULL,NULL),(32,150.5,'2024-11-29 00:18:18.946482','txn_1732819699149',NULL,NULL),(33,150.5,'2024-11-30 00:14:59.593154','txn_1732905899196',NULL,NULL);
/*!40000 ALTER TABLE `tbl_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_post`
--

DROP TABLE IF EXISTS `tbl_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_post` (
  `postId` int NOT NULL AUTO_INCREMENT,
  `abstractContent` varchar(150) DEFAULT NULL,
  `boostedPost` bit(1) NOT NULL,
  `content` varchar(500) DEFAULT NULL,
  `dateAndTime` datetime(6) DEFAULT NULL,
  `noOfInterested` bigint DEFAULT NULL,
  `noOfLikes` bigint DEFAULT NULL,
  `views` int NOT NULL,
  `visible` bit(1) NOT NULL,
  `area_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `noOfComments` bigint DEFAULT NULL,
  PRIMARY KEY (`postId`),
  KEY `FK7s9gd6767r872rxo2yao8lcoj` (`area_id`),
  KEY `FK2xe5ubrtvdd68bg3uf44vcgrt` (`user_id`),
  CONSTRAINT `FK2xe5ubrtvdd68bg3uf44vcgrt` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`userId`),
  CONSTRAINT `FK7s9gd6767r872rxo2yao8lcoj` FOREIGN KEY (`area_id`) REFERENCES `tbl_interest_area` (`interestAreaId`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_post`
--

LOCK TABLES `tbl_post` WRITE;
/*!40000 ALTER TABLE `tbl_post` DISABLE KEYS */;
INSERT INTO `tbl_post` VALUES (1,'This is a demo post.',_binary '\0','The main content of demo post.','2024-10-05 16:45:31.000000',5,7,101,_binary '',NULL,7,NULL,24),(2,'This is a demo post.',_binary '\0','The main content of the demo post.','2024-10-05 16:45:31.000000',5,4,100,_binary '',1,7,NULL,6),(3,'This is a demo post.',_binary '\0','The main content of the demo post.',NULL,5,3,100,_binary '',2,11,NULL,6),(4,'This is a demo post.',_binary '\0','The main content of the demo post.',NULL,5,2,100,_binary '',3,6,NULL,2),(5,'This is a demo post.',_binary '\0','The main content of the demo post.',NULL,5,2,100,_binary '',3,13,NULL,6),(6,'This is a demo post.',_binary '\0','The main content of the demo post.',NULL,5,2,100,_binary '\0',3,13,NULL,NULL),(7,'emvnv',_binary '\0','edvjknesmvnjnb','2024-10-14 05:01:34.017527',0,1,0,_binary '',1,29,NULL,3),(8,'jdsvbskvnbh',_binary '\0','sdmnvbauieg','2024-10-14 05:03:52.542377',0,1,0,_binary '',1,29,NULL,NULL),(9,'KMASNdjkB',_binary '\0','MNCSDiuasbwfui','2024-10-14 05:10:37.741949',0,1,0,_binary '',1,29,NULL,NULL),(10,'swkjvbswjkbjk',_binary '\0','swnvbvkswnbji','2024-10-14 05:12:12.779580',0,2,0,_binary '',1,29,NULL,NULL),(11,'lskvbsjvbwjn',_binary '\0','lkwenvlkswnvoi','2024-10-14 05:12:51.724331',0,1,0,_binary '',1,29,NULL,NULL),(12,'ksddvkwjb',_binary '\0','bvsdkjvbj','2024-10-14 05:13:54.092135',0,0,0,_binary '',1,29,NULL,NULL),(13,'nbmrnbmwebnbn',_binary '\0',',ms,d vwejbuoqu','2024-10-14 05:18:05.060745',0,1,0,_binary '',1,29,NULL,NULL),(14,'abstracttttttttttttttt',_binary '\0','vgvbk','2024-10-14 10:36:48.196117',0,1,0,_binary '',1,29,NULL,NULL),(15,'Exploring the latest advancements and challenges in renewable energy sources.',_binary '\0','Renewable energy is rapidly transforming the global energy landscape. With technological advancements in solar, wind, and hydropower, the world is steadily moving away from fossil fuels. This post delves into the current trends, key players, and obstacles that need to be overcome to achieve a sustainable future. We\'ll discuss government policies, technological innovations, and the environmental impact of large-scale renewable energy projects.','2024-10-14 11:40:58.065412',0,1,0,_binary '',1,29,NULL,NULL),(16,'asdfasdf',_binary '\0','adsfasdf','2024-11-16 13:03:17.120011',0,1,0,_binary '',1,13,NULL,NULL),(17,'just an idea is about simply putting an idea with no idea to tell.',_binary '\0','we are happy to say that just an idea is all about the factor affecting the life','2024-11-17 10:19:13.310012',0,0,0,_binary '\0',1,13,NULL,1),(18,'Nice to work',_binary '\0','Enoyinig my life here','2024-11-18 20:49:55.130694',0,0,0,_binary '',1,13,NULL,NULL),(19,'Nice to work',_binary '\0','Enoyinig my life here','2024-11-18 20:49:59.992335',0,0,0,_binary '',1,13,NULL,NULL),(20,'Nice to work',_binary '\0','Enoyinig my life here','2024-11-18 20:50:01.303039',0,0,0,_binary '',1,13,NULL,NULL),(21,'Nice to work',_binary '\0','Enoyinig my life here','2024-11-18 20:50:02.968513',0,1,0,_binary '',1,13,NULL,NULL),(22,'Nice to work',_binary '\0','Enoyinig my life here','2024-11-18 20:50:04.491923',0,0,0,_binary '',1,13,NULL,1),(23,'Nice to work',_binary '\0','Enoyinig my life here','2024-11-18 20:50:06.940886',0,1,0,_binary '',1,13,NULL,NULL),(24,'Nice to work',_binary '\0','Enoyinig my life here','2024-11-18 20:50:07.238725',0,0,0,_binary '\0',1,13,NULL,NULL),(25,'Nice to work',_binary '\0','Enoyinig my life here','2024-11-18 20:50:07.428798',0,0,0,_binary '',1,13,NULL,NULL),(26,'Nice to work',_binary '\0','Enoyinig my life here','2024-11-18 20:50:07.617883',0,0,0,_binary '',1,13,NULL,NULL),(27,'Nice to work',_binary '\0','Enoyinig my life here','2024-11-18 20:52:48.177687',0,0,0,_binary '',1,13,NULL,NULL),(28,'eniying',_binary '\0','Helloo just a fake data','2024-11-18 20:55:14.304090',0,0,0,_binary '',1,13,NULL,NULL),(29,'eniying',_binary '\0','Helloo just a fake data','2024-11-18 20:57:41.634754',0,0,0,_binary '',1,13,NULL,NULL),(30,'Enjoying life',_binary '\0','Not that much just dummy data','2024-11-18 21:00:15.097660',0,0,0,_binary '',1,13,NULL,NULL),(31,'Enjoying life',_binary '\0','Not that much just dummy data','2024-11-18 21:00:20.464886',0,0,0,_binary '',1,13,NULL,NULL),(32,'Enjoying life',_binary '\0','Not that much just dummy data','2024-11-18 21:00:38.212736',0,0,0,_binary '',1,13,NULL,NULL),(33,'Enjoying life',_binary '\0','Not that much just dummy data','2024-11-18 21:03:31.825157',0,0,0,_binary '',1,13,NULL,NULL),(34,'Just testing the images',_binary '\0','Nice testing the images','2024-11-18 21:14:17.260042',0,0,0,_binary '',1,13,NULL,NULL),(35,'dummy',_binary '\0','stghfsdfa','2024-11-18 21:16:31.109751',0,0,0,_binary '\0',1,13,NULL,NULL),(36,'asdfasdf',_binary '\0','asdfasdf','2024-11-18 21:18:36.522591',0,0,0,_binary '',1,13,NULL,NULL),(37,'hihihihihihihihi',_binary '\0','heellllooooooooooooo','2024-11-18 22:38:47.209631',0,0,0,_binary '',1,13,NULL,NULL),(38,'hehehhe',_binary '\0','ftftftftf','2024-11-18 22:44:52.066053',0,0,0,_binary '\0',1,13,NULL,NULL),(39,'The renovation of a university building.',_binary '\0','This is the full ideas that how can we earn mony as well as we get more clients and more contacts.',NULL,0,1,0,_binary '',1,29,NULL,NULL),(42,'redevelopment of your society',_binary '\0','Dev Tamakuwala',NULL,0,0,0,_binary '',1,29,NULL,NULL),(43,'urgiait',_binary '\0','i5sitsit',NULL,0,0,0,_binary '',1,29,NULL,NULL),(44,'we\'ll',_binary '\0','all',NULL,0,0,0,_binary '',1,29,NULL,NULL),(45,'all',_binary '\0','ek',NULL,0,0,0,_binary '',1,29,NULL,NULL),(46,'ek',_binary '\0','ek',NULL,0,0,0,_binary '',1,29,NULL,NULL),(47,'ek',_binary '\0','we\'ll',NULL,0,0,0,_binary '',1,29,NULL,NULL),(48,'so',_binary '\0','so',NULL,0,0,0,_binary '',1,29,NULL,NULL);
/*!40000 ALTER TABLE `tbl_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_post_seq`
--

DROP TABLE IF EXISTS `tbl_post_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_post_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_post_seq`
--

LOCK TABLES `tbl_post_seq` WRITE;
/*!40000 ALTER TABLE `tbl_post_seq` DISABLE KEYS */;
INSERT INTO `tbl_post_seq` VALUES (1);
/*!40000 ALTER TABLE `tbl_post_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_query`
--

DROP TABLE IF EXISTS `tbl_query`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_query` (
  `queryId` int NOT NULL AUTO_INCREMENT,
  `dateAndTime` datetime(6) DEFAULT NULL,
  `isAnswer` bit(1) NOT NULL,
  `isSolved` bit(1) NOT NULL,
  `user_id` int NOT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `query` varchar(255) DEFAULT NULL,
  `date_and_time` datetime(6) DEFAULT NULL,
  `is_answer` bit(1) NOT NULL,
  `is_solved` bit(1) NOT NULL,
  PRIMARY KEY (`queryId`),
  KEY `FKce7p93ai89rxcih4vdrj6mwsc` (`user_id`),
  CONSTRAINT `FKce7p93ai89rxcih4vdrj6mwsc` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_query`
--

LOCK TABLES `tbl_query` WRITE;
/*!40000 ALTER TABLE `tbl_query` DISABLE KEYS */;
INSERT INTO `tbl_query` VALUES (1,'2024-11-17 00:30:53.832521',_binary '',_binary '',29,'Sure here is the link by which you can get to know all about our platform.','this is dev tamakuwala, i am having issue with useing this platform can you please share any tutorial video with me please',NULL,_binary '\0',_binary '\0'),(2,'2024-11-17 00:33:06.912999',_binary '',_binary '',6,'Sure here is the link by which you can get to know all about our platform.','i need to invest in your start up can you please share some contact details by which i can contact you and we will proceed.',NULL,_binary '\0',_binary '\0');
/*!40000 ALTER TABLE `tbl_query` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user`
--

DROP TABLE IF EXISTS `tbl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_user` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `DateOfBirth` date DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `contactNo` decimal(38,0) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `visible` tinyint(1) DEFAULT NULL,
  `emailVerified` tinyint(1) DEFAULT NULL,
  `contactNoVerified` tinyint(1) DEFAULT NULL,
  `dateTimeOfRegistration` datetime(6) DEFAULT NULL,
  `noOfConnections` bigint DEFAULT NULL,
  `noOfIdeas` bigint DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `email` (`email`),
  CONSTRAINT `tbl_user_chk_1` CHECK ((`category` in (_utf8mb4'Founder',_utf8mb4'Admin',_utf8mb4'Investor')))
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user`
--

LOCK TABLES `tbl_user` WRITE;
/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
INSERT INTO `tbl_user` VALUES (6,'Aditya','Chudasama','vivek@gmail.com','vivek@123',NULL,'M',9016204659,'Founder',NULL,1,0,0,NULL,1,1),(7,'Dev','Tamakuwala','devtamakuwala438@gmail.com','$2a$12$IIwQ8Jn2qXiZNmYo8pZZLuK68wlmzbE/iKZ4.ZKTEJz9DMV1MtVdm',NULL,'M',9016204659,'Founder',NULL,1,0,0,NULL,2,2),(11,'Sajjad','Mehasania','mehsaniasajjad@gmail.com','$2a$12$GV3QFR.YSXT8waUMVES8POm8jAkGJWA/bM6OYnTe/UuzGSxwg4EKS',NULL,'U',0,'Investor','11.jpg',1,0,0,NULL,1,1),(12,'Dheeraj','Dwiwedi','dheeraj@gmail.com','$2a$12$GV3QFR.YSXT8waUMVES8POm8jAkGJWA/bM6OYnTe/UuzGSxwg4EKS',NULL,'U',0,'Investor',NULL,1,0,0,NULL,0,0),(13,'Philip',' Kuriackal','philipkuriackal@gmail.com','$2a$12$GV3QFR.YSXT8waUMVES8POm8jAkGJWA/bM6OYnTe/UuzGSxwg4EKS',NULL,'M',8547461610,'Founder','13.jpg',1,1,0,NULL,0,20),(29,'Dev','Tamakuwala','devmtamakuwala2424@gmail.com','$2a$12$c1kVHMRpn5AAONsMvaQUXe5FymbbO/31YgQ4i7RpYxalu9KVHzxfu',NULL,'M',9016204659,'Founder','29.jpg',1,1,0,'2024-10-14 00:00:00.000000',5,19),(59,'Jenil','Lad','jenil111@gmail.com','$2a$12$GV3QFR.YSXT8waUMVES8POm8jAkGJWA/bM6OYnTe/UuzGSxwg4EKS',NULL,'U',0,'Founder','59.jpg',1,0,0,'2024-11-24 22:13:08.158433',0,0),(79,'Philip',' B K','philipbkuriackal@gmail.com','securePassword123',NULL,'U',8547461610,'Investor',NULL,1,0,0,'2024-11-29 15:24:05.743211',1,1),(84,'jenil ','lad','jenillad573@gmail.com','$2a$12$AYr5LsTGLUVgNGm6I2EVcuEVTCxqAjuoLBXDSqy1QCO7AzqtU4nra',NULL,'U',0,'Founder',NULL,1,0,0,'2024-11-30 11:24:36.147030',0,NULL),(85,'Bigtable','Connect','bigtableconnect@gmail.com','$2a$12$r2wfctWFRc4vzeLpK.iqKeckwAy2ObAdcIamCEJdk72h.s6hmwsJe',NULL,'U',0,'Founder',NULL,1,0,0,'2025-01-22 14:25:53.077607',0,NULL),(86,'Vivek','Chudasama','chudasamaaditya786@gmail.com','$2a$12$ZGHN.hfiwrksOPRX5JddFegp.U5ELKub2v.4NXVtFQ/yhkP9KtFou',NULL,'U',0,'Founder',NULL,1,0,0,'2025-03-31 17:45:29.718493',0,NULL);
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_payment`
--

DROP TABLE IF EXISTS `user_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_payment` (
  `payment_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`payment_id`,`user_id`),
  KEY `FK3penyolmsa5r2t5n8e4i5984q` (`user_id`),
  CONSTRAINT `FK3penyolmsa5r2t5n8e4i5984q` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`userId`),
  CONSTRAINT `FKpbuanvebgcmg02cql0nwugg86` FOREIGN KEY (`payment_id`) REFERENCES `tbl_payment` (`payment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_payment`
--

LOCK TABLES `user_payment` WRITE;
/*!40000 ALTER TABLE `user_payment` DISABLE KEYS */;
INSERT INTO `user_payment` VALUES (1,11),(2,11),(3,11),(4,11),(5,11),(6,11),(7,11),(8,11),(9,11),(10,11),(11,11),(12,11),(13,11),(14,11),(15,11),(16,11),(17,11),(18,11),(19,11),(20,11),(21,11),(22,11),(23,11),(28,11),(29,11),(30,11),(31,11),(32,11),(33,11),(24,59),(25,59),(26,59),(27,59);
/*!40000 ALTER TABLE `user_payment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-31 18:52:42
