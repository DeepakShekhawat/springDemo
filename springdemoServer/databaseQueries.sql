CREATE TABLE category(
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(250),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	
	CONSTRAINT pk_category_id PRIMARY KEY (id)

);

insert into category (name, description, image_url, is_active) values ('Laptop','This is a LENOVO laptop','CAT_1.img',true);
insert into category (name, description, image_url, is_active) values ('Television','This is LG Full HD TV','CAT_2.img',true);
insert into category (name, description, image_url, is_active) values ('Mobile','This is IPHONE Apple produce','CAT_3.img',true);
insert into category (name, description, image_url, is_active) values ('HomeAppliances','This Category is for Home Appliances','CAT_4.img',true);

CREATE TABLE user_detail (
   id IDENTITY,
   first_name VARCHAR(50),
   last_name VARCHAR(50),
   role VARCHAR(50),
   enabled BOOLEAN,
   password VARCHAR(50),
   email VARCHAR(100),
   contact_number VARCHAR(15),
   CONSTRAINT pk_user_id PRIMARY KEY (id),

);

insert into user_detail (first_name, last_name, role, enabled, password, email, contact_number)
values ('Virat','Kohli','ADMIN','true','admin','vk@gmail.com','8888888888');

insert into user_detail (first_name, last_name, role, enabled, password, email, contact_number)
values ('Ravindra','Jedeja','SUPPLIER','true','12345','rv@gmail.com','9999999999');

insert into user_detail (first_name, last_name, role, enabled, password, email, contact_number)
values ('Ravindra','Chandran','SUPPLIER','true','12345','RV@gmail.com','7777777777');


Create table product (

	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(50),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	
	CONSTRAINT pk_product_id PRIMARY KEY(id),
	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id),
	
);

insert into product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
values ('PRODACBD00231','IPhone 5S','Apple','IPhone 5S silver color 32 GB','21000',2,true,3,1);
insert into product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
values ('PRODACBD00222','MAC Book','Apple','Mac Book 8 GB Ram with 1TB Rom','72000',5,true,1,2);
insert into product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
values ('PRODACBD00121','LG LED','LG','LG Full HD display 55 inch TV','45000',5,true,2,3);
insert into product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
values ('PRODACBD00111','Dell Inspiron Laptop','Dell','Dell Insprion 4115 8 GB RAM','33000',8,true,1,1);
insert into product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
values ('PRODACBD11214','Samsung Mirowave','Samsung','Samsung convection microwave 22 kg','18000',2,true,4,3);