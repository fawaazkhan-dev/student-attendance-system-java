-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 12, 2022 at 07:43 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `attendance`
--

-- --------------------------------------------------------

--
-- Table structure for table `absents`
--

CREATE TABLE `absents` (
  `Firstname` varchar(25) NOT NULL,
  `Lastname` varchar(25) NOT NULL,
  `No_of_Absents` int(25) NOT NULL,
  `Module` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `absents`
--

INSERT INTO `absents` (`Firstname`, `Lastname`, `No_of_Absents`, `Module`) VALUES
('segaren', 'cooroopdoss', 3, 'oot'),
('sahil ', 'panchoo', 4, 'oot'),
('fawaaz ', 'khan', 3, 'os'),
('atish  ', 'shamboo', 3, 'os'),
('david ', 'degea', 0, 'os');

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(10) NOT NULL,
  `username` varchar(25) NOT NULL,
  `firstname` varchar(25) NOT NULL,
  `lastname` varchar(25) NOT NULL,
  `password` varchar(30) NOT NULL,
  `gender` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `username`, `firstname`, `lastname`, `password`, `gender`) VALUES
(1, 'admin', 'tom', 'jherry', '1234', 'male');

-- --------------------------------------------------------

--
-- Table structure for table `allstudents`
--

CREATE TABLE `allstudents` (
  `Name` varchar(25) NOT NULL,
  `Module` varchar(25) NOT NULL,
  `Date` varchar(25) NOT NULL,
  `Attendance` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `allstudents`
--

INSERT INTO `allstudents` (`Name`, `Module`, `Date`, `Attendance`) VALUES
('segaren', 'os', '8/07/2022', 0),
('segaren', 'oot', '9/07/2022', 0),
('segaren', 'os', '10/07/2022', 1),
('segaren', 'os', '11/07/2022', 0),
('segaren', 'oot', '12/07/2022', 1),
('sahil', 'os', '8/07/2022', 0),
('sahil', 'oot', '9/07/2022', 0),
('sahil', 'os', '10/07/2022', 0),
('sahil', 'os', '11/07/2022', 0),
('sahil', 'oot', '12/07/2022', 1),
('fawaaz', 'os', '8/07/2022', 1),
('fawaaz', 'oot', '9/07/2022', 1),
('fawaaz', 'os', '10/07/2022', 1),
('fawaaz', 'os', '11/07/2022', 0),
('fawaaz', 'oot', '12/07/2022', 0),
('atish', 'os', '8/07/2022', 0),
('atish', 'oot', '9/07/2022', 0),
('atish', 'os', '10/07/2022', 1),
('atish', 'os', '11/07/2022', 1),
('atish', 'oot', '12/07/2022', 1);

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `date` varchar(25) NOT NULL,
  `couse_code` varchar(25) NOT NULL,
  `lecturer_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `present` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `course_code` varchar(25) NOT NULL,
  `course_name` varchar(25) NOT NULL,
  `year_introduce` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `lecturer`
--

CREATE TABLE `lecturer` (
  `Lecturer_id` int(11) NOT NULL,
  `Name` varchar(25) NOT NULL,
  `Username` varchar(25) NOT NULL,
  `Password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lecturer`
--

INSERT INTO `lecturer` (`Lecturer_id`, `Name`, `Username`, `Password`) VALUES
(1, 'smith', 'smith', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `lecturer_course`
--

CREATE TABLE `lecturer_course` (
  `lecturer-id` int(11) NOT NULL,
  `course_code` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `ID` int(10) NOT NULL,
  `Name` varchar(25) NOT NULL,
  `Contact` varchar(25) NOT NULL,
  `Course` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`ID`, `Name`, `Contact`, `Course`) VALUES
(1, 'segaren cooroopdoss', '59270745', 'os'),
(2, 'sahil panchoo', '59270746', 'os'),
(3, 'fawaaz khan', '59270749', 'os'),
(4, 'atish shamboo', '59260745', 'os'),
(5, 'Zuhayr Ameerbeg', '57270745', 'os'),
(6, 'tom jerry', '59270748', 'oot'),
(7, 'david degea', '57270746', 'oot'),
(8, 'david copperfield', '59270749', 'oot'),
(9, ' Micheal Jackson ', '59285745', 'oot'),
(10, 'mia volka', '57680745', 'oot');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`date`,`couse_code`,`student_id`),
  ADD KEY `attendance_ibfk_1` (`couse_code`),
  ADD KEY `student_id` (`student_id`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`course_code`);

--
-- Indexes for table `lecturer`
--
ALTER TABLE `lecturer`
  ADD PRIMARY KEY (`Lecturer_id`);

--
-- Indexes for table `lecturer_course`
--
ALTER TABLE `lecturer_course`
  ADD PRIMARY KEY (`lecturer-id`,`course_code`),
  ADD KEY `course_code` (`course_code`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `lecturer`
--
ALTER TABLE `lecturer`
  MODIFY `Lecturer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=667;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8976;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `attendance`
--
ALTER TABLE `attendance`
  ADD CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`couse_code`) REFERENCES `course` (`course_code`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `attendance_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `lecturer_course`
--
ALTER TABLE `lecturer_course`
  ADD CONSTRAINT `lecturer_course_ibfk_1` FOREIGN KEY (`lecturer-id`) REFERENCES `lecturer` (`Lecturer_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `lecturer_course_ibfk_2` FOREIGN KEY (`course_code`) REFERENCES `course` (`course_code`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
