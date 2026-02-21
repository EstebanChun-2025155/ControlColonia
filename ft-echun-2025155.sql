Drop database if exists DBControColonia_in5cm;
create database DBControColonia_in5cm;
use DBControColonia_in5cm;

create table Casa(
	id_casa int auto_increment not null,
	no_de_casa varchar(5) not null,
	direccion varchar(25) not null,
	estado enum("ocupada", "disponible", "mantenimiento") not null,
	propietario varchar(100) not null,
	precio_casa decimal(12,2) not null,
	primary key PK_id_casa(id_casa)
);

create table Residente(
	id_residente int not null auto_increment,
	nombre_residente varchar(100) not null,
	dpi_residente varchar(13) not null,
	telefono_residente varchar(8) not null,
	posicion enum("activo", "inactivo") not null,
	id_casa int not null,
	primary key PK_id_residente(id_residente),
	constraint FK_residente_casa foreign key (id_casa)
	references Casa(id_casa) on delete cascade
);

-- PROCEDIMIENTO ALMACENADOS --

	-- Casa --
-- Create --
Delimiter $$ 
	create procedure sp_Casa_create(c_no_de_casa varchar(5), c_direccion varchar(25), 
    c_estado enum("ocupada", "disponible", "mantenimiento"), c_propietario varchar(100), c_precio_casa decimal(12, 2))
    begin 
		insert into Casa(no_de_casa, direccion, estado, propietario, precio_casa)
		values (c_no_de_casa, c_direccion, c_estado, c_propietario, c_precio_casa);
		select last_insert_id() as id_casa;
    end $$
Delimiter ;

-- Delete --
Delimiter $$
	create procedure sp_Casa_delete(in c_id_casa int )
    begin
		delete from Casa where id_casa = c_id_casa;
        select row_count() as filas_afectadas;
    end $$
Delimiter ;

-- Read -- 
Delimiter $$
	create procedure sp_Casa_read_all()
    begin 
		select * from Casa order by id_casa;
    end $$
Delimiter ;

-- Update -- 
Delimiter $$
	create procedure sp_Casa_update(in c_id_casa int, in c_no_de_casa varchar(5), in c_direccion varchar(25), in c_estado enum("ocupada", "disponible", "mantenimiento"), 
    in c_propietario varchar(100), in c_precio_casa decimal(12, 2))
    begin 
		update Casa
		set id_casa = c_id_casa,
			no_de_casa = c_no_de_casa,
            direccion = c_direccion,
            estado = c_estado,
            propietario = c_propietario,
            precio_casa = c_precio_casa
            where id_casa = c_id_casa;
		select row_count() as filas_afectadas;
    end $$
Delimiter ;

	-- Residente --
-- Create --
Delimiter $$
	create procedure sp_Residente_create(r_nombre_residente varchar(100), r_dpi_residente varchar(13),
    r_telefono_residente varchar(8), r_posicion enum("activo","inactivo"), r_id_casa int)
    begin
		insert into residente(nombre_residente, dpi_residente, telefono_residente, posicion, id_casa)
		values (r_nombre_residente, r_dpi_residente, r_telefono_residente, r_posicion, r_id_casa);
		select last_insert_id() as id_residente;
    end $$
Delimiter ;

-- Delete --
Delimiter $$
	create procedure sp_Residente_delete(in p_id_residente int )
    begin
		delete from residente where id_residente = p_id_residente;
        select row_count() as filas_afectadas;
    end $$
Delimiter ;

-- Read -- 
Delimiter $$
	create procedure sp_Residente_read_all()
    begin
		select * from residente order by id_residente;
    end $$
Delimiter ;

-- Update -- 
Delimiter $$
	create procedure sp_Residente_update(in r_id_residente int, in r_nombre_residente varchar(100), in r_dpi_residente varchar(13),
    in r_telefono_residente varchar(8), in r_posicion enum("activo","inactivo"), in r_id_casa int)
    begin
		update residente
		set id_residente = r_id_residente,
			nombre_residente = r_nombre_residente,
            dpi_residente = r_dpi_residente,
            telefono_residente = r_telefono_residente,
            posicion = r_posicion,
            id_casa = r_id_casa
            where id_residente = r_id_residente;
		select row_count() as filas_afectadas;
    end $$
Delimiter ;
