CREATE TABLE Content(
	id int NOT NULL IDENTITY(1,1),
	authorID int NOT NULL,
	Title nvarchar(200) NOT NULL,
	Brief varchar(150) NOT NULL,
	CreatedDate DATETIME DEFAULT GETDATE(),
	UpdateTime DATETIME null,
	Content nvarchar(255) NOT NULL,
	Sort nvarchar(255) null,
	PRIMARY KEY(id, authorID),
	FOREIGN KEY (authorID) REFERENCES dbo.Member(id)
);