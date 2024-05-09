create database collegeappmanagement;
use collegeappmanagement;
create table collegeapp(
roll_no int primary key,
student_name varchar(30) not null,
attendance_percent int(20),
fees_paid int(30) not null
);
insert into collegeapp(roll_no,student_name,attendance_percent,fees_paid) values(1,"chan",75,50000);
insert into collegeapp(roll_no,student_name,attendance_percent,fees_paid) values(2,"khan",85,60000);
insert into collegeapp(roll_no,student_name,attendance_percent,fees_paid) values(3,"tom",55,40000);
insert into collegeapp(roll_no,student_name,attendance_percent,fees_paid) values(4,"jerry",90,70000);
select * from collegeapp;
update collegeapp set location="dgl" where roll_no=1;
update collegeapp set location="usa" where roll_no=2;
update collegeapp set location="uk" where roll_no=3;
update collegeapp set location="africa" where roll_no=4;
 
alter table collegeapp
drop column location;
alter table collegeapp
add column user_name varchar(30);
update collegeapp set user_name="Chandhuru" where roll_no=1;
update collegeapp set user_name="Chan" where roll_no=2;
update collegeapp set user_name="Khan" where roll_no=3;
update collegeapp set user_name="Rio" where roll_no=4;
update collegeapp set user_name="green" where roll_no=10;
create table admin(
admin_name varchar(20),
admin_password varchar(20)
);
insert into admin (admin_name,admin_password) values("Psna","Psna@1");
select * from admin;