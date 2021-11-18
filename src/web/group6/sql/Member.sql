CREATE TABLE Member(
	id int NOT NULL IDENTITY(1,1),
	Email nvarchar(50) NOT NULL,
	Password nvarchar(120) NOT NULL,
	Username varchar(50) NOT NULL,
	CreatedDate DATETIME DEFAULT GETDATE(),
	UpdateTime DATETIME null,
	Roles int DEFAULT 0,
	Firstname nvarchar(50) null,
	Lastname nvarchar(50) null,
	Decription nvarchar(255) null,
	Phone nvarchar(12) null
	PRIMARY KEY(id)
);