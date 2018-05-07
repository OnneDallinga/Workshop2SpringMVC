create table if not exists account (
	id bigint not null,
	username varchar(25) not null,
	encryptedpassword varchar(50) not null,
	enabled bit DEFAULT 1,
	salt varchar(50),
	date time
);
create table if not exists authorities (
	id bigint not null,
	username varchar(25) not null,
	authority varchar(10) not null
);