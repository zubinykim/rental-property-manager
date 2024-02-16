BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, properties, property_images, leases, maintenance_requests;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

create table properties (
	property_id serial,
	landlord_id int not null,
	tenant_id int,
	description varchar(200),
	address varchar(200),
	constraint pk_properties primary key (property_id),
	constraint fk_properties_landlord foreign key (landlord_id) references users(user_id),
	constraint fk_properties_tenant foreign key (tenant_id) references users(user_id)
);

create table property_images (
	image_id serial,
	property_id int not null,
	image_url varchar(200),
	constraint pk_property_images primary key (image_id),
	constraint fk_property_images_properties foreign key (property_id) references properties(property_id)
);

create table leases (
	lease_id serial,
	property_id int not null,
	tenant_id int not null,
	rent_amount numeric(10, 2),
	rent_due_date date,
	rent_status varchar(20),
	constraint pk_leases primary key (lease_id),
	constraint fk_leases_properties foreign key (property_id) references properties(property_id),
	constraint fk_leases_tenant foreign key (tenant_id) references users(user_id)
);

create table maintenance_requests (
	request_id serial,
	property_id int not null,
	tenant_id int not null,
	worker_id int,
	description varchar(200),
	request_date date,
	issue_location varchar(200),
	constraint pk_requests primary key (request_id),
	constraint fk_requests_property foreign key (property_id) references properties(property_id),
	constraint fk_requests_tenant foreign key (tenant_id) references users(user_id),
	constraint fk_requests_worker foreign key (worker_id) references users(user_id)
);

COMMIT TRANSACTION;