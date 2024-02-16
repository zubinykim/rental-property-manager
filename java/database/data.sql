BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

insert into users (username, password_hash, role) values
	('bob', 'bob', 'ROLE_TENANT'),
	('lisa', 'lisa', 'ROLE_TENANT'),
	('andy', 'andy', 'ROLE_TENANT'),
	('zubin', '$2a$10$.KOb8qU9JiDCXDKC/aLT9umIHh9ubbsl42F9db9YvBc0CYFw3nF7i', 'ROLE_LANDLORD');

insert into properties (landlord_id, tenant_id, description, address) values
	(6, 3, 'Beach Front Home', '123 Sesame St'),
	(6, 4, 'Beaches and Dreams', '456 Sesame St'),
	(6, 5, 'Mahi Mahi', '789 Sesame St'),
	(6, null, 'Port View', '123 Fake St');

insert into property_images (property_id, image_url) values
	(1, 'https://a0.muscache.com/im/pictures/miso/Hosting-895750271489176039/original/08b5a953-903a-47b0-920e-f1a599ee8f02.jpeg?im_w=1200'),
	(2, 'https://a0.muscache.com/im/pictures/prohost-api/Hosting-48860129/original/f691c33c-d124-44a1-993e-7d9a6b431386.jpeg?im_w=1200'),
	(3, 'https://a0.muscache.com/im/pictures/2db90bcc-9850-42ad-ab99-1301a46eb1b2.jpg?im_w=1200'),
	(4, 'https://a0.muscache.com/im/pictures/prohost-api/Hosting-678827892965412094/original/55011cd8-6097-456d-8dce-86a1ce43939d.jpeg?im_w=1200');

insert into leases (property_id, tenant_id, rent_amount, rent_due_date, rent_status) values
	(1, 3, 1000.00, '2/20/24', 'On Time'),
	(1, 4, 1500.00, '3/1/24', 'On Time'),
	(1, 5, 2000.00, '2/14/24', 'Late');

insert into maintenance_requests (property_id, tenant_id, worker_id, description, request_date, issue_location) values
	(1, 3, null, 'Heater broken', '2/14/24', 'Unit wide'),
	(2, 4, null, 'Leaking sink', '2/10/24', 'Kitchen');

COMMIT TRANSACTION;