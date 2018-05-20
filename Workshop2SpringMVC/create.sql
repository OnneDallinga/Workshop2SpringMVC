create table account (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, enabled bit default true not null, encrypted_password varchar(255) not null, username varchar(255) not null, primary key (id)) engine=InnoDB
create table address (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, address_type varchar(8), city varchar(255), house_number integer not null, house_number_addition varchar(255), postal_code varchar(255), street varchar(255), customer_id bigint not null, primary key (id)) engine=InnoDB
create table customer (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, email varchar(255), first_name varchar(255), last_name varchar(255), last_name_preposition varchar(255), phone_number varchar(255), primary key (id)) engine=InnoDB
create table invoice (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, is_voided bit not null, settled_on datetime, `order_id` bigint, paymentid bigint, primary key (id)) engine=InnoDB
create table `order` (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, completed bit not null, order_items_total integer not null, order_price_total decimal(19,2), shipped bit not null, customer_id bigint not null, invoiceid bigint not null, primary key (id)) engine=InnoDB
create table order_line_item (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, product_quantity integer not null, orderid bigint not null, productid bigint not null, primary key (id)) engine=InnoDB
create table payment (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, date datetime, payment_method integer, invoice_id bigint, primary key (id)) engine=InnoDB
create table product (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, description longtext not null, image longblob, name varchar(255) not null, price decimal(19,2), stock_quantity integer not null, primary key (id)) engine=InnoDB
create table wine (alcohol_percentage double precision not null, content_in_ml integer not null, country_of_origin varchar(255), grape_variety varchar(255), region varchar(255), wine_classification integer, year integer not null, id bigint not null, primary key (id)) engine=InnoDB
alter table account add constraint UK_gex1lmaqpg0ir5g1f5eftyaa1 unique (username)
alter table address add constraint FK93c3js0e22ll1xlu21nvrhqgg foreign key (customer_id) references customer (id)
alter table customer add constraint FKejhvfqp0c4k348tymr8wka10n foreign key (id) references account (id)
alter table invoice add constraint FKp7ptdrdxkbt0kk2fvh803yt80 foreign key (`order_id`) references `order` (id)
alter table invoice add constraint FKss3w22qpoe9y3efqxrutj9n5t foreign key (paymentid) references payment (id)
alter table `order` add constraint FK1oduxyuuo3n2g98l3j7754vym foreign key (customer_id) references customer (id)
alter table `order` add constraint FKgivbbn83m83qu8i0foeqdmlnb foreign key (invoiceid) references invoice (id)
alter table order_line_item add constraint FKodcwyo3op2nlis3wsmj5lx23v foreign key (orderid) references `order` (id)
alter table order_line_item add constraint FK1gwdwb3cminnl5l2c0kcvevvd foreign key (productid) references product (id)
alter table payment add constraint FKsb24p8f52refbb80qwp4gem9n foreign key (invoice_id) references invoice (id)
alter table wine add constraint FKhm4s5h2ow0alr9i5uvbdvp02x foreign key (id) references product (id)
create table account (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, enabled bit default true not null, encrypted_password varchar(255) not null, username varchar(255) not null, primary key (id)) engine=InnoDB
create table address (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, address_type varchar(8), city varchar(255), house_number integer not null, house_number_addition varchar(255), postal_code varchar(255), street varchar(255), customer_id bigint not null, primary key (id)) engine=InnoDB
create table authorities (id bigint not null, authority tinyblob, username varchar(255), primary key (id)) engine=InnoDB
create table customer (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, email varchar(255), first_name varchar(255), last_name varchar(255), last_name_preposition varchar(255), phone_number varchar(255), primary key (id)) engine=InnoDB
create table invoice (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, is_voided bit not null, settled_on datetime, `order_id` bigint, paymentid bigint, primary key (id)) engine=InnoDB
create table `order` (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, completed bit not null, order_items_total integer not null, order_price_total decimal(19,2), shipped bit not null, customer_id bigint not null, invoiceid bigint not null, primary key (id)) engine=InnoDB
create table order_line_item (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, product_quantity integer not null, orderid bigint not null, productid bigint not null, primary key (id)) engine=InnoDB
create table payment (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, date datetime, payment_method integer, invoice_id bigint, primary key (id)) engine=InnoDB
create table product (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, description longtext not null, image longblob, name varchar(255) not null, price decimal(19,2), stock_quantity integer not null, primary key (id)) engine=InnoDB
create table wine (alcohol_percentage double precision not null, content_in_ml integer not null, country_of_origin varchar(255), grape_variety varchar(255), region varchar(255), wine_classification integer, year integer not null, id bigint not null, primary key (id)) engine=InnoDB
alter table account add constraint UK_gex1lmaqpg0ir5g1f5eftyaa1 unique (username)
alter table address add constraint FK93c3js0e22ll1xlu21nvrhqgg foreign key (customer_id) references customer (id)
alter table customer add constraint FKejhvfqp0c4k348tymr8wka10n foreign key (id) references account (id)
alter table invoice add constraint FKp7ptdrdxkbt0kk2fvh803yt80 foreign key (`order_id`) references `order` (id)
alter table invoice add constraint FKss3w22qpoe9y3efqxrutj9n5t foreign key (paymentid) references payment (id)
alter table `order` add constraint FK1oduxyuuo3n2g98l3j7754vym foreign key (customer_id) references customer (id)
alter table `order` add constraint FKgivbbn83m83qu8i0foeqdmlnb foreign key (invoiceid) references invoice (id)
alter table order_line_item add constraint FKodcwyo3op2nlis3wsmj5lx23v foreign key (orderid) references `order` (id)
alter table order_line_item add constraint FK1gwdwb3cminnl5l2c0kcvevvd foreign key (productid) references product (id)
alter table payment add constraint FKsb24p8f52refbb80qwp4gem9n foreign key (invoice_id) references invoice (id)
alter table wine add constraint FKhm4s5h2ow0alr9i5uvbdvp02x foreign key (id) references product (id)
create table account (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, enabled bit default true not null, encrypted_password varchar(255) not null, username varchar(255) not null, primary key (id)) engine=InnoDB
create table address (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, address_type varchar(8), city varchar(255), house_number integer not null, house_number_addition varchar(255), postal_code varchar(255), street varchar(255), customer_id bigint not null, primary key (id)) engine=InnoDB
create table authorities (id bigint not null, authority tinyblob, username varchar(255) not null, primary key (id)) engine=InnoDB
create table customer (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, email varchar(255), first_name varchar(255), last_name varchar(255), last_name_preposition varchar(255), phone_number varchar(255), primary key (id)) engine=InnoDB
create table invoice (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, is_voided bit not null, settled_on datetime, `order_id` bigint, paymentid bigint, primary key (id)) engine=InnoDB
create table `order` (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, completed bit not null, order_items_total integer not null, order_price_total decimal(19,2), shipped bit not null, customer_id bigint not null, invoiceid bigint not null, primary key (id)) engine=InnoDB
create table order_line_item (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, product_quantity integer not null, orderid bigint not null, productid bigint not null, primary key (id)) engine=InnoDB
create table payment (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, date datetime, payment_method integer, invoice_id bigint, primary key (id)) engine=InnoDB
create table product (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, description longtext not null, image longblob, name varchar(255) not null, price decimal(19,2), stock_quantity integer not null, primary key (id)) engine=InnoDB
create table wine (alcohol_percentage double precision not null, content_in_ml integer not null, country_of_origin varchar(255), grape_variety varchar(255), region varchar(255), wine_classification integer, year integer not null, id bigint not null, primary key (id)) engine=InnoDB
alter table account add constraint UK_gex1lmaqpg0ir5g1f5eftyaa1 unique (username)
alter table address add constraint FK93c3js0e22ll1xlu21nvrhqgg foreign key (customer_id) references customer (id)
alter table customer add constraint FKejhvfqp0c4k348tymr8wka10n foreign key (id) references account (id)
alter table invoice add constraint FKp7ptdrdxkbt0kk2fvh803yt80 foreign key (`order_id`) references `order` (id)
alter table invoice add constraint FKss3w22qpoe9y3efqxrutj9n5t foreign key (paymentid) references payment (id)
alter table `order` add constraint FK1oduxyuuo3n2g98l3j7754vym foreign key (customer_id) references customer (id)
alter table `order` add constraint FKgivbbn83m83qu8i0foeqdmlnb foreign key (invoiceid) references invoice (id)
alter table order_line_item add constraint FKodcwyo3op2nlis3wsmj5lx23v foreign key (orderid) references `order` (id)
alter table order_line_item add constraint FK1gwdwb3cminnl5l2c0kcvevvd foreign key (productid) references product (id)
alter table payment add constraint FKsb24p8f52refbb80qwp4gem9n foreign key (invoice_id) references invoice (id)
alter table wine add constraint FKhm4s5h2ow0alr9i5uvbdvp02x foreign key (id) references product (id)
create table account (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, enabled bit default true not null, encrypted_password varchar(255) not null, username varchar(255) not null, primary key (id)) engine=InnoDB
create table address (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, address_type varchar(8), city varchar(255), house_number integer not null, house_number_addition varchar(255), postal_code varchar(255), street varchar(255), customer_id bigint not null, primary key (id)) engine=InnoDB
create table authorities (id bigint not null, authority tinyblob, username varchar(255) not null, primary key (id)) engine=InnoDB
create table customer (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, email varchar(255), first_name varchar(255), last_name varchar(255), last_name_preposition varchar(255), phone_number varchar(255), primary key (id)) engine=InnoDB
create table invoice (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, is_voided bit not null, settled_on datetime, `order_id` bigint, paymentid bigint, primary key (id)) engine=InnoDB
create table `order` (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, completed bit not null, order_items_total integer not null, order_price_total decimal(19,2), shipped bit not null, customer_id bigint not null, invoiceid bigint not null, primary key (id)) engine=InnoDB
create table order_line_item (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, product_quantity integer not null, orderid bigint not null, productid bigint not null, primary key (id)) engine=InnoDB
create table payment (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, date datetime, payment_method integer, invoice_id bigint, primary key (id)) engine=InnoDB
create table product (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, description longtext not null, image longblob, name varchar(255) not null, price decimal(19,2), stock_quantity integer not null, primary key (id)) engine=InnoDB
create table wine (alcohol_percentage double precision not null, content_in_ml integer not null, country_of_origin varchar(255), grape_variety varchar(255), region varchar(255), wine_classification integer, year integer not null, id bigint not null, primary key (id)) engine=InnoDB
alter table account add constraint UK_gex1lmaqpg0ir5g1f5eftyaa1 unique (username)
alter table address add constraint FK93c3js0e22ll1xlu21nvrhqgg foreign key (customer_id) references customer (id)
alter table customer add constraint FKejhvfqp0c4k348tymr8wka10n foreign key (id) references account (id)
alter table invoice add constraint FKp7ptdrdxkbt0kk2fvh803yt80 foreign key (`order_id`) references `order` (id)
alter table invoice add constraint FKss3w22qpoe9y3efqxrutj9n5t foreign key (paymentid) references payment (id)
alter table `order` add constraint FK1oduxyuuo3n2g98l3j7754vym foreign key (customer_id) references customer (id)
alter table `order` add constraint FKgivbbn83m83qu8i0foeqdmlnb foreign key (invoiceid) references invoice (id)
alter table order_line_item add constraint FKodcwyo3op2nlis3wsmj5lx23v foreign key (orderid) references `order` (id)
alter table order_line_item add constraint FK1gwdwb3cminnl5l2c0kcvevvd foreign key (productid) references product (id)
alter table payment add constraint FKsb24p8f52refbb80qwp4gem9n foreign key (invoice_id) references invoice (id)
alter table wine add constraint FKhm4s5h2ow0alr9i5uvbdvp02x foreign key (id) references product (id)
create table account (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, enabled bit default true not null, encrypted_password varchar(255) not null, username varchar(255) not null, primary key (id)) engine=InnoDB
create table address (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, address_type varchar(8), city varchar(255), house_number integer not null, house_number_addition varchar(255), postal_code varchar(255), street varchar(255), customer_id bigint not null, primary key (id)) engine=InnoDB
create table authorities (id bigint not null, authority tinyblob, username varchar(255) not null, primary key (id)) engine=InnoDB
create table customer (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, email varchar(255), first_name varchar(255), last_name varchar(255), last_name_preposition varchar(255), phone_number varchar(255), primary key (id)) engine=InnoDB
create table invoice (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, is_voided bit not null, settled_on datetime, `order_id` bigint, paymentid bigint, primary key (id)) engine=InnoDB
create table `order` (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, completed bit not null, order_items_total integer not null, order_price_total decimal(19,2), shipped bit not null, customer_id bigint not null, invoiceid bigint not null, primary key (id)) engine=InnoDB
create table order_line_item (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, product_quantity integer not null, orderid bigint not null, productid bigint not null, primary key (id)) engine=InnoDB
create table payment (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, date datetime, payment_method integer, invoice_id bigint, primary key (id)) engine=InnoDB
create table product (id bigint not null auto_increment, created_on datetime not null, last_modified_on datetime, description longtext not null, image longblob, name varchar(255) not null, price decimal(19,2), stock_quantity integer not null, primary key (id)) engine=InnoDB
create table wine (alcohol_percentage double precision not null, content_in_ml integer not null, country_of_origin varchar(255), grape_variety varchar(255), region varchar(255), wine_classification integer, year integer not null, id bigint not null, primary key (id)) engine=InnoDB
alter table account add constraint UK_gex1lmaqpg0ir5g1f5eftyaa1 unique (username)
alter table address add constraint FK93c3js0e22ll1xlu21nvrhqgg foreign key (customer_id) references customer (id)
alter table customer add constraint FKejhvfqp0c4k348tymr8wka10n foreign key (id) references account (id)
alter table invoice add constraint FKp7ptdrdxkbt0kk2fvh803yt80 foreign key (`order_id`) references `order` (id)
alter table invoice add constraint FKss3w22qpoe9y3efqxrutj9n5t foreign key (paymentid) references payment (id)
alter table `order` add constraint FK1oduxyuuo3n2g98l3j7754vym foreign key (customer_id) references customer (id)
alter table `order` add constraint FKgivbbn83m83qu8i0foeqdmlnb foreign key (invoiceid) references invoice (id)
alter table order_line_item add constraint FKodcwyo3op2nlis3wsmj5lx23v foreign key (orderid) references `order` (id)
alter table order_line_item add constraint FK1gwdwb3cminnl5l2c0kcvevvd foreign key (productid) references product (id)
alter table payment add constraint FKsb24p8f52refbb80qwp4gem9n foreign key (invoice_id) references invoice (id)
alter table wine add constraint FKhm4s5h2ow0alr9i5uvbdvp02x foreign key (id) references product (id)
