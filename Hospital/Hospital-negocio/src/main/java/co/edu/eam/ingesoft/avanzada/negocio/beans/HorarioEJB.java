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

import co.edu.eam.ingesoft.avanzada.negocio.exception.ExcepcionNegocio;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Horario;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.PersonalMedico;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.enumeraciones.DiaSemanaEnum;

@LocalBean
@Stateless
public class HorarioEJB {

	@PersistenceContext
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarHorario(Horario h) {
		System.out.println("Horara Inicio: " +h.getHoraInicio()+" Hora fin: " + h.getHoraFin() + " id: " + h.getId());
		Horario hr = em.find(Horario.class, h.getId());
		em.remove(hr);
	}

	/**
	 * Agrega un horario al médico
	 * 
	 * @param dia
	 *            Dia del horario
	 * @param horaInicio
	 *            Hora de incio del horario
	 * @param horaFin
	 *            Hora fin del horario
	 * @param pm
	 *            Personal médico al que se le registra el horario
	 */
	
	public void agregarHorario(DiaSemanaEnum dia, String horaInicio, String horaFin, PersonalMedico pm) {
		
		System.out.println("Dia: " + dia);

		int hInicio = Integer.parseInt(horaInicio.substring(0, 2));
		int minIncio = Integer.parseInt(horaInicio.substring(3, 5));
		int hFin = Integer.parseInt(horaFin.substring(0, 2));
		int minFin = Integer.parseInt(horaFin.substring(3, 5));

		boolean entro = false;
		
		List<Horario> horarios = horariosPersonal(pm.getIdentificacion());
		if (horarios.size() > 0) {
			for (Horario horario : horarios) {
				if (horario.getDiaSemana().equals(dia)) {
					if (horario.getHoraFin().getHours() < hInicio) {
						if (horario.getHoraFin().getMinutes() < minIncio) {
							entro = true;
						} else {
							throw new ExcepcionNegocio("No puede registrar este horario");
						}
					} else {
						throw new ExcepcionNegocio("No puede registrar este horario");
					}
				}
			} if (entro){
				registrar(dia, hInicio, minIncio, hFin, minFin, pm);
			}
		} else {
			registrar(dia, hInicio, minIncio, hFin, minFin, pm);
		}
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	private void registrar(DiaSemanaEnum dia, int hInicio, int minInicio, int hFin, int minFin, PersonalMedico pm){
		Horario h = new Horario();
		Date fechaInicio = agregarDiaSemana(dia);
		fechaInicio.setHours(hInicio);
		fechaInicio.setMinutes(minInicio);
		h.setHoraInicio(fechaInicio);

		Date fechaFin = agregarDiaSemana(dia);
		fechaFin.setHours(hFin);
		fechaFin.setMinutes(minFin);
		h.setHoraFin(fechaFin);
		h.setPersonalMedico(pm);
		h.setOcupado(false);

		em.persist(h);
	}
	
	private Date  agregarDiaSemana(DiaSemanaEnum dia){
		Date fecha = new Date();
		if (dia.equals("Lunes")){
			fecha.setDate(29);
			fecha.setMonth(05);
			fecha.setYear(2017);
		} else if (dia.equals("Martes")){
			fecha.setDate(30);
			fecha.setMonth(05);
			fecha.setYear(2017);
		} else if (dia.equals("Miercoles")){
			fecha.setDate(31);
			fecha.setMonth(05);
			fecha.setYear(2017);
		} else if (dia.equals("Jueves")){
			fecha.setDate(01);
			fecha.setMonth(06);
			fecha.setYear(2017);
		} else if (dia.equals("Viernes")){
			fecha.setDate(02);
			fecha.setMonth(06);
			fecha.setYear(2017);
		} else {
			fecha.setDate(03);
			fecha.setMonth(06);
			fecha.setYear(2017);
		}
		return fecha;
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Horario> horariosPersonal(String id) {
		Query q = em.createNativeQuery("SELECT TO_CHAR(h.HORA_INICIO,'DD'), TO_CHAR(h.HORA_INICIO,'MM'),"
				+ "  TO_CHAR(h.HORA_INICIO,'YYYY'), SUBSTR(h.HORA_INICIO,10,2), SUBSTR(h.HORA_INICIO,13,2),"
				+ "  SUBSTR(h.HORA_FIN,10,2), SUBSTR(h.HORA_FIN,13,2)  FROM HORARIO h JOIN PERSONAL_MEDICO pm"
				+ "  ON pm.IDENTIFICACION = h.PERSONAL_MEDICO_ID WHERE pm.IDENTIFICACION =?1");
		q.setParameter(1, id);

		List<Horario> horarios = new ArrayList<Horario>();
		List<Object[]> lista = q.getResultList();

		for (Object[] o : lista) {
			Horario h = new Horario();
			h.setId(Integer.parseInt(o[2].toString()));
			
			Date horaInicio = new Date();
			horaInicio.setDate(Integer.parseInt(o[0].toString()));
			horaInicio.setMonth(Integer.parseInt(o[1].toString()));
			horaInicio.setYear(Integer.parseInt(o[2].toString()));
			horaInicio.setHours(Integer.parseInt(o[3].toString()));
			horaInicio.setMinutes(Integer.parseInt(o[4].toString()));			

			Date horaFin = new Date();
			horaFin.setDate(Integer.parseInt(o[0].toString()));
			horaFin.setMonth(Integer.parseInt(o[1].toString()));
			horaFin.setYear(Integer.parseInt(o[2].toString()));
			horaFin.setHours(Integer.parseInt(o[5].toString()));
			horaFin.setMinutes(Integer.parseInt(o[6].toString()));

			h.setHoraInicio(horaInicio);
			h.setHoraFin(horaFin);

			horarios.add(h);

		}

		return horarios;

	}

}
