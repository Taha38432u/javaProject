create database school
create table studentInfo
(
	id int identity(1,1) primary key,
	studentFirstName varchar(30) not null ,
	studentLastName varchar(30) not null,
	dateOfBirth date not null,
	City varchar(30) not null,
	currentAddress varchar(50) not null,
	permanentAddress varchar(50) not null,
	gender VARCHAR(10) CHECK (gender IN ('male', 'female')),
	dateOfAdmission date not null,
	class varchar(10),
	rollNo int not null,
	parentFirstName VARCHAR(30) NOT NULL,
    parentLastName VARCHAR(30) NOT NULL,
    profession VARCHAR(50) NOT NULL,
    contactNo1 VARCHAR(20) NOT NULL,
    contactNo2 VARCHAR(20),
); 

CREATE TABLE teacherInfo (
    id INT PRIMARY KEY IDENTITY(1,1),
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    dateOfBirth DATE NOT NULL,
    City VARCHAR(50) NOT NULL,
    currentAddress VARCHAR(100) NOT NULL,
    Gender VARCHAR(10) CHECK (Gender IN ('Male', 'Female')) NOT NULL,
    contactNo VARCHAR(20) NOT NULL,
    dateOfJoining DATE NOT NULL,
    currentPosition VARCHAR(50) NOT NULL,
    employeeId INT UNIQUE NOT NULL
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
);
create table recordsOfFee 
(
	id int primary key identity (1,1),
	studentRollNo int not null,
	studentName varchar(40) not null,
	studentClass varchar(10) not null,
	payDate date , 
	paidOrNot varchar(10) check (paidOrNot in ('Paid','Not Paid')) not null,
);

-- Table to store student test results




drop table studentFee;
delete from studentInfo 
select *from studentInfo;

select *from teacherInfo;

delete from subjectInfo;
insert into subjectInfo values ('math','Kg');
select *from subjectInfo;

select *from TeacherAttendance;
select *from studentsFee;
select *from recordsOfFee;

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

select *from Result;
drop table Result;

