package co.edu.eam.ingesoft.avanzada.negocio.beans;

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
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Quirofano;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.TipoCirugia;

@LocalBean
@Stateless
public class CirugiaEJB {

	@PersistenceContext
	private EntityManager em;

	/**
	 * lista los quirofanos disponibles 
	 * @return la lista de los quirofanos disponibles
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Quirofano> quirofanosDisponibles() {
		Query q = em.createNamedQuery(Quirofano.ListarQuirofanosDispon);
		List<Quirofano> lista = q.getResultList();
		return lista;
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Quirofano buscarQuirofano (int id){
		return em.find(Quirofano.class, id);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void registrarCirugiaRealizar (CirugiaRealizar cr){
		em.persist(cr);
	}
	
	/**
	 * lista los tipos de cirugias que hay en la base de datos
	 * @return la lista de los tipos de cirugias
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<TipoCirugia>tipoDeCirugia(){
		Query q = em.createNamedQuery(TipoCirugia.listaCirugias);
		List<TipoCirugia> lista = q.getResultList();
		return lista;
	}
	
	/**
	 * lista las cirugias que hay en la base de datos
	 * @return la lista de cirugias
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Cirugia>listarCirugias(){
		Query q = em.createNamedQuery(Cirugia.listarCirugias);
		List<Cirugia> lista = q.getResultList();
		return lista;
	}
	
}
