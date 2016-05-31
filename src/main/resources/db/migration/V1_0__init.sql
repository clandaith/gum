-- Create Table: game_plays
--------------------------------------------------------------------------------
CREATE TABLE game_plays
(
	id SERIAL
	,user_id INTEGER NOT NULL 
	,game_system_id INTEGER NOT NULL 
	,date_played TIMESTAMP NOT NULL 
	,opponent_id INTEGER  NULL 
	,winner INTEGER NOT NULL 
);
create index game_plays_index_user_id on game_plays(user_id);
create index game_plays_index_game_system_id on game_plays(game_system_id);
create index game_plays_index_opponent_id on game_plays(opponent_id);


-- Create Table: game_company
--------------------------------------------------------------------------------
CREATE TABLE game_company
(
	id SERIAL
	,name VARCHAR(250) NOT NULL 
	,address1 VARCHAR(250) NOT NULL 
	,address2 VARCHAR(250)  NULL 
	,city VARCHAR(250) NOT NULL 
	,state VARCHAR(250) NOT NULL 
	,zip VARCHAR(250) NOT NULL 
	,country VARCHAR(250) NOT NULL 
	,phone_number INTEGER NOT NULL 
	,website VARCHAR(500) NOT NULL 
	,date_added TIMESTAMP NOT NULL 
	,date_updated TIMESTAMP NOT NULL 
	,contact_name VARCHAR(250) NOT NULL 
	,contact_phone_number INTEGER NOT NULL 
	,contact_email_address VARCHAR(250) NOT NULL 
	,CONSTRAINT PK_game_company_name PRIMARY KEY (name)
);


-- Create Table: game_system
--------------------------------------------------------------------------------
CREATE TABLE game_system
(
	id SERIAL
	,game_company_id INTEGER NOT NULL 
	,name VARCHAR(250) NOT NULL 
	,website VARCHAR(500)  NULL 
	,date_added TIMESTAMP NOT NULL 
	,date_updated TIMESTAMP NOT NULL 
	,description VARCHAR(4096)  NULL 
	,CONSTRAINT PK_game_system_name PRIMARY KEY (name)
);


-- Create Table: users
--------------------------------------------------------------------------------
CREATE TABLE users
(
	id SERIAL
	,username VARCHAR(250) NOT NULL 
	,first_name VARCHAR(250)  NULL 
	,last_name VARCHAR(250)  NULL 
	,address1 VARCHAR(250)  NULL 
	,address2 VARCHAR(250)  NULL 
	,city VARCHAR(250)  NULL 
	,state VARCHAR(250)  NULL 
	,zip VARCHAR(250)  NULL 
	,country VARCHAR(250)  NULL 
	,phone_number INTEGER  NULL 
	,date_added TIMESTAMP NOT NULL 
	,date_updated TIMESTAMP NOT NULL 
	,email_address VARCHAR(250)  NULL 
	,description VARCHAR(4096)  NULL 
	,CONSTRAINT PK_users_username PRIMARY KEY (username)
);
create index users_index_username on users(username);



-- Create Foreign Key: game_system.game_company_id -> game_company.id
ALTER TABLE game_system ADD CONSTRAINT FK_game_system_game_company_id_game_company_id FOREIGN KEY (game_company_id) REFERENCES game_company(id);


-- Create Foreign Key: game_plays.user_id -> users.id
ALTER TABLE game_plays ADD CONSTRAINT FK_game_plays_user_id_users_id FOREIGN KEY (user_id) REFERENCES users(id);


-- Create Foreign Key: game_plays.opponent_id -> users.id
ALTER TABLE game_plays ADD CONSTRAINT FK_game_plays_opponent_id_users_id FOREIGN KEY (opponent_id) REFERENCES users(id);


-- Create Foreign Key: game_plays.game_system_id -> game_system.id
ALTER TABLE game_plays ADD CONSTRAINT FK_game_plays_game_system_id_game_system_id FOREIGN KEY (game_system_id) REFERENCES game_system(id);


