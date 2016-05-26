CREATE TABLE IF NOT EXISTS foobar (
	id serial unique,
	firstname varchar(255) not null,
	lastname varchar(255) not null
);

insert into foobar (firstname, lastname) values ('Dave', 'Syer');

CREATE TABLE IF NOT EXISTS blah (
	id serial unique,
	foobar_id integer not null  REFERENCES foobar(id) on delete cascade,
	street varchar(255) not null,
	city varchar(255) not null
);

insert into blah (foobar_id, street, city) values 
((select id from foobar where firstname = 'Dave' and lastname = 'Syer'), '123 Any St.', 'Any Town');
