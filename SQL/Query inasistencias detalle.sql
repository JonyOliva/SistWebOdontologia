select turnos.Fecha, odontologos.Nombre as Nombre_O, odontologos.Apellido as Apellido_O, turnos.Estado,
consultas.IDConsulta, consultas.IDTratamiento_CON, consultas.IDTurno_CON, consultas.AnotacionExtra from consultas
inner join pacientes on pacientes.IDPaciente = consultas.IDPaciente_CON
inner join odontologos on odontologos.IDOdontologo = consultas.IDOdontologo_CON
inner join turnos on turnos.IDTurno = consultas.IDTurno_CON
where consultas.IDPaciente_CON = 1
order by turnos.Fecha;