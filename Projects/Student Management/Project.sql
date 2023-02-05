create table STUDENTS(REG_NO number(3)primary key, NAME varchar(35), AGE number(2), STANDARD number(2), SCHOOL varchar(40));

create table SUBJECTS(REG_NO number(3), ENGLISH number(3),HINDI number(3),MATHS number(3),SCIENCE number(3),SOCIAL_SCIENCE number(3), 
foreign key(REG_NO) references STUDENTS(reg_no));
