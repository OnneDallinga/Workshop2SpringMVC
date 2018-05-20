create table if not exists account (
  id bigint not null unique auto_increment,
  created_on timestamp,
  last_modified_on timestamp,
  enabled bit default true,
  encrypted_password char(60) not null,
  username varchar(25) not null unique,
  primary key (id))
engine=InnoDB;
create table if not exists address (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, address_type varchar(8), city varchar(255), house_number integer not null, house_number_addition varchar(255), postal_code varchar(255), street varchar(255), customer_id bigint not null, primary key (id)) engine=InnoDB;
create table if not exists authorities (
	id bigint not null unique,
	username varchar(25) not null unique,
	authority varchar(10) not null
);
create table if not exists customer (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, email varchar(255), first_name varchar(255), last_name varchar(255), last_name_preposition varchar(255), phone_number varchar(255), primary key (id)) engine=InnoDB;
create table if not exists invoice (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, is_voided bit not null, settled_on datetime, `order_id` bigint, paymentid bigint, primary key (id)) engine=InnoDB;
create table if not exists `order` (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, completed bit not null, order_items_total integer not null, order_price_total decimal(19,2), shipped bit not null, customer_id bigint not null, invoiceid bigint not null, primary key (id)) engine=InnoDB;
create table if not exists order_line_item (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, product_quantity integer not null, orderid bigint not null, productid bigint not null, primary key (id)) engine=InnoDB;
create table if not exists payment (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, date datetime, payment_method integer, invoice_id bigint, primary key (id)) engine=InnoDB;
create table if not exists product (id bigint not null auto_increment, created_on datetime, last_modified_on datetime, description longtext not null, image longblob, name varchar(255) not null, price decimal(19,2), stock_quantity integer not null, primary key (id)) engine=InnoDB;
create table if not exists wine (alcohol_percentage double precision not null, content_in_ml integer not null, country_of_origin varchar(255), grape_variety varchar(255), region varchar(255), wine_classification integer, year integer not null, id bigint not null, primary key (id)) engine=InnoDB;
alter table account add unique (username);
alter table address add foreign key (customer_id) references customer (id);
alter table customer add foreign key (id) references account (id);
alter table invoice add foreign key (`order_id`) references `order` (id);
alter table invoice add foreign key (paymentid) references payment (id);
alter table `order` add foreign key (customer_id) references customer (id);
alter table `order` add foreign key (invoiceid) references invoice (id);
alter table order_line_item add foreign key (orderid) references `order` (id);
alter table order_line_item add foreign key (productid) references product (id);
alter table payment add foreign key (invoice_id) references invoice (id);
alter table wine add foreign key (id) references product (id);
