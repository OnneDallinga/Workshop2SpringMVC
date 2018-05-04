create table if not exists account (
	id varchar(4) not null,
	username varchar(25) not null,
	encryptedpassword varchar(50) not null,
	enabled bit DEFAULT 1,
	salt varchar(50),
	date time
);