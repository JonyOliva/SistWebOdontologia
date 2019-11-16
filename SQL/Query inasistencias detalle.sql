use odontologiadb;
select turnos.Fecha,turnos.idturno , odontologos.Nombre as Nombre_O, odontologos.Apellido as Apellido_O, turnos.Estado
from turnos
inner join pacientes on pacientes.IDPaciente = turnos.idpaciente_T
inner join odontologos on odontologos.IDOdontologo = turnos.idodontologo_t
where turnos.idpaciente_t = 1
order by turnos.Fecha desc;