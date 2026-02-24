Drop database if exists DBControColonia_in5cm;
create database DBControColonia_in5cm;
use DBControColonia_in5cm;

create table Casa(
	id_Casa int auto_increment not null,
	no_De_Casa varchar(5) not null,
	Direccion varchar(25) not null,
	Estado enum("ocupada", "disponible", "mantenimiento") not null,
	Propietario varchar(100) not null,
	precio_Casa decimal(12,2) not null,
	primary key PK_id_casa(id_Casa)
);

create table Residente(
	id_Residente int not null auto_increment,
	nombre_Residente varchar(100) not null,
	dpi_Residente varchar(13) not null,
	telefono_Residente varchar(8) not null,
	Posicion enum("activo", "inactivo") not null,
	id_Casa int not null,
	primary key PK_id_Residente(id_Residente),
	constraint FK_Residente_Casa foreign key (id_Casa)
	references Casa(id_Casa) on delete cascade
);


-- PROCEDIMIENTO ALMACENADOS --

	-- Casa --
-- Create --
Delimiter $$ 
	create procedure sp_Casa_create(c_no_De_Casa varchar(5), c_Direccion varchar(25), 
    c_Estado enum("ocupada", "disponible", "mantenimiento"), c_Propietario varchar(100), c_precio_Casa decimal(12, 2))
    begin 
		insert into Casa(no_De_Casa, Direccion, Estado, Propietario, precio_Casa)
		values (c_no_De_Casa, c_Direccion, c_Estado, c_Propietario, c_precio_Casa);
		select last_insert_id() as id_Casa;
    end $$
Delimiter ;

-- Delete --
Delimiter $$
	create procedure sp_Casa_delete(in c_id_Casa int )
    begin
		delete from Casa where id_Casa = c_id_Casa;
        select row_count() as filas_afectadas;
    end $$
Delimiter ;

-- Read -- 
Delimiter $$
	create procedure sp_Casa_read_all()
    begin 
		select * from Casa order by id_Casa;
    end $$
Delimiter ;

-- Update -- 
Delimiter $$
	create procedure sp_Casa_update(in c_id_Casa int, in c_no_De_Casa varchar(5), in c_Direccion varchar(25), in c_Estado enum("ocupada", "disponible", "mantenimiento"), 
    in c_Propietario varchar(100), in c_precio_Casa decimal(12, 2))
    begin 
		update Casa
		set id_Casa = c_id_Casa,
			no_De_Casa = c_no_De_Casa,
            Direccion = c_Direccion,
            Estado = c_Estado,
            Propietario = c_Propietario,
            precio_Casa = c_precio_Casa
            where id_Casa = c_id_Casa;
		select row_count() as filas_afectadas;
    end $$
Delimiter ;

	-- Residente --
-- Create --
Delimiter $$
	create procedure sp_Residente_create(r_nombre_Residente varchar(100), r_dpi_Residente varchar(13),
    r_telefono_Residente varchar(8), r_Posicion enum("activo","inactivo"), r_id_Casa int)
    begin
		insert into Residente(nombre_Residente, dpi_Residente, telefono_Residente, Posicion, id_Casa)
		values (r_nombre_Residente, r_dpi_Residente, r_telefono_Residente, r_Posicion, r_id_Casa);
		select last_insert_id() as id_residente;
    end $$
Delimiter ;

-- Delete --
Delimiter $$
	create procedure sp_Residente_delete(in p_id_Residente int )
    begin
		delete from Residente where id_Residente = p_id_Residente;
        select row_count() as filas_afectadas;
    end $$
Delimiter ;

-- Read -- 
Delimiter $$
	create procedure sp_Residente_read_all()
    begin
		select * from Residente order by id_Residente;
    end $$
Delimiter ;

-- Update -- 
Delimiter $$
	create procedure sp_Residente_update(in r_id_Residente int, in r_nombre_Residente varchar(100), in r_dpi_Residente varchar(13),
    in r_telefono_Residente varchar(8), in r_Posicion enum("activo","inactivo"), in r_id_Casa int)
    begin
		update Residente
		set id_Residente = r_id_Residente,
			nombre_Residente = r_nombre_Residente,
            dpi_Residente = r_dpi_Residente,
            telefono_Residente = r_telefono_Residente,
            Posicion = r_Posicion,
            id_Casa = r_id_Casa
            where id_Residente = r_id_Residente;
		select row_count() as filas_afectadas;
    end $$
Delimiter ;

CALL sp_casa_create('C001','Avenida 1, Calle 1','ocupada','Ana López',250000.00);
CALL sp_casa_create('C002','Avenida 2, Calle 3','disponible','Carlos Méndez',310500.00);
CALL sp_casa_create('C003','Avenida 3, Calle 5','mantenimiento','María Pérez',275900.00);
CALL sp_casa_create('C004','Avenida 4, Calle 1','ocupada','Luis García',420000.00);
CALL sp_casa_create('C005','Avenida 5, Calle 2','disponible','Sofía Ramírez',198750.00);
CALL sp_casa_create('C006','Avenida 6, Calle 8','ocupada','Jorge Castillo',365000.00);
CALL sp_casa_create('C007','Avenida 7, Calle 4','mantenimiento','Paola Díaz',289999.99);
CALL sp_casa_create('C008','Avenida 8, Calle 6','disponible','Miguel Hernández',330250.50);
CALL sp_casa_create('C009','Avenida 9, Calle 3','ocupada','Elena Morales',410800.00);
CALL sp_casa_create('C010','Avenida 10, Calle 2','disponible','Ricardo Flores',299000.00);

CALL sp_residente_create('Juan Pérez','1234567890123','55123456','activo',1);
CALL sp_residente_create('Lucía Gómez','2345678901234','55234567','activo',2);
CALL sp_residente_create('Pedro Ruiz','3456789012345','55345678','inactivo',3);
CALL sp_residente_create('Carla Soto','4567890123456','55456789','activo',4);
CALL sp_residente_create('Diego López','5678901234567','55567890','activo',5);
CALL sp_residente_create('Valeria Paz','6789012345678','55678901','inactivo',6);
CALL sp_residente_create('Andrés León','7890123456789','55789012','activo',7);
CALL sp_residente_create('Fernanda Gil','8901234567890','55890123','activo',8);
CALL sp_residente_create('Kevin Cruz','9012345678901','55901234','inactivo',9);
CALL sp_residente_create('Diana Rivas','0123456789012','55012345','activo',10);