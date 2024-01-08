create table lb_Course (
	courseId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(100) null,
	description VARCHAR(1000) null
);

create table lb_Teacher (
	teacherId LONG not null primary key,
	name VARCHAR(75) null,
	surname VARCHAR(75) null,
	age INTEGER,
	salary DOUBLE
);