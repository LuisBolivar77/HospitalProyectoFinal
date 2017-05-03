package co.edu.eam.ingesoft.avanzada.negocio.beans;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Especializacion;

public class EspecializacionEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Busca una especialización por su código
	 * @param cod Código de la especialización	
	 * @return la especialización si la encuentra, de lo contrario null
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Especializacion buscar(int cod){
		return em.find(Especializacion.class, cod);
	}
	
	/**
	 * Lista las especializaciones registradas
	 * @return las especializaciones
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Especializacion> listar(){
		Query q = em.createNamedQuery(Especializacion.LISTAR_ESPECIALIZACIONES);
		List<Especializacion> lista = q.getResultList();
		return lista;
	}

}
