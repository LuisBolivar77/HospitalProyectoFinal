package co.edu.eam.ingesoft.avanzada.negocio.beans;

import java.util.ArrayList;
import java.util.Calendar;
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
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Horario buscarHorario(int id){
		return em.find(Horario.class, id);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarHorario(int h) {
		Horario hr = buscarHorario(h);
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
					if (hInicio>horario.getHoraInicio().getHours() && hInicio<horario.getHoraFin().getHours()) {
						throw new ExcepcionNegocio("No puede registrar este horario");						
						} else if (minIncio>horario.getHoraInicio().getMinutes() && minIncio<horario.getHoraFin().getMinutes()){
							throw new ExcepcionNegocio("No puede registrar este horario");
					} else if (hFin>horario.getHoraInicio().getHours() && hFin<horario.getHoraFin().getHours()) {
						throw new ExcepcionNegocio("No puede registrar este horario");
					} else {
						entro = true;
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
		h.setDiaSemana("Martes");
		
		Date fechaInicio = new Date();
		fechaInicio.setHours(hInicio);
		fechaInicio.setMinutes(minInicio);
		
		Date fechaFin = new Date();
		fechaFin.setHours(hFin);
		fechaFin.setMinutes(minFin);
		
		h.setHoraInicio(fechaInicio);
		h.setHoraFin(fechaFin);

		em.persist(h);
	}
	

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Horario> horariosPersonal(String id) {
		Query q = em.createNativeQuery("SELECT hm.DIA_SEMANA, SUBSTR(hm.HORA_INICIO,10,2), SUBSTR(hm.HORA_INICIO,13,2), "
				+ "SUBSTR(hm.HORA_FIN,10,2), SUBSTR(hm.HORA_FIN,13,2)"
				+ "  FROM HORARIO_MEDICO hm WHERE hm.PERSONAL_MEDICO_ID=?1");
		q.setParameter(1, id);

		List<Horario> horarios = new ArrayList<Horario>();
		List<Object[]> lista = q.getResultList();

		for (Object[] o : lista) {
			Horario h = new Horario();
			
			h.setDiaSemana(o[0].toString());
			
			Date horaInicio = new Date();
			horaInicio.setHours(Integer.parseInt(o[1].toString()));
			horaInicio.setMinutes(Integer.parseInt(o[2].toString()));			

			Date horaFin = new Date();
			horaFin.setHours(Integer.parseInt(o[3].toString()));
			horaFin.setMinutes(Integer.parseInt(o[4].toString()));

			h.setHoraInicio(horaInicio);
			h.setHoraFin(horaFin);

			horarios.add(h);

		}

		return horarios;

	}

}
