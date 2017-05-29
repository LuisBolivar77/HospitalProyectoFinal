package co.edu.eam.ingesoft.avanzada.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.eam.ingesoft.avanzada.negocio.exception.ExcepcionNegocio;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Cama;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Quirofano;

@LocalBean
@Stateless
public class InstalacionesEJB {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Registra un quirofano en la base de datos
	 * 
	 * @param q
	 *            quirofano que se desea registrar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void registrarQuirofano(Quirofano q) {
		Quirofano buscado = buscarQuirofano(q.getNumero());
		if (buscado == null) {
			em.persist(q);
		} else {
			throw new ExcepcionNegocio("Este quirófano ya se encuentra registrado");
		}
	}

	

	/**
	 * Busca un quirofano
	 * 
	 * @param numero
	 *            número del quirofano que se desea buscar
	 * @return el quirófano si lo encuentra, de lo contrario null
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Quirofano buscarQuirofano(int numero) {
		return em.find(Quirofano.class, numero);
	}

	/**
	 * Edita un quirofano
	 * 
	 * @param q
	 *            quirofano que se desea editar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void editarQuirofano(Quirofano q) {
		em.merge(q);
	}

	/**
	 * Elimina un quirófano
	 * 
	 * @param q
	 *            quirófano que se desea eliminar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarQuirofano(Quirofano q) {
		em.remove(em.merge(q));
	
	}

	/**
	 * lista de las camas disponibles
	 * 
	 * @return la lista
	 */
	public List<Cama> listarCamas() {
		Query q = em.createNamedQuery(Cama.listarCamasDisponibles);
		List<Cama> lista = q.getResultList();
		return lista;
	}
	
	/**
	 * lista de las camas 
	 * 
	 * @return la lista
	 */
	public List<Cama> listaDeCamas() {
		Query q = em.createNamedQuery(Cama.ListaDeCamas);
		List<Cama> lista = q.getResultList();
		return lista;
	}

	/**
	 * lista de las camas por numero
	 * 
	 * @return la lista
	 */
	public List<Cama> listaDeCamasPorNumero(int num) {
		Query q = em.createNamedQuery(Cama.listarCamaPorNumero);
		q.setParameter(1, num);
		List<Cama> lista = q.getResultList();
		return lista;
	}
	
	/**
	 * lista de todos los quirofanos
	 * @return la lista 
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Quirofano> listarQuirofanos() {
		Query q = em.createNamedQuery(Quirofano.ListarQuirofanos);
		List<Quirofano> lista = q.getResultList();
		return lista;
	}
	
	/**
	 * lista de un quirofano
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Quirofano>quirofanoPorNumero(int num){
		Query q = em.createNamedQuery(Quirofano.quirofanoPorNumero);
		q.setParameter(1, num);
		List<Quirofano>lista = q.getResultList();
		return lista;
	}
	
	
	/**
	 * Registra una cama en la base de datos
	 * 
	 * @param c
	 *            cama que se desea registrar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void registrarCama(Cama c) {
		Cama buscado = buscarCama(c.getNumero());
		if (buscado == null) {
			em.persist(c);
		} else {
			throw new ExcepcionNegocio("Esta cama ya se encuentra registradaS");
		}
	}
	
	/**
	 * metodo que busca una cama
	 * @param id codigo por el que se va a buscar
	 * @return la cama
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Cama buscarCama(int id) {
		return em.find(Cama.class, id);
	}
	
	/**
	 * Edita una cama
	 * 
	 * @param c
	 *            cama que se desea editar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void editarCama(Cama c) {
		em.merge(c);
	}

	/**
	 * Elimina una cama
	 * 
	 * @param c
	 *            cama que se desea eliminar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarCama(Cama c) {
		em.remove(em.merge(c));
	
	}
}
