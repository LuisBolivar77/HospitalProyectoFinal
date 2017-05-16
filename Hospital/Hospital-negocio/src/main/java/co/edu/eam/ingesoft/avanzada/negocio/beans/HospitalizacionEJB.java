package co.edu.eam.ingesoft.avanzada.negocio.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Cama;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Hospitalizacion;

@LocalBean
@Stateless
public class HospitalizacionEJB {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Da de alta a un paciente hospitalizado
	 * @param h la hospitalización del paciente
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void darSalida (Hospitalizacion h){
		Date fecha = new Date();
		h.setFechaSalida(fecha);
		em.merge(h);
		Cama c = h.getCama();
		c.setOcupada(false);
		em.merge(c);
	}
	
	/**
	 * Edita una hospitalización
	 * @param h hospitalización que se desea editar
	 */
	public void editar (Hospitalizacion h){
		em.merge(h);
	}
	
	/**
	 * Busca si un paciente esta hospitalizado
	 * @param idPaciente id del paciente que se desea buscar
	 * @return la hospitalización del paciente si la encuentra, de lo contrario null
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Hospitalizacion buscar (int idPaciente){
		Query q = em.createNativeQuery("SELECT h.id, h.cita_id, h.fecha_entrada, h.fecha_salida,"
				+ "h.cama_numero FROM hospitalizacion h JOIN cita c ON c.id=h.cita_id WHERE "
				+ "c.paciente_id = ?1 AND h.fecha_salida> ?2");
		q.setParameter(1, idPaciente);
		q.setParameter(2, new Date());
		List<Hospitalizacion> hospitalizaciones = q.getResultList();
		for (Hospitalizacion a : hospitalizaciones) {
		    if (a != null){
		    	return a;
		    }
		}
		return null;
	}
	
}
