package co.edu.eam.ingesoft.avanzada.negocio.beans;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.avanzada.negocio.exception.ExcepcionNegocio;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Quirofano;

public class InstalacionesEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Registra un quirofano en la base de datos
	 * @param q quirofano que se desea registrar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void registrarQuirofano (Quirofano q){
		Quirofano buscado = buscarQuirofano(q.getId());
		if (buscado == null){
		em.persist(q);
		} else {
			throw new ExcepcionNegocio("Este quirófano ya se encuentra registrado");
		}
	}
	
	/**
	 * Busca un quirofano
	 * @param numero número del quirofano que se desea buscar
	 * @return el quirófano si lo encuentra, de lo contrario null
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Quirofano buscarQuirofano (int numero){
		return em.find(Quirofano.class, numero);
	}
	
	/**
	 * Edita un quirofano
	 * @param q quirofano que se desea editar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void editarQuirofano (Quirofano q){
		em.merge(q);
	}
	
	/**
	 * Elimina un quirófano
	 * @param q quirófano que se desea eliminar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarQuirofano (Quirofano q){
		em.remove(q);
	}

}
