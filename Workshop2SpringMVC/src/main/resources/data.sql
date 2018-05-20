insert ignore into account (id, username, encrypted_password)
		values ('1', 'Onne', 'Hello');
insert ignore into authorities (id, username, authority)
		values ('1', 'Onne', 'role_admin');
insert ignore into product (id, description, `name`, price, stock_quantity)
    values ('1', 'Omelette du fromage', 'Wijntje', '1', '4');
insert ignore into wine (alcohol_percentage, content_in_ml, country_of_origin, grape_variety, region, wine_classification, `year`, id)
    values ('4.2', '750', 'France', 'Rood', 'Alsace','2','2018','1');