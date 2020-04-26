USE TallerMecanico
GO

DROP TABLE IF EXISTS dbo.autos

CREATE TABLE dbo.autos (
	id_auto		INT				IDENTITY(1,1) NOT NULL,
	nombre		VARCHAR(50)		NOT NULL
)

INSERT INTO dbo.autos (nombre) VALUES ('Ford Ka')

DROP TABLE IF EXISTS dbo.auto_partes

CREATE TABLE dbo.auto_partes (
	id_auto_partes		SMALLINT		IDENTITY(1,1) NOT NULL,
	descripcion			VARCHAR(50)		NOT NULL,
	cantidad_disponible	SMALLINT		NOT NULL
)

INSERT INTO dbo.auto_partes (descripcion, cantidad_disponible) VALUES 
	('filtros',5),
	('aceites',1),
	('pastillas de freno',2)

	SELECT id_auto_partes, descripcion, cantidad_disponible FROM dbo.auto_partes