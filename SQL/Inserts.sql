INSERT INTO `dientes` VALUES (11,'maxilar'),(12,'maxilar'),(13,'maxilar'),(14,'maxilar'),(15,'maxilar'),(16,'maxilar'),(17,'maxilar'),(18,'maxilar'),(21,'maxilar'),(22,'maxilar'),(23,'maxilar'),(24,'maxilar'),(25,'maxilar'),(26,'maxilar'),(27,'maxilar'),(28,'maxilar'),(31,'mandibular'),(32,'mandibular'),(33,'mandibular'),(34,'mandibular'),(35,'mandibular'),(36,'mandibular'),(37,'mandibular'),(38,'mandibular'),(41,'mandibular'),(42,'mandibular'),(43,'mandibular'),(44,'mandibular'),(45,'mandibular'),(46,'mandibular'),(47,'mandibular'),(48,'mandibular');


INSERT INTO `estadosdientes` VALUES (1,'Carie'),(2,'Empaste'),(3,'Ausente/extracción'),(4,'Corona/protesis'),(5,'Puente');

INSERT INTO `odontologiadb`.`usuarios`
(`IDUsuario`,`TipoUsuario`,`Email`,`Password`)
VALUES
('A001', 1,'asd@asd.asd','asd'),('O001',0,'a@a.a','123456'),('A002',1,'claudio@arvo.cf','claudio'),('O002',0,'doc@arvo.cf','doc');

INSERT INTO `odontologiadb`.`odontologos`
(`IDOdontologo`,
`Nombre`,`Apellido`,`DNI`,`Matricula`)
VALUES
('O001','Camilo','Zuñiga','12312322','2323233'),('O002','Fernanda','Gonzales','25659878','4568977');

INSERT INTO `odontologiadb`.`administradores`
(`IDAdministrador`,`Nombre`,`Apellido`,`DNI`)
VALUES
('A001','Camila','Rodriguez','32222333'),('A002','Ernesto','Batan','32566878');

INSERT INTO `odontologiadb`.`pacientes`
(`Nombre`,`Apellido`,`DNI`,`Telefono`,`Domicilio`,`FechaNacimiento`,`InformacionExtra`,`Activo`,`Localidad`)
VALUES
('Javier','Perez','23555555','32456788','Loperrega 3232','1980-8-5','',1,'Olivos'),('Laura','Riquelme','55678556','11111111','Cabildo 3232','1975-11-12','',1,'Gral Pacheco'),
('Jimena','Lux','34324578','1123324567','La cabaña 1254','1990-5-8','Telefono de hogar:4323-6598',1,'Tigre'),
('Nicolas','De la Cruz','41523698','1188956235','Udaondo 1560','1999-3-9','En su pasaporte figura tambien el apellido Sanchez',1,'Viedma');

INSERT INTO `odontologiadb`.`horarios`
(`IDOdontologo_HOR`,`Dia`,`HoraInicio`,`HoraFin`,`Activo`)
VALUES
('O001','Lunes','10:00:00','16:00:00',1),('O002','Lunes','9:00:00','13:00:00',1),('O001','Martes','15:00:00','20:00:00',1),('O002','Miercoles','17:00:00','21:00:00',1);

INSERT INTO `odontologiadb`.`turnos`
(`IDPaciente_T`,`IDOdontologo_T`,`Fecha`,`Estado`)
VALUES
(1,'O001','2019-12-30 11:00:00','Ausente'), (1,'O001','2019-5-5 15:00:00','Ausente'),(2,'O001','2019-2-5 10:00:00','Ausente'),
(3,'O002','2018-6-18 18:00:00','Ausente'),(4,'O002','2019-11-27 17:00:00','Activo');

INSERT INTO `odontologiadb`.`tratamientos`
(`IDTratamiento`,`Descripcion`,`Precio`)
VALUES
('Exodoncia','Extacción de diente o muela',600),('Endodoncia','Extracción de pulpa dental, relleno y sellado de la misma.', 500),
('Periodoncia','Analizar encias o raíces de las piezas dentales.', 300),('Reendodoncia','Tratamiento que se realiza cuando la endodoncia no da resultados.',800),
('Empaste dental','Retirar las caries y luego rellenar con pasta.',300),('Corona dental', 'Proteccion de diente afectado.',600),
('Prótesis dental','Reemplazo de dientes perdidos.',1500),('Férula de descarga','Proteccion contra bruxismo y otras enfermedades.',5000),
('Incrustasiones dentales','Se reparan dientes dañados, rallados o partidos.',1600),('Implante dental','Diente artificial que se pondrá en lugar de uno retirado a propósito.',2000),
('Puentes dentales','Prótesis fija que se une a uno o más dientes.',2000),('Raspado y pulido radicular','Limpieza de placa y sarro acumulado.',600),
('Ortodoncia','Alinear y mover los dientes para mejorar apariencia y funcionalidad.',2500),('Extracción','Retiro de alguna pieza dental.',1000),
('Blanqueamiento dental','Eliminar manchas de los dientes y conseguir mayor blancura en ellos.',2000),
('Carillas dentales','Capas de porcelana que se colocan en la superficie del diente para mejorar apariencia y funcionalidad.',2000),
('Blanqueamiento dental LED','Técnica para conseguir el color blanco natural de los dientes.',1500);

INSERT INTO `odontologiadb`.`consultas`
(`IDTurno_CON`,`IDOdontologo_CON`,`IDTratamiento_CON`,`IDPaciente_CON`,`AnotacionExtra`)
VALUES
(1,'O001','Exodoncia',1,'Excesivo sangrado'),(5,'O002','Empaste dental',4,'Sensibilidad alta');



