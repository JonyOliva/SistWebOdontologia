use odontologiadb;
SELECT pacientes.IDPaciente, pacientes.Nombre, pacientes.Apellido, pacientes.DNI, count(pacientes.IDPaciente) as Inasistencias, turnos.Estado FROM odontologiadb.pacientes
inner join turnos on pacientes.IDPaciente = turnos.IDPaciente_T
where pacientes.Activo = 1 and turnos.Estado = 'Ausente' and turnos.Fecha between cast('2000-5-5' as date) and cast('2020-10-5' as date)
group by pacientes.IDPaciente
order by Inasistencias desc;