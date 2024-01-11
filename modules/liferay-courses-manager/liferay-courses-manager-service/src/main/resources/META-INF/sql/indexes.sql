create index IX_475877FE on lb_Course (companyId);
create index IX_93FAE600 on lb_Course (groupId);
create unique index IX_512C4E29 on lb_Course (name[$COLUMN_LENGTH:100$]);

create index IX_1A136C65 on lb_Lecture (courseId);

create unique index IX_5B451FFE on lb_Teacher (name[$COLUMN_LENGTH:75$]);