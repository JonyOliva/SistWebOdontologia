INSERT INTO `odontologiadb`.`usuarios`
(`IDUsuario`,`TipoUsuario`,`Email`,`Password`)
VALUES
('A001', 1,'asd@asd.asd','asd'),
('O001',0,'a@a.a','123456');

INSERT INTO `odontologiadb`.`odontologos`
(`IDOdontologo`,
`Nombre`,`Apellido`,`DNI`,`Matricula`)
VALUES
('O001','Camilo','Zuñiga','12312322','2323233');

INSERT INTO `odontologiadb`.`administradores`
(`IDAdministrador`,`Nombre`,`Apellido`,`DNI`)
VALUES
('A001','Rodriguez','Camila','32222333');

INSERT INTO `odontologiadb`.`pacientes`
(`Nombre`,`Apellido`,`DNI`,`Telefono`,`Domicilio`,`FechaNacimiento`,`InformacionExtra`,`Activo`)
VALUES
('Javier','Perez','23555555','32456788','Loperrega 3232','1980-8-5','',1),
('Laura','Riquelme','55678556','11111111','Cabildo 3232','1975-11-12','',1);

INSERT INTO `odontologiadb`.`horarios`
(`IDOdontologo_HOR`,`Dia`,`HoraInicio`,`HoraFin`,`Activo`)
VALUES
('O001','Lunes','10:00:00','16:00:00',1);

INSERT INTO `odontologiadb`.`turnos`
(`IDPaciente_T`,`IDOdontologo_T`,`Fecha`,`Estado`)
VALUES
(1,'O001','2019-12-30 11:00:00','Ausente'), (1,'O001','2019-5-5 15:00:00','Ausente'),
(2,'O001','2019-2-5 10:00:00','Ausente');

INSERT INTO `odontologiadb`.`tratamientos`
(`IDTratamiento`,`Descripcion`,`Precio`)
VALUES
('Exodoncia','Extacción de diente o muela',600);

INSERT INTO `odontologiadb`.`consultas`
(`IDTurno_CON`,`IDOdontologo_CON`,`IDTratamiento_CON`,`IDPaciente_CON`,`AnotacionExtra`)
VALUES
(1,'O001','Exodoncia',1,'Excesivo sangrado');



