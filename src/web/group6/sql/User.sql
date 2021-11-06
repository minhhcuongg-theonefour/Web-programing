CREATE TABLE Users(
	id int NOT NULL IDENTITY(1,1),
	email nvarchar(255) NOT NULL,
	pass nvarchar(120) NOT NULL,
	username varchar(50) NOT NULL,
	createdAt DATETIME DEFAULT GETDATE(),
	roles int DEFAULT 0,
	PRIMARY KEY(id)
);