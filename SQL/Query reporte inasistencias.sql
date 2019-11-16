use odontologiadb;
SELECT pacientes.IDPaciente, pacientes.Nombre, pacientes.Apellido, pacientes.DNI, count(pacientes.IDPaciente) as Inasistencias FROM odontologiadb.pacientes
inner join turnos on pacientes.IDPaciente = turnos.IDPaciente_T
where pacientes.Activo = 1 and turnos.Estado = 'Ausente'
group by pacientes.IDPaciente
order by Inasistencias desc;

