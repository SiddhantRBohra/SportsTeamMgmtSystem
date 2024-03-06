-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.33-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema sports_db
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ sports_db;
USE sports_db;

--
-- Table structure for table `sports_db`.`coach_details`
--

DROP TABLE IF EXISTS `coach_details`;
CREATE TABLE `coach_details` (
  `coach_id` int(11) NOT NULL AUTO_INCREMENT,
  `FIRSTNAME` varchar(50) DEFAULT NULL,
  `LASTNAME` varchar(50) DEFAULT NULL,
  `CONTACT_NUMBER` varchar(50) DEFAULT NULL,
  `SPORT` varchar(50) DEFAULT NULL,
  `GENDER` varchar(10) DEFAULT NULL,
  `EMAIL_ID` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`coach_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sports_db`.`coach_details`
--

/*!40000 ALTER TABLE `coach_details` DISABLE KEYS */;
INSERT INTO `coach_details` (`coach_id`,`FIRSTNAME`,`LASTNAME`,`CONTACT_NUMBER`,`SPORT`,`GENDER`,`EMAIL_ID`) VALUES 
 (1,'sam','lee','1231231231','Football','Male','sam@gmail.com');
/*!40000 ALTER TABLE `coach_details` ENABLE KEYS */;


--
-- Table structure for table `sports_db`.`fixture_details`
--

DROP TABLE IF EXISTS `fixture_details`;
CREATE TABLE `fixture_details` (
  `FIXTURE_ID` int(11) NOT NULL,
  `FIXTURE_NAME` varchar(50) DEFAULT NULL,
  `DATE` date DEFAULT NULL,
  `ORGANISATION` varchar(50) DEFAULT NULL,
  `SPORT` varchar(50) DEFAULT NULL,
  `VENUE` varchar(50) DEFAULT NULL,
  `AGE_GROUP` varchar(50) DEFAULT NULL,
  `GENDER` varchar(10) DEFAULT NULL,
  `DEPARTURE_TIME` varchar(30) DEFAULT NULL,
  `GAMESTART_TIME` varchar(30) DEFAULT NULL,
  `RETURN_TIME` varchar(30) DEFAULT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  `COACH_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`FIXTURE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sports_db`.`fixture_details`
--

/*!40000 ALTER TABLE `fixture_details` DISABLE KEYS */;
INSERT INTO `fixture_details` (`FIXTURE_ID`,`FIXTURE_NAME`,`DATE`,`ORGANISATION`,`SPORT`,`VENUE`,`AGE_GROUP`,`GENDER`,`DEPARTURE_TIME`,`GAMESTART_TIME`,`RETURN_TIME`,`DESCRIPTION`,`COACH_ID`) VALUES 
 (883,'sample fixture1','2024-01-26','HKSSF','Football','cc','U14','Female','9:00 am','10:00am','12:00nn','xc x',1);
/*!40000 ALTER TABLE `fixture_details` ENABLE KEYS */;


--
-- Table structure for table `sports_db`.`login_details`
--

DROP TABLE IF EXISTS `login_details`;
CREATE TABLE `login_details` (
  `EMAIL` varchar(50) NOT NULL,
  `FIRSTNAME` varchar(50) DEFAULT NULL,
  `LASTNAME` varchar(50) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `CATEGORY` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sports_db`.`login_details`
--

/*!40000 ALTER TABLE `login_details` DISABLE KEYS */;
INSERT INTO `login_details` (`EMAIL`,`FIRSTNAME`,`LASTNAME`,`password`,`CATEGORY`) VALUES 
 ('sam@gmail.com','sam','lee','sam','Coach'),
 ('test1@gmail.com','test1','1','1','Student'),
 ('test2@gmail.com','test2','2','2','Student'),
 ('test3@gmail.com','test3','3','3','Student');
/*!40000 ALTER TABLE `login_details` ENABLE KEYS */;


--
-- Table structure for table `sports_db`.`parentalconsent_details`
--

DROP TABLE IF EXISTS `parentalconsent_details`;
CREATE TABLE `parentalconsent_details` (
  `FIXTUREID` int(11) DEFAULT NULL,
  `ACKNOWLEDGEMENT_MSG` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sports_db`.`parentalconsent_details`
--

/*!40000 ALTER TABLE `parentalconsent_details` DISABLE KEYS */;
INSERT INTO `parentalconsent_details` (`FIXTUREID`,`ACKNOWLEDGEMENT_MSG`) VALUES 
 (883,'I, the undersigned parent/guardian, hereby grant permission for my child, \nnamed above, to participate in the specified football activities organized by school\nI confirm that my child is in good health and physical condition to engage in football-related activities\n');
/*!40000 ALTER TABLE `parentalconsent_details` ENABLE KEYS */;


--
-- Table structure for table `sports_db`.`participant_details`
--

DROP TABLE IF EXISTS `participant_details`;
CREATE TABLE `participant_details` (
  `student_id` int(11) DEFAULT NULL,
  `fixture_id` int(11) DEFAULT NULL,
  `coach_id` int(11) DEFAULT NULL,
  `studentavailability_status` varchar(40) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sports_db`.`participant_details`
--

/*!40000 ALTER TABLE `participant_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `participant_details` ENABLE KEYS */;


--
-- Table structure for table `sports_db`.`student_details`
--

DROP TABLE IF EXISTS `student_details`;
CREATE TABLE `student_details` (
  `student_id` int(11) NOT NULL,
  `firstname` varchar(40) DEFAULT NULL,
  `lastname` varchar(40) DEFAULT NULL,
  `grade` varchar(30) DEFAULT NULL,
  `house` varchar(30) DEFAULT NULL,
  `tutorname` varchar(40) DEFAULT NULL,
  `email_id` varchar(50) DEFAULT NULL,
  `sport` varchar(50) DEFAULT NULL,
  `agegroup` varchar(10) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `coach_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sports_db`.`student_details`
--

/*!40000 ALTER TABLE `student_details` DISABLE KEYS */;
INSERT INTO `student_details` (`student_id`,`firstname`,`lastname`,`grade`,`house`,`tutorname`,`email_id`,`sport`,`agegroup`,`gender`,`coach_id`) VALUES 
 (1,'test1','1','Year 10','Nansen','tuotoe','test1@gmail.com','Football','U14','Female',1),
 (2,'test2','2','Year 9','Nansen','wew','test2@gmail.com','Football','U14','Female',1),
 (3,'test3','3','Year 9','Nansen','gfh','test3@gmail.com','Football','U14','Female',1);
/*!40000 ALTER TABLE `student_details` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
