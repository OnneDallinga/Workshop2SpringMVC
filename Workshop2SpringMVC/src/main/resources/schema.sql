create table if not exists account (
	id bigint not null unique,
	username varchar(25) not null unique,
	encrypted_password varchar(50) not null,
	enabled bit DEFAULT 1,
	salt varchar(50),
	created_on timestamp,
	last_modified_on timestamp
);
create table if not exists authorities (
	id bigint not null unique,
	username varchar(25) not null unique,
	authority varchar(10) not null
);