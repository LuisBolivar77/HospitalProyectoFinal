package co.edu.eam.ingesoft.avanzada.negocio.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Cirugia;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.CirugiaRealizar;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Cita;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.EncargadoCirugia;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Examen;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Hospitalizacion;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Medicamento;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.MedicamentoPaciente;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Patologia;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.PatologiaPaciente;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.PersonalMedico;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.ResultadoExamen;

@LocalBean
@Stateless
public class HistoriaClinicaEJB {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Lsita las patologias de un paciente
	 * @param id Identificación del paciente
	 * @return la lista de patologias de este paciente
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<PatologiaPaciente> listaPatologias (String id){
		Query q = em.createNativeQuery("SELECT p.ID, p.NOMBRE, c.ANOTACIONES FROM PATOLOGIA_PACIENTE pp "
				+ "JOIN CITA c ON pp.CITA_ID = c.ID JOIN PATOLOGIA p ON p.ID = pp.PATOLOGIA_ID"
				+ "  WHERE c.PACIENTE_ID=?1");
		q.setParameter(1, id);
		
		List<PatologiaPaciente> patologias = new ArrayList<PatologiaPaciente>();		
		List<Object[]> lista = q.getResultList();
		
		for (Object[] o : lista) {
			Patologia p = new Patologia();
			p.setId(Integer.parseInt(o[0].toString()));
			p.setNombre(o[1].toString());
			
			Cita c = new Cita();
			c.setAnotaciones(o[2].toString());
			
			PatologiaPaciente pp = new PatologiaPaciente();
			pp.setCita(c);
			pp.setPatologia(p);
			
			patologias.add(pp);
		}
		
		return patologias;
	}
	
	/**
	 * Lsita los medicamentos recetados a un paciente
	 * @param id Identificación del paciente
	 * @return la lista de medicamentos recetados al paciente
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<MedicamentoPaciente> listaMedicamentos(String id){
		Query q = em.createNativeQuery("SELECT m.ID, m.DESCRIPCION, c.ANOTACIONES FROM MEDICAMENTO_PACIENTE mp "
				+ "JOIN CITA c ON mp.CITA_ID = c.ID JOIN MEDICAMENTO m "
				+ "ON m.ID=mp.MEDICAMENTO_ID  WHERE c.PACIENTE_ID=?1");
		q.setParameter(1, id);
		
		List<MedicamentoPaciente> medicamentos = new ArrayList<MedicamentoPaciente>();
		List<Object[]> lista = q.getResultList();
		
		for (Object[] m : lista) {
			
			Medicamento med = new Medicamento();
			med.setId(Integer.parseInt(m[0].toString()));
			med.setDescripcion(m[1].toString());
			
			Cita c = new Cita();
			c.setAnotaciones(m[2].toString());
			
			MedicamentoPaciente mp = new MedicamentoPaciente();
			mp.setCita(c);
			mp.setMedicamento(med);
			
			medicamentos.add(mp);
			
		}
		
		return medicamentos;
		
	}
	
	/**
	 * Lista de examenes realizados a un paciente
	 * @param id identifiación del paciente
	 * @return la lista de examenes tomados por esta paciente
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ResultadoExamen> listaExamenes (String id){
		Query q = em.createNativeQuery("SELECT e.DESCRIPCION, c.ANOTACIONES, re.RESULTADO, "
				+ " SUBSTR(re.FECHA_HORA,0,2),  SUBSTR(re.FECHA_HORA,4,2), SUBSTR(re.FECHA_HORA,6,2)"
				+ "  FROM RESULTADO_EXAMEN re JOIN CITA c ON c.ID=re.CITA_ID JOIN EXAMEN e ON e.ID = re.EXAMEN_ID"
				+ "  JOIN TIPO_EXAMEN te ON te.EXAMEN_ID = e.TIPO_EXAMEN  WHERE c.PACIENTE_ID=?1");
		q.setParameter(1, id);
		
		List<ResultadoExamen> examenes = new ArrayList<ResultadoExamen>();
		List<Object[]> lista = q.getResultList();
		
		for (Object[] o : lista) {
			Examen e = new Examen();
			e.setDescripcion(o[0].toString());
			
			Cita c = new Cita();
			c.setAnotaciones(o[1].toString());
			
			ResultadoExamen re = new ResultadoExamen();
			re.setResultado(o[2].toString());
			Date fecha = new Date();
			
			fecha.setDate(Integer.parseInt(o[3].toString()));
			fecha.setMonth(Integer.parseInt(o[4].toString()));
			fecha.setYear(Integer.parseInt(o[5].toString()));
			
			re.setFechaHora(fecha);
			
			examenes.add(re);
			
		}
		
		return examenes;
		
	}
	
	/**
	 * Cirugias realizadas a un paciente
	 * @param id identificación del paciente
	 * @return la lista de cirugias del paciente
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<EncargadoCirugia> listaCirugias (String id){
		Query q = em.createNativeQuery(" SELECT cir.DESCRIPCION, c.ANOTACIONES, SUBSTR(cr.FECHA_HORA,0,2),"
				+ "  SUBSTR(cr.FECHA_HORA,4,2), SUBSTR(cr.FECHA_HORA,6,2), us.NOMBRE, us.APELLIDO"
				+ "  FROM ENCARGADO_CIRUGIA ec JOIN CIRUGIA_REALIZAR cr"
				+ "  ON cr.CIRUGIA_ID = ec.CIRUGIA_ID AND cr.CITA_ID=ec.CITA_ID"
				+ "  JOIN  PERSONAL_MEDICO pm ON pm.IDENTIFICACION = ec. PERSONAL_MEDICO_ID"
				+ "  JOIN USUARIO us ON us.IDENTIFICACION  = pm.IDENTIFICACION"
				+ "  JOIN CITA c ON c.ID=cr.CITA_ID JOIN CIRUGIA cir "
				+ "  ON cir.ID = cr.CIRUGIA_ID WHERE c.PACIENTE_ID=?1");
		q.setParameter(1, id);
		
		List<EncargadoCirugia> cirugias = new ArrayList<EncargadoCirugia>();
		List<Object[]> lista = q.getResultList();
		
		for (Object[] o : lista) {
			Cirugia cir = new Cirugia();
			cir.setDescripcion(o[0].toString());
			
			Cita c = new Cita();
			c.setAnotaciones(o[1].toString());
			
			CirugiaRealizar cr = new CirugiaRealizar();
			Date fecha = new Date();
			fecha.setDate(Integer.parseInt(o[2].toString()));
			fecha.setMonth(Integer.parseInt(o[3].toString()));
			fecha.setYear(Integer.parseInt(o[4].toString()));
			cr.setFechaHora(fecha);
			cr.setCirugia(cir);
			cr.setCita(c);
			
			PersonalMedico pm = new PersonalMedico();
			pm.setNombre(o[5].toString());
			pm.setApellido(o[6].toString());			
			
			EncargadoCirugia ec = new EncargadoCirugia();
			ec.setCirugia(cr);
			ec.setPersonalMedico(pm);
			
			cirugias.add(ec);
		}
		
		return cirugias;
		
	}
	
	/**
	 * Lsita las hospitalizaciones que ha tenido un paciente
	 * @param id Identificación del paciente
	 * @return las hospitalizaciones del paciente
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Hospitalizacion> listaHospitalizaciones(String id){
		Query q = em.createNativeQuery("SELECT SUBSTR(h.FECHA_ENTRADA,0,2), SUBSTR(h.FECHA_ENTRADA,4,2), "
				+ "SUBSTR(h.FECHA_ENTRADA,6,2), SUBSTR(h.FECHA_SALIDA,0,2), SUBSTR(h.FECHA_SALIDA,4,2), "
				+ "SUBSTR(h.FECHA_SALIDA,6,2), c.ANOTACIONES "
				+ "FROM HOSPITALIZACION h JOIN CITA c  ON c.ID = h.CITA_ID WHERE c.PACIENTE_ID =?1");
		q.setParameter(1, id);
		
		List<Hospitalizacion> hospitalizaciones = new ArrayList<Hospitalizacion>();
		List<Object[]> lista = q.getResultList();
		
		for (Object[] o : lista) {
			Cita c = new Cita();
			c.setAnotaciones(o[6].toString());
			
			Date fechaEntrada = new Date();
			fechaEntrada.setDate(Integer.parseInt(o[0].toString()));
			fechaEntrada.setMonth(Integer.parseInt(o[1].toString()));
			fechaEntrada.setYear(Integer.parseInt(o[2].toString()));
			
			Date fechaSalida = new Date();
			fechaSalida.setDate(Integer.parseInt(o[3].toString()));
			fechaSalida.setMonth(Integer.parseInt(o[4].toString()));
			fechaSalida.setYear(Integer.parseInt(o[5].toString()));
			
			Hospitalizacion h = new Hospitalizacion();
			h.setCita(c);
			h.setFechaEntrada(fechaEntrada);
			h.setFechaSalida(fechaSalida);
			
			hospitalizaciones.add(h);
			
		}
		
		return hospitalizaciones;
		
	}
	
}
