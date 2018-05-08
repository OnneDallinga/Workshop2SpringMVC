create table if not exists account (
	id bigint not null unique,
	username varchar(25) not null unique,
	encrypted_password char(60) not null,
	enabled bit DEFAULT 1,
	created_on timestamp,
	last_modified_on timestamp DEFAULT current_timestamp
);
create table if not exists authorities (
	id bigint not null unique,
	username varchar(25) not null unique,
	authority varchar(10) not null
);