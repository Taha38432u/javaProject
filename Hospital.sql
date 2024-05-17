create database Hospital
create table Patient 
(
	patientId int not null,
	firstName varchar(30) not null,
	lastName varchar(30) not null,
	Gender   varchar(6) not null,
	DateOfBirth varchar(40) not null,
	contactNumber nchar(14) not null,
);

create table Doctors 
( 
	doctorId int not null,
	firstName varchar(30) not null,
	lastName varchar(30) not null,
	specialization varchar(30) not null,
	contactNumber nchar(14) not null,
);

create table Nurses 
(
	nurseId int not null,
	firstName varchar(30) not null,
	lastName varchar(30) not null,
	Shifts  varchar(10) not null,
	contactNumber nchar(14) not null,
);
create table Departments 
(
	departmentId int not null,
	departmentName varchar(40) not null,
	headDoctorId int not null,
);

create table Appointments 
(
	appointmentId int not null,
	patientId int not null,
	doctorId int not null,
	appointmentDate varchar(30) not null,
	appointmentTime varchar(30) not null,
);
create table ward 
(
	wardId int not null,
	wardNo int not null,
);
insert into  ward  values (1,22)
insert into  ward values (2,33);


--Alter Commands
alter table Departments add  dep_Floor varchar(30);
alter table Appointments drop column appointmentTime
alter table Doctors alter column firstName varchar(40);

alter table Doctors add primary key(doctorId);
alter table Appointments add primary key(appointmentId);
alter table Departments add primary key (departmentId);
alter table Patient add primary key (patientId);

ALTER TABLE Patient ADD FOREIGN KEY (doctorId) REFERENCES Doctors(doctorId); 

ALTER TABLE Doctors DROP CONSTRAINT doctorId;
ALTER TABLE Doctors ADD CONSTRAINT PK_Doctors_id PRIMARY KEY (id);
ALTER TABLE Orders ADD CONSTRAINT FK_PersonOrder FOREIGN KEY (PersonID) REFERENCES Persons(PersonID); 
ALTER TABLE Orders DROP CONSTRAINT FK_PersonOrder; 
ALTER TABLE Persons ADD CONSTRAINT UC_Person UNIQUE (ID,LastName); 
ALTER TABLE Persons DROP CONSTRAINT UC_Person; 

ALTER TABLE Doctors ADD CONSTRAINT UC_Person check(contactNumber>2);
ALTER TABLE Doctors drop CONSTRAINT UC_Person;

ALTER TABLE Doctors ADD CONSTRAINT DF_Doctors_Specialization DEFAULT ('General') FOR specialization;
ALTER TABLE Doctors DROP CONSTRAINT IF EXISTS DF_Doctors_Specialization;





-- Data Manipulation Language , Insert, Update , Delete


-- Patient Record
-- This method only if you know the sequence of your attributes, Minimum one value
insert into  Patient values (1,'Taha','Rasheed','Male','1-30-24','12345')
insert into  Patient values (3,'Akhter','Taha','Male','1-29-24','12345')
insert into  Patient values (4,'Kaif','Taha','Male','1-28-24','12345')
insert into  Patient values (5,'Saqlain','Taha','Male','1-27-24','12345')
--Another method where sequence does not matter 
insert into Patient (firstName,patientId,lastName,Gender,DateOfBirth,contactNumber) values ('Raheem',2,'Taha','Male','In the age of dragons',
'146')
select *from Patient


-- Nurses Record
insert into Nurses values (1,'Xyz','CH','Morning','123')
insert into Nurses values (1,'abc','CH','Morning','123')
insert into Nurses values (1,'efg','CH','Morning','123')
insert into Nurses values (1,'hij','CH','Morning','123')
insert into Nurses values (1,'klm','CH','Morning','123')


--Doctors
insert into Doctors values (1,'Kashif','Ali','Ralugata','200'),
(2,'Kaif','Ali','Ralugata','300'),
(3,'Akhter','Lava','Ralugata','325'),
(4,'Saqlian','Khan','Ralugata','400'),
(5,'Hassan','Tayyab','Ralugata','500')
select *from Doctors

--Departments 
insert into Departments values (1,'fullStack','11','Third'),
(2,'Andriod Stack','12','Third'),
(3,' Devops','13','Third'),
(4,'Ai','14','Third'),
(5,'Web','15','Third')
select *from Departments

--Appointments
insert into Appointments values (1,11,12,'13 March')
insert into Appointments values (2,11,12,'13 March')
insert into Appointments values (3,11,12,'13 March')
insert into Appointments values (4,11,12,'13 March')
insert into Appointments values (5,11,12,'13 March')
select *from Appointments

insert into Appointments (Appointmens.

--Select
select patientId,firstName  from Patient
-- When you dont know the column names it will give suggestion after . operator
select Patient.firstName,Patient.DateOfBirth from Patient

select *from Patient where firstName = 'Saqlain' or lastName='Rasheed'
select  patientId,firstName from Patient where lastName = 'Rasheed'


--Update

update Nurses set nurseId = 2 where firstName = 'abc'
update Nurses set nurseId = 3 where firstName = 'efg'
update Nurses set nurseId = 4 where firstName = 'hij'
update Nurses set nurseId = 5 where firstName = 'klm'


select *from Doctors
select top 2 * from Doctors
-- Like
select * from Doctors where firstName like 'K%';
select * from Doctors where firstName like '%f';
select * from Doctors where firstName like 'A%r';
select * from Doctors where firstName like '%s%';

-- Wildcards

SELECT * FROM Doctors WHERE firstName LIKE 'A_%f';



-- Aggregrated Functions
-- These functions will only work on numeric values
select min(doctorId) from Doctors;
select max(doctorId) from Doctors;
SELECT COUNT(doctorId) FROM Doctors;
SELECT SUM(doctorId) FROM Doctors;
SELECT AVG(doctorId) FROM Doctors;


-- Select Disnict
SELECT DISTINCT departmentName FROM Departments;
SELECT firstName FROM Patient ORDER BY firstName ASC;
SELECT firstName, lastName FROM Patient ORDER BY lastName ASC, firstName DESC;
SELECT * FROM Patient WHERE contactNumber IS NULL;

-- Select all whose name contains a
SELECT * FROM Patient WHERE firstName LIKE '%a%';

-- Retrieve patients whose doctorId matches any doctorId in the Doctors table with specialization 'Cardiology':

CREATE TABLE Orders (
    OrderID int NOT NULL PRIMARY KEY,
    OrderNumber int default 2,
    -- doctorId int FOREIGN KEY REFERENCES Doctors(doctorId)
); 


-- Delete
delete from Doctors;
drop database onlineBookStore;
drop table Departments;


SELECT TOP 3 * FROM Doctors;

--event

CREATE TABLE SampleEventTable (
    id INT PRIMARY KEY IDENTITY(1,1),
    event_description VARCHAR(255),
    event_date DATETIME
);


-- In and Between

select *from Doctors
select *from Patient
select *from Doctors where contactNumber between 200 and 300

select *from Doctors where firstName = 'Kaif' or firstName = 'Kashif'  
select *from Doctors where firstName in ('Kaif','Kashif')


-- joins


-- inner join = displays common data 
select *from Doctors inner join Patient on 
Doctors.doctorId = Patient.patientId;
select *from Doctors full outer join ward on 
Doctors.doctorId = ward.wardId;

-- outer join
select *from Doctors left outer join Patient on 
Doctors.firstName = Patient.firstName;

select *from Doctors right outer join Patient on 
Doctors.firstName = Patient.firstName;

-- I ave
select *from Doctors full outer join ward on 
Doctors.doctorId = ward.wardId;


-- view
-- It is an virtual table
create view selection_data 
as
select *from Patient where contactNumber>500
select *from [selection_data]

-- View for Patient table
CREATE VIEW NonSensitivePatientView
AS
SELECT
    patientId, 
    firstName,
    lastName,
    Gender ,
    DateOfBirth from Patient;

-- View for Doctors table
CREATE VIEW NonSensitiveDoctorsView
AS
SELECT
    doctorId AS DoctorID,
    firstName AS DoctorFirstName,
    lastName AS DoctorLastName,
    specialization AS DoctorSpecialization
FROM Doctors;

-- View for Nurses table
CREATE VIEW NonSensitiveNursesView
AS
SELECT
    nurseId AS NurseID,
    firstName AS NurseFirstName,
    lastName AS NurseLastName,
    Shifts AS NurseShifts
FROM Nurses;

-- View for Departments table
CREATE VIEW NonSensitiveDepartmentsView
AS
SELECT
    departmentId AS DepartmentID,
    departmentName AS DepartmentName,
    headDoctorId AS DepartmentHeadDoctorID
FROM Departments;

-- View for Appointments table
CREATE VIEW NonSensitiveAppointmentsView
AS
SELECT
    appointmentId AS AppointmentID,
    patientId AS PatientID,
    doctorId AS DoctorID,
    appointmentDate AS AppointmentDate
FROM Appointments;



-- Display data from NonSensitivePatientView
SELECT * FROM NonSensitivePatientView;

-- Display data from NonSensitiveDoctorsView
SELECT * FROM NonSensitiveDoctorsView;

-- Display data from NonSensitiveNursesView
SELECT * FROM NonSensitiveNursesView;

-- Display data from NonSensitiveDepartmentsView
SELECT * FROM NonSensitiveDepartmentsView;

-- Display data from NonSensitiveAppointmentsView
SELECT * FROM NonSensitiveAppointmentsView;

---------------------------------------------------------------------------------------------------------------------------
	create table studentsTable
	(
		studentId int not null primary key,
		studentName varchar(40) not null ,
		fatherName varchar(40) not null,
		contact varchar(30) not null,
		gender varchar(5) not null
	);

	create table classTable 
	(
		classId varchar(5) not null primary key,
		className varchar(30) not null,
		semester varchar(10) not null,
	);

	create table enrollmentTable 
	(
		studentId int not null,
		classId  varchar(4) not null,
		fee int not null,
		discount int not null
	);


	insert into studentsTable values (1,'Ali','Afzal','030000','M'),
	(2,'Maryam','Nawaz','01111','F'),
	(3,'Usman','Khalid','032222','M'),
	(4,'Zain','Ali','03333','M'),
	(5,'Noor','Arshad','034444','F');


	insert into classTable values ('A','Database System','4th'),
	('B','OOP','2nd'),
	('C','Data Structure','3rd'),
	('D','Computer Networks','5th'),
	('E','Programming fund','1st');

									
	insert into enrollmentTable values (1,'A',17500,0),
	(1,'D',21999,999),
	(3,'A',17500,0),
	(2,'B',27000,2000),
	(5,'C',15500,500);

------------------------------------------------------------------------------------------------------------

-- joins


-- inner join = displays common data 
select *from Doctors inner join Patient on 
Doctors.doctorId = Patient.patientId;
select *from Doctors full outer join ward on 
Doctors.doctorId = ward.wardId;

-- outer join
select *from Doctors left outer join Patient on 
Doctors.firstName = Patient.firstName;

select *from Doctors right outer join Patient on 
Doctors.firstName = Patient.firstName;

-- I ave
select *from Doctors full outer join ward on 
Doctors.doctorId = ward.wardId;

-- Task 1
select studentsTable.studentId, studentsTable.studentName, classTable.classId, classTable.className from  studentsTable inner join enrollmentTable on 
studentsTable.studentId = enrollmentTable.studentId inner join classTable on enrollmentTable.classId = classTable.classId;


-- Task 2
SELECT c.classId, c.className, c.semester, s.studentId, s.studentName
FROM classTable c
LEFT JOIN enrollmentTable e ON c.classId = e.classId
LEFT JOIN studentsTable s ON e.studentId = s.studentId;

-- task 3

SELECT 
    s.studentName,
    c.className,
    IIF(e.studentId IS NOT NULL, 'Enrolled', 'Not Enrolled') AS enrollmentStatus
FROM 
    classTable c
LEFT JOIN
    enrollmentTable e ON c.classId = e.classId
LEFT JOIN
    studentsTable s ON e.studentId = s.studentId;

	------------------------------------------------------------ Trigger---------------------------------------------------------------------
	create trigger displayMsgOnInsert on Doctors for insert as
	begin
	print('data inserted successfully')
	select *from Doctors
	end

	CREATE TABLE employees 
	(
      id INT PRIMARY KEY,
	  name VARCHAR(50),
      contact VARCHAR(100)
	);
	insert into employees values (1,'taha','taha house');
	update employees set name = 'taha' where id = 1;
	drop table employees;



CREATE TRIGGER displayMsg ON employees AFTER 
UPDATE AS BEGIN IF UPDATE(name) BEGIN UPDATE employees SET contact = i.name FROM employees INNER JOIN inserted i ON employees.id = i.id; END; SELECT * FROM employees; END;


CREATE TRIGGER displayMsg on employees after update as 
BEGIN
    IF UPDATE(name)
    BEGIN
        UPDATE employees
        SET contact = (SELECT name FROM inserted WHERE employees.id = inserted.id)
    END;
    SELECT * FROM employees; -- Display the updated employees table
END;

---------------------------------------------------------------------------------------------- task 2

create table employeeData 
(
    id INT PRIMARY KEY,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    email VARCHAR(100),
    phoneNo VARCHAR(20),
    hireDate DATE,
    jobTitle VARCHAR(50),
    departmentId INT,
    salary DECIMAL(10, 2),
    managerId INT
);
INSERT INTO employeeData(id, firstName, lastName, email, phoneNo, hireDate, jobTitle, departmentId, salary, managerId)
VALUES
(1, 'Taha', 'Rasheed', 'taha@example.com', '555-1234', '2022-01-01', 'Manager', 1, 80000.00, NULL),
(2, 'Babar', 'Azam', 'Babar@example.com', '555-5678', '2022-02-15', 'Engineer', 1, 60000.00, 1);
update employeeData set salary = 900000 where id = 2;
select *from employeeData;

CREATE TRIGGER PromoteEmployee ON employeeData AFTER INSERT, UPDATE AS
BEGIN
    -- Update the job title of employees whose salary exceeds $80,000
    UPDATE employeeData
    SET jobTitle = 'Senior'
    WHERE salary >= 80000
    AND id in (SELECT id FROM inserted);
END;

select *from employeeData;
drop trigger PromoteEmployee

--------------------------------------------------------------------------------------------------------------------------------------------------

select *from employeeData where exists
(select *from employeeData where salary = 2000);

select *from employeeData where Salary > all
(select salary from employeeData where salary>=5000);

select *from employeeData where Salary > any
(select salary from employeeData where salary>=5000);

------- Group By and Having By 
------- Union and Intersection     
------------------------------------------------------ Function and procedure -------------------------------------------------------

-- Everything that has been created by CREATE command can only be drop by the DROP command and is edit by ALTER command

create function functionSum (@num1 int , @num2 int)
returns int
as  -- jahan pe (as) a jye wahan pe ap ki mrzi chlti he
begin  --jb hm sub querey use krte he tb use krete hn
return @num1 + @num2
end
	
select dbo.functionSum(10,15) as result;


-- Define the function to return employee data based on ID
CREATE FUNCTION showSalary (@id int)
RETURNS TABLE
AS 
RETURN (
    SELECT *
    FROM employeeData
    WHERE id = @id
);

-- Call the function and select data from it
SELECT *
FROM dbo.showSalary(1);

-- Declare and use the variable
-- Declare and use the variable
DECLARE @xyz VARCHAR(50);
DECLARE @testing VARCHAR(100); -- Declare the variable within the same batch
SET @testing = (SELECT firstName FROM dbo.showSalary(1));

-- Check if @testing is NULL and assign a value to @xyz accordingly
IF @testing IS NULL
    SET @xyz = 'unknown';
ELSE
    SET @xyz = @testing;

PRINT 'Your position is ' + ISNULL(@xyz, 'unknown');




  ------------------------ Procedure --------------------------
  create procedure showSalaryProcedure 
  @id int
  as
  begin
  select *from employeeData where id = @id;
  end;

  exec showSalaryProcedure @id = 1;


