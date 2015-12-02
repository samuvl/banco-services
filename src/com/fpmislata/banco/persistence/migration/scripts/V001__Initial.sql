CREATE TABLE `entidadbancaria` (
	`idEntidadBancaria` INT(11) NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(50) NULL DEFAULT NULL,
	`codigoEntidad` VARCHAR(50) NULL DEFAULT NULL UNIQUE,
	`fechaCreacion` DATE NULL DEFAULT NULL,
	`direccion` VARCHAR(50) NULL DEFAULT NULL,
	`cif` VARCHAR(10) NULL DEFAULT NULL,
	PRIMARY KEY (`idEntidadBancaria`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=27
;


INSERT INTO `entidadbancaria` (`idEntidadBancaria`, `nombre`, `codigoEntidad`, `fechaCreacion`, `direccion`, `cif`) VALUES
	(3, 'CRISTIAN-BANK-PUTING', '9999', '2013-09-25', 'EN SU CRISTIANKELLYCOLEGA', '00000000'),
	(9, 'tucaixo', '0', NULL, NULL, NULL),
	(10, 'samsa', '19', '2015-01-01', NULL, '23456'),
	(12, 'samsa', '9', '2015-01-01', NULL, '23456'),
	(13, 'CRISTIAN-BANK-PUTING', '6969', '2013-09-25', 'EN SU CRISTIANKELLYCOLEGA', '00000000'),
	(14, 'CRISTIAN-BANK-PUTING', '5555', '2013-09-25', 'EN SU CRISTIANKELLYCOLEGA', '00000000'),
	(15, 'CRISTIAN-BANK-PUTING', '4545', '2013-09-25', 'EN SU CRISTIANKELLYCOLEGA', '00000000'),
	(16, 'CRISTIAN-BANK-PUTING', '6666', '2013-09-25', 'EN SU CRISTIANKELLYCOLEGA', '00000000'),
	(17, 'CRISTIAN-BANK-PUTING', '8526', '2013-09-25', 'EN SU CRISTIANKELLYCOLEGA', '00000000'),
	(18, 'CRISTIAN-BANK-PUTING', '8888', '2013-09-25', 'EN SU CRISTIANKELLYCOLEGA', '00000000'),
	(19, 'CRISTIAN-BANK-PUTING', '1474', '2013-09-25', 'EN SU CRISTIANKELLYCOLEGA', '00000000'),
	(20, 'a', '1111', NULL, NULL, NULL),
	(21, 'juanito', '123', '2011-01-01', 'a', 'a12'),
	(22, 'pepete', '0000', '2011-01-01', 'fafew', '23ef'),
	(23, 'ab', '40', NULL, NULL, NULL),
	(25, 'aaa', '10', NULL, NULL, NULL),
	(26, 'fjaiefj', '010', NULL, NULL, NULL);


/*
CREATE TABLE `sucursalbancaria` (
	`idSucursalBancaria` INT(11) NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(50) NOT NULL DEFAULT '0',
	`numeroSucursal` INT(11) NOT NULL DEFAULT '0',
	`direccion` VARCHAR(50) NOT NULL DEFAULT '0',
	`telefono` INT(11) NOT NULL DEFAULT '0',
	`director` VARCHAR(50) NOT NULL DEFAULT '0',
	PRIMARY KEY (`idSucursalBancaria`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;



CREATE TABLE `usuario` (
	`idUsuario` INT(11) NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(50) NULL DEFAULT NULL,
	`encryptedPassword` VARCHAR(50) NULL DEFAULT NULL,
	`rol` VARCHAR(20) NULL DEFAULT NULL,
	`nick` VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY (`idUsuario`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;
*/