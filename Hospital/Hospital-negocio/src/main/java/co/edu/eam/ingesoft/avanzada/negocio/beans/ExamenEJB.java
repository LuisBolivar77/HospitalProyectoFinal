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
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Examen;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.TipoExamen;


@LocalBean
@Stateless
public class ExamenEJB {
	
	@PersistenceContext
	private EntityManager em;
	

	/**
	 * Registra una patologia en la base de datos
	 * 
	 * @param p
	 *            Patologia que se desea registrar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void registrarExamen(Examen p) {
		Examen buscado = buscarExamen(p.getId());
		if (buscado == null) {
			em.persist(p);
		} else {
			throw new ExcepcionNegocio("esta patologia ya se encuentra registrada");
		}
	}

	

	/**
	 * Busca una patologia
	 * 
	 * @param cod
	 *            codigo de la patologia que se desea buscar
	 * @return la patologia si lo encuentra, de lo contrario null
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Examen buscarExamen(int cod) {
		return em.find(Examen.class, cod);
	}

	/**
	 * Edita una patologia
	 * 
	 * @param p
	 *            patologia que se desea editar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void editarExamen(Examen p) {
		em.merge(p);
	}

	/**
	 * Elimina una patologia
	 * 
	 * @param p
	 *            patologia que se desea eliminar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarExamen(Examen p) {
		em.remove(em.merge(p));
	
	}
	
	/**
	 * lista de las patologias disponibles
	 * 
	 * @return la lista
	 */
	public List<TipoExamen> listarTipoExamenes() {
		Query q = em.createNamedQuery(TipoExamen.listarTiposExamen);
		List<TipoExamen> lista = q.getResultList();
		return lista;
	}
	
	/**
	 * lista de las patologias disponibles
	 * 
	 * @return la lista
	 */
	public List<Examen> listarExamenes() {
		Query q = em.createNamedQuery(Examen.listaExamenes);
		List<Examen> lista = q.getResultList();
		return lista;
	}
	
	

}
