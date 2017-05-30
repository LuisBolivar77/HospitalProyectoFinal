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
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Patologia;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.PatologiaPaciente;

@LocalBean
@Stateless
public class PatologiaEJB {

	@PersistenceContext
	private EntityManager em;
	

	/**
	 * Registra una patologia en la base de datos
	 * 
	 * @param p
	 *            Patologia que se desea registrar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void registrarPatologia(Patologia p) {
		Patologia buscado = buscarPatologia(p.getId());
		if (buscado == null) {
			em.persist(p);
		} else {
			throw new ExcepcionNegocio("esta patologia ya se encuentra registrada");
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void registrarPatologiaPaciente (PatologiaPaciente pp){
		em.persist(pp);
	}
	

	/**
	 * Busca una patologia
	 * 
	 * @param cod
	 *            codigo de la patologia que se desea buscar
	 * @return la patologia si lo encuentra, de lo contrario null
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Patologia buscarPatologia(int cod) {
		return em.find(Patologia.class, cod);
	}

	/**
	 * Edita una patologia
	 * 
	 * @param p
	 *            patologia que se desea editar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void editarPatologia(Patologia p) {
		em.merge(p);
	}

	/**
	 * Elimina una patologia
	 * 
	 * @param p
	 *            patologia que se desea eliminar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarPatologia(Patologia p) {
		em.remove(em.merge(p));
	
	}
	
	/**
	 * lista de las patologias disponibles
	 * 
	 * @return la lista
	 */
	public List<Patologia> listarPatologias() {
		Query q = em.createNamedQuery(Patologia.ListarPatologias);
		List<Patologia> lista = q.getResultList();
		return lista;
	}
	
	/**
	 * lista de la patolgia disponible por numero
	 * 
	 * @return la lista
	 */
	public List<Patologia> listarPatologiaPorNumero(int cod) {
		Query q = em.createNamedQuery(Patologia.ListarPatologiasPorNumero);
		List<Patologia> lista = q.getResultList();
		q.setParameter(1, cod);
		return lista;
	}
}
