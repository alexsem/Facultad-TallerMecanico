USE TallerMecanico
GO
DROP TABLE IF EXISTS dbo.reparacion_por_factura
DROP TABLE IF EXISTS dbo.reparacion 
DROP TABLE IF EXISTS dbo.auto_partes
DROP TABLE IF EXISTS dbo.autos
DROP TABLE IF EXISTS dbo.factura
GO

CREATE TABLE dbo.autos (
	id_auto		INT				IDENTITY(1,1) PRIMARY KEY	NOT NULL,
	marca		VARCHAR(50)		NOT NULL,
	modelo		VARCHAR(50)		NOT NULL,
	duenio		VARCHAR(100)	NOT NULL,
	patente		VARCHAR(10)		NOT NULL,
	anio		SMALLINT		NOT NULL,
	fecha_ingreso	DATE		NOT NULL,
	fecha_egreso	DATE		NULL
)
GO

INSERT INTO dbo.autos (marca, modelo, anio, duenio, patente, fecha_ingreso, fecha_egreso) 
	VALUES	('Ford', 'Fiesta 5P', 2013, 'Alejandro Semprini', 'NOS393', GETDATE(), NULL),
			('Chevrolet', 'Onix 3P', 2019, 'Sulma Romero', 'AD567AA', GETDATE(), NULL)

GO

CREATE TABLE dbo.auto_partes (
	id_auto_partes		INT				IDENTITY(1,1) PRIMARY KEY NOT NULL,
	descripcion			VARCHAR(50)		NOT NULL,
	cantidad_disponible	SMALLINT		NOT NULL,
	costo				DECIMAL(10,2)	NOT NULL
)
GO

INSERT INTO dbo.auto_partes (descripcion, cantidad_disponible, costo) VALUES 
	('Filtro aire',5, 500),
	('Filtro aceite', 5, 200),
	('Aceite',1, 400),
	('Pastillas de freno',2, 2660)
GO

CREATE TABLE dbo.reparacion(
	id_reparacion		INT				IDENTITY(1,1) PRIMARY KEY	NOT NULL,
	id_auto				INT				NOT NULL,
	id_auto_partes		INT				NOT NULL,
	cantidad_usada		INT				NOT NULL,
	fecha_de_uso		DATE			NOT NULL,
	tarea_descripcion	VARCHAR(MAX)	NOT NULL,
	valor_reparacion	DECIMAL(8,2)	NOT NULL
)
GO

CREATE TABLE dbo.factura(
	id_factura			INT				IDENTITY(1,1) PRIMARY KEY	NOT NULL,
	fecha				DATE			NOT NULL,
	total_facturado		DECIMAL(8,2)	NOT NULL
)
GO

CREATE TABLE dbo.reparacion_por_factura(
	id_factura			INT				NOT NULL,
	id_reparacion		INT				NOT NULL
)


ALTER TABLE dbo.reparacion ADD CONSTRAINT FK_REPARACION_AUTOS FOREIGN KEY (id_auto) REFERENCES dbo.autos (id_auto)
ALTER TABLE dbo.reparacion ADD CONSTRAINT FK_REPARACION_AUTO_PARTES FOREIGN KEY (id_auto_partes) REFERENCES dbo.auto_partes (id_auto_partes) 
ALTER TABLE dbo.reparacion_por_factura ADD CONSTRAINT PK_REPARACION_POR_FACTURA PRIMARY KEY (id_reparacion, id_factura)
ALTER TABLE dbo.reparacion_por_factura ADD CONSTRAINT FK_REPARACION_POR_FACTURA_FACTURA FOREIGN KEY (id_factura) REFERENCES dbo.factura (id_factura)
ALTER TABLE dbo.reparacion_por_factura ADD CONSTRAINT FK_REPARACION_POR_FACTURA_REPARACION FOREIGN KEY (id_reparacion) REFERENCES dbo.reparacion (id_reparacion)
