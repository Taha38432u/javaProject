create database schoolLab
create table studentInfo
(
	id int identity(1,1) ,
	studentFirstName varchar(30) not null ,
	studentLastName varchar(30) not null,
	dateOfBirth date not null,
	City varchar(30) not null,
	currentAddress varchar(50) not null,
	permanentAddress varchar(50) not null,
	gender VARCHAR(10) CHECK (gender IN ('male', 'female')),
	dateOfAdmission date not null,
	class varchar(10),
	rollNo int unique not null check (rollNo >=1),
	parentFirstName VARCHAR(30) NOT NULL,
    parentLastName VARCHAR(30) NOT NULL,
    profession VARCHAR(50) NOT NULL,
    contactNo1 VARCHAR(20) NOT NULL CHECK (LEN(contactNo1) <= 14), 
    contactNo2 VARCHAR(20) CHECK (LEN(contactNo2) <= 14),
	primary key (rollNo,class)
);
-- drop table studentInfo;

CREATE TABLE teacherInfo (
    id INT PRIMARY KEY IDENTITY(1,1),
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    dateOfBirth DATE NOT NULL,
    City VARCHAR(50) NOT NULL,
    currentAddress VARCHAR(100) NOT NULL,
    Gender VARCHAR(10) CHECK (Gender IN ('Male', 'Female')) NOT NULL,
    contactNo VARCHAR(20) NOT NULL check (len(contactNo ) = 11),
    dateOfJoining DATE NOT NULL,
    currentPosition VARCHAR(50) NOT NULL,
    employeeId INT UNIQUE NOT NULL check (employeeId >=1)
);

create table subjectInfo 
(
	id int identity(1,1) primary key,
	subjectName varchar(40) not null,
	class varchar(10)
);

CREATE TABLE TeacherAttendance (
    id INT PRIMARY KEY IDENTITY(1,1),
    teacherId INT NOT NULL,
    attendanceDate DATE NOT NULL,
    status VARCHAR(10) CHECK (status IN ('P', 'A')) NOT NULL,
    FOREIGN KEY (teacherId) REFERENCES teacherInfo(employeeId)
);

create table studentsFee
(
id int primary key identity (1,1),
studentRollNo int not null,
studentName varchar(40) not null,
studentClass varchar(10) not null,
fee int not null,
FOREIGN KEY (studentRollNo, studentClass) REFERENCES studentInfo (rollNo, class)
);

create table recordsOfFee 
(
	id int primary key identity (1,1),
	studentRollNo int not null,
	studentName varchar(40) not null,
	studentClass varchar(10) not null,
	payDate date , 
	paidOrNot varchar(10) check (paidOrNot in ('Paid','Not Paid')) not null,
	FOREIGN KEY (studentRollNo, studentClass) REFERENCES studentInfo (rollNo, class)
);

-- Table to store student test results


CREATE TABLE Result (
    resultId INT ,
    studentRollNo INT NOT NULL,
    studentClassId VARCHAR(30) NOT NULL,
    subject1Name VARCHAR(50),
    subject1TotalMarks INT,
    subject1ObtainedMarks INT,
    subject2Name VARCHAR(50),
    subject2TotalMarks INT,
    subject2ObtainedMarks INT,
    subject3Name VARCHAR(50),
    subject3TotalMarks INT,
    subject3ObtainedMarks INT,
    subject4Name VARCHAR(50),
    subject4TotalMarks INT,
    subject4ObtainedMarks INT,
    subject5Name VARCHAR(50),
    subject5TotalMarks INT,
    subject5ObtainedMarks INT,
    subject6Name VARCHAR(50),
    subject6TotalMarks INT,
    subject6ObtainedMarks INT,
    subject7Name VARCHAR(50),
    subject7TotalMarks INT,
    subject7ObtainedMarks INT,
    subject8Name VARCHAR(50),
    subject8TotalMarks INT,
    subject8ObtainedMarks INT,
    subject9Name VARCHAR(50),
    subject9TotalMarks INT,
    subject9ObtainedMarks INT,
    subject10Name VARCHAR(50),
    subject10TotalMarks INT,
    subject10ObtainedMarks INT,
	testType varchar(40),
	totalMarks int,
	obtainedMarks int,
	obtainedPercentage int
);
ALTER TABLE Result
ADD CONSTRAINT FK_StudentRollNo FOREIGN KEY (studentRollNo) REFERENCES studentInfo(rollNo);


create table employeeSalary 
(
	id int primary key identity(1,1) not null,
	employeeId int unique not null,
	salary int not null,
	FOREIGN KEY (employeeId) REFERENCES teacherInfo(employeeId)
);
create  table total 
(
	id int  primary key not null identity (1,1),
	totalSalary int not null,
	totalStudents int not null,
	totalFee int not null,
);
create table passwordLogin

(
	id int identity(1,1) primary key,
	passwordAdmin varchar(50) not null,
	userName varchar(50) not null,
	defaultPassword varchar(50) not null 
);


select *from total;
select *from employeeSalary;
select *from Result;
select *from studentInfo;
select *from teacherInfo;
select *from subjectInfo;
select *from TeacherAttendance;
select *from studentsFee;
SELECT * FROM recordsOfFee WHERE studentClass = 'Kg' AND MONTH(payDate) = 04 AND YEAR(payDate) = 2024;



delete from studentInfo 
delete from subjectInfo;
delete from teacherInfo;
delete from total;
delete from result;
delete from employeeSalary;
delete from TeacherAttendance;
delete from studentsFee;
delete from recordsOfFee;



drop table passwordLogin;
insert into passwordLogin values ('riskofrain2','bandit','admin');

select *from passwordLogin;




-----------------------------------------------------------------------------------------------
-- Insertion Records of all tablles
INSERT INTO studentInfo (studentFirstName, studentLastName, dateOfBirth, city, currentAddress, permanentAddress, gender, dateOfAdmission, class, rollNo, parentFirstName, parentLastName, profession, contactNo1, contactNo2)
VALUES
('Muhammad', 'Ahmed', '2008-05-12', 'Karachi', 'Gulshan-e-Iqbal', 'Defence', 'Male', '2022-01-01', '10th', 91, 'Mrs', 'Ahmed', 'Manager', '+923001234567', '+923001234568'),
('Fatima', 'Khan', '2009-08-15', 'Lahore', 'Johar Town', 'Model Town', 'Female', '2022-01-01', '9th', 92, 'Saqlain', 'Khan', 'Lawyer', '+923451234567', '+923451234568'),
('Ali', 'Raza', '2007-03-20', 'Islamabad', 'Government College Road', 'Federal B Area', 'Male', '2022-01-01', '11th', 93, 'Zahra', 'Ali', 'Doctor', '+923341234567', '+923341234568'),
('Ayesha', 'Iqbal', '2006-10-05', 'Faisalabad', 'Gul Round', 'Model Town', 'Female', '2022-01-01', '12th', 94, 'Iqbal', 'Osman', 'Professor', '+923201234567', '+923201234568'),
('Omar', 'Khan', '2009-01-18', 'Quetta', 'Jinnah Road', 'Cantt', 'Male', '2022-01-01', '10th', 95, 'Syed', 'Khan', 'Businessman', '+923101234567', '+923101234568'),
('Zainab', 'Ahmed', '2008-06-30', 'Peshawar', 'Syed Shams Orangzeb Road', 'Johar Town', 'Female', '2022-01-01', '9th', 96, 'Kareem', 'Ahmed', 'Engineer', '+923451234567', '+923451234568'),
('Hassan', 'Rashid', '2007-11-25', 'Rawalpindi', 'Blue Chowk', 'Gulzar', 'Male', '2022-01-01', '11th', 97, 'Rashid', 'Hassan', 'Lawyer', '+923341234567', '+923341234568'),
('Zoha', 'Ali', '2006-02-10', 'Multan', 'Lalaha Rukni', 'Central', 'Female', '2022-01-01', '12th', 98, 'Ali', 'Noor', 'Teacher', '+923201234567', '+923201234568'),
('Abdullah', 'Ahmed', '2009-07-14', 'Sukkur', 'Iqbal Road', 'Shahi Bugh', 'Male', '2022-01-01', '10th', 99, 'Ahmed', 'Mansoor', 'Businessman', '+923101234567', '+923101234568'),
('Maryam', 'Khan', '2008-04-28', 'Hyderabad', 'Jamshoro', 'Foundation', 'Female', '2022-01-01', '9th', 100, 'Khan', 'Abdul Rahman', 'Engineer', '+923451234567', '+923451234568'),
('Ahmed', 'Rizwan', '2007-09-03', 'Sialkot', 'Mall', 'Regiment', 'Male', '2022-01-01', '11th', 101, 'Rizwan', 'Hussain', 'Lawyer', '+923341234567', '+923341234568'),
('Fatima', 'Ali', '2006-01-17', 'Jhelum', 'Punjab College Road', 'City Gate', 'Female', '2022-01-01', '12th', 102, 'Ali', 'Ahmed', 'Teacher', '+923201234567', '+923201234568'),
('Hassan', 'Mohammad', '2009-08-12', 'Rahim Yar Khan', 'Galli Mew', 'Colony', 'Male', '2022-01-01', '10th', 103, 'Mohammad', 'Hassan', 'Teacher', '+923101234567', '+923101234568'),
('Zainab', 'Ahmed', '2008-03-26', 'Bahawalpur', 'Gali', 'Model Town', 'Female', '2022-01-01', '9th', 104, 'Ahmed', 'Waseem', 'Businessman', '+923451234567', '+923451234568'),
('Omar', 'Ali', '2007-12-31', 'Jacobabad', 'Grammar', 'City Gate', 'Male', '2022-01-01', '11th', 105, 'Ali', 'Raheem', 'Lawyer', '+923341234567', '+923341234568'),
('Ali', 'Khan', '2008-09-23', 'Islamabad', 'Blue Area', 'DHA Phase 2', 'Male', '2022-01-01', '10th', 106, 'Kareem', 'Khan', 'Engineer', '+923001234567', '+923001234568'),
('Sara', 'Ahmed', '2009-05-08', 'Karachi', 'Clifton', 'Defence', 'Female', '2022-01-01', '9th', 107, 'Ahmed', 'Nadia', 'Doctor', '+923451234567', '+923451234568'),
('Ahmed', 'Malik', '2007-02-14', 'Lahore', 'Model Town', 'Garden Town', 'Male', '2022-01-01', '11th', 108, 'Khalid', 'Malik', 'Businessman', '+923341234567', '+923341234568'),
('Hira', 'Ali', '2006-11-29', 'Faisalabad', 'Samanabad', 'Gulberg', 'Female', '2022-01-01', '12th', 109, 'Ali', 'Sana', 'Teacher', '+923201234567', '+923201234568'),
('Farhan', 'Khan', '2009-02-03', 'Peshawar', 'University Road', 'Hayatabad', 'Male', '2022-01-01', '10th', 110, 'Aamir', 'Khan', 'Engineer', '+923101234567', '+923101234568'),
('Aisha', 'Iqbal', '2008-07-17', 'Rawalpindi', 'Saddar', 'Cantt', 'Female', '2022-01-01', '9th', 111, 'Hussain', 'Farah', 'Lawyer', '+923451234567', '+923451234568'),
('Usman', 'Ahmed', '2007-04-02', 'Multan', 'Cantt', 'Bosan Road', 'Male', '2022-01-01', '11th', 112, 'Ahmed', 'Fauzia', 'Doctor', '+923341234567', '+923341234568'),
('Ayesha', 'Malik', '2006-12-18', 'Sukkur', 'Station Road', 'Shah Bugh', 'Female', '2022-01-01', '12th', 113, 'Malik', 'Nabeel', 'Businessman', '+923201234567', '+923201234568'),
('Hamza', 'Riaz', '2009-09-13', 'Hyderabad', 'Latifabad', 'Auto Bahn Road', 'Male', '2022-01-01', '10th', 114, 'Riaz', 'Sadia', 'Teacher', '+923101234567', '+923101234568'),
('Amina', 'Ali', '2008-05-28', 'Sialkot', 'Cantonment', 'Defence Road', 'Female', '2022-01-01', '9th', 115, 'Ali', 'Asad', 'Engineer', '+923451234567', '+923451234568'),
('Bilal', 'Khan', '2007-10-12', 'Quetta', 'Airport Road', 'Chaman Housing Scheme', 'Male', '2022-01-01', '11th', 116, 'Tariq', 'Khan', 'Businessman', '+923341234567', '+923341234568'),
('Sadia', 'Hassan', '2006-03-27', 'Peshawar', 'Cavalry Ground', 'University Town', 'Female', '2022-01-01', '12th', 117, 'Hassan', 'Naveed', 'Lawyer', '+923201234567', '+923201234568'),
('Imran', 'Akram', '2009-10-02', 'Gujranwala', 'Civil Lines', 'Model Town', 'Male', '2022-01-01', '10th', 118, 'Akram', 'Fatima', 'Doctor', '+923101234567', '+923101234568'),
('Sana', 'Iqbal', '2008-06-16', 'Sargodha', 'University Road', 'Cantt', 'Female', '2022-01-01', '9th', 119, 'Iqbal', 'Waqas', 'Teacher', '+923451234567', '+923451234568'),
('Waqar', 'Khan', '2007-11-01', 'Larkana', 'City Road', 'Cavalry Ground', 'Male', '2022-01-01', '11th', 120, 'Khan', 'Rabia', 'Engineer', '+923341234567', '+923341234568');

INSERT INTO teacherInfo (firstName, lastName, dateOfBirth, City, currentAddress, Gender, contactNo, dateOfJoining, currentPosition, employeeId)
VALUES
('Ahmed', 'Khan', '1980-05-12', 'Karachi', 'Gulshan-e-Iqbal', 'Male', '03001234567', '2005-01-01', 'Mathematics Teacher', 1),
('Muhammad', 'Ali', '1975-08-15', 'Lahore', 'Johar Town', 'Male', '03451234567', '2006-01-01', 'Physics Teacher', 2),
('Hassan', 'Raza', '1983-03-20', 'Islamabad', 'G-9', 'Male', '03331234567', '2007-01-01', 'English Teacher', 3),
('Imran', 'Iqbal', '1982-10-05', 'Faisalabad', 'Gulberg', 'Male', '03211234567', '2008-01-01', 'Chemistry Teacher', 4),
('Ali', 'Ahmed', '1979-01-18', 'Quetta', 'Jinnah Road', 'Male', '03111234567', '2009-01-01', 'Biology Teacher', 5),
('Usman', 'Khan', '1980-06-30', 'Peshawar', 'University Town', 'Male', '03021234567', '2010-01-01', 'Computer Science Teacher', 6),
('Farhan', 'Rashid', '1977-11-25', 'Rawalpindi', 'Saddar', 'Male', '03341234567', '2011-01-01', 'History Teacher', 7),
('Waqar', 'Ali', '1986-02-10', 'Multan', 'Lalaha Rukni', 'Male', '03221234567', '2012-01-01', 'Geography Teacher', 8),
('Omar', 'Hassan', '1978-07-14', 'Sukkur', 'Iqbal Road', 'Male', '03121234567', '2013-01-01', 'Economics Teacher', 9),
('Aamir', 'Malik', '1985-04-28', 'Hyderabad', 'Jamshoro', 'Male', '03461234567', '2014-01-01', 'Business Studies Teacher', 10),
('Zahid', 'Rizwan', '1984-09-03', 'Sialkot', 'Mall', 'Male', '03351234567', '2015-01-01', 'Urdu Teacher', 11),
('Saad', 'Hussain', '1981-01-17', 'Jhelum', 'Punjab College Road', 'Male', '03031234567', '2016-01-01', 'Islamic Studies Teacher', 12),
('Bilal', 'Abbas', '1984-08-12', 'Rahim Yar Khan', 'Galli Mew', 'Male', '03131234567', '2017-01-01', 'Physical Education Teacher', 13),
('Naveed', 'Waseem', '1983-03-26', 'Bahawalpur', 'Gali', 'Male', '03231234567', '2018-01-01', 'Art Teacher', 14),
('Khalid', 'Rafiq', '1982-12-31', 'Jacobabad', 'Grammar', 'Male', '03361234567', '2019-01-01', 'Music Teacher', 15),
('Abdul', 'Saeed', '1983-09-23', 'Islamabad', 'Blue Area', 'Male', '03041234567', '2020-01-01', 'Drama Teacher', 16),
('Sajid', 'Amin', '1980-05-08', 'Karachi', 'Clifton', 'Male', '03471234567', '2021-01-01', 'Environmental Science Teacher', 17),
('Noman', 'Tariq', '1977-02-14', 'Lahore', 'Model Town', 'Male', '03151234567', '2022-01-01', 'Psychology Teacher', 18),
('Tahir', 'Aslam', '1986-11-29', 'Faisalabad', 'Samanabad', 'Male', '03241234567', '2023-01-01', 'Sociology Teacher', 19),
('Ali', 'Akhtar', '1982-02-03', 'Peshawar', 'University Road', 'Male', '03371234567', '2024-01-01', 'Political Science Teacher', 20);

INSERT INTO subjectInfo (subjectName, class) VALUES 
('Mathematics', '10th'),
('Physics', '10th'),
('Chemistry', '10th'),
('Biology', '10th'),
('English', '10th');

INSERT INTO TeacherAttendance (teacherId, attendanceDate, status)
SELECT id, CONVERT(DATE, GETDATE()), 'P'
FROM teacherInfo;

INSERT INTO studentsFee (studentRollNo, studentName, studentClass, fee)
VALUES
(91, 'Muhammad Ahmed', '10th', 5000),
(92, 'Fatima Khan', '9th', 5500),
(93, 'Ali Raza', '11th', 6000),
(94, 'Ayesha Iqbal', '12th', 6500),
(95, 'Omar Khan', '10th', 5000),
(96, 'Zainab Ahmed', '9th', 5500),
(97, 'Hassan Rashid', '11th', 6000),
(98, 'Zoha Ali', '12th', 6500),
(99, 'Abdullah Ahmed', '10th', 5000),
(100, 'Maryam Khan', '9th', 5500),
(101, 'Ahmed Rizwan', '11th', 6000),
(102, 'Fatima Ali', '12th', 6500),
(103, 'Hassan Mohammad', '10th', 5000),
(104, 'Zainab Ahmed', '9th', 5500),
(105, 'Omar Ali', '11th', 6000),
(106, 'Ali Khan', '10th', 5000),
(107, 'Sara Ahmed', '9th', 5500),
(108, 'Ahmed Malik', '11th', 6000),
(109, 'Hira Ali', '12th', 6500),
(110, 'Farhan Khan', '10th', 5000),
(111, 'Aisha Iqbal', '9th', 5500),
(112, 'Usman Ahmed', '11th', 6000),
(113, 'Ayesha Malik', '12th', 6500),
(114, 'Hamza Riaz', '10th', 5000),
(115, 'Amina Ali', '9th', 5500),
(116, 'Bilal Khan', '11th', 6000),
(117, 'Sadia Hassan', '12th', 6500),
(118, 'Imran Akram', '10th', 5000),
(119, 'Sana Iqbal', '9th', 5500),
(120, 'Waqar Khan', '11th', 6000);


