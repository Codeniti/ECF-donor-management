-- phpMyAdmin SQL Dump
-- version 3.3.2deb1ubuntu1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 01, 2014 at 07:15 PM
-- Server version: 5.1.73
-- PHP Version: 5.3.2-1ubuntu4.22

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ecf`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `name` varchar(233) DEFAULT NULL,
  `password` varchar(244) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`name`, `password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `donors`
--

CREATE TABLE IF NOT EXISTS `donors` (
  `id` int(122) NOT NULL AUTO_INCREMENT,
  `fname` varchar(232) DEFAULT NULL,
  `lname` varchar(232) DEFAULT NULL,
  `address` varchar(233) DEFAULT NULL,
  `city` varchar(23) DEFAULT NULL,
  `state` varchar(234) DEFAULT NULL,
  `pcode` varchar(222) DEFAULT NULL,
  `country` varchar(123) DEFAULT NULL,
  `email` varchar(233) DEFAULT NULL,
  `mob` int(122) DEFAULT NULL,
  `dtype` varchar(233) DEFAULT NULL,
  `amt` int(233) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `donors`
--

INSERT INTO `donors` (`id`, `fname`, `lname`, `address`, `city`, `state`, `pcode`, `country`, `email`, `mob`, `dtype`, `amt`) VALUES
(5, 'zainul', 'sayyed', 'mumbai', 'mumbai', 'maharashtra', '400612', 'india', 'zainul.sayed28@gmail.com', 2147483647, 'regular', 3444),
(6, 'majud', 'sir', 'mumbai', 'mumbai', 'maharashtra', '400612', 'india', 'zainul.sayed28@gmail.com', 2147483647, 'regular', 3444);
