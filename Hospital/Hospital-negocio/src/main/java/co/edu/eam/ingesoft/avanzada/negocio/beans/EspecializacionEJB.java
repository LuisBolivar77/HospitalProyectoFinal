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
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Especializacion;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.EspecializacionPersonal;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.EspecializacionPersonalPK;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Quirofano;

@LocalBean
@Stateless
public class EspecializacionEJB {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Busca una especialización por su código
	 * 
	 * @param cod
	 *            Código de la especialización
	 * @return la especialización si la encuentra, de lo contrario null
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Especializacion buscar(int cod) {
		return em.find(Especializacion.class, cod);
	}

	/**
	 * Lista las especializaciones registradas
	 * 
	 * @return las especializaciones
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Especializacion> listar() {
		Query q = em.createNamedQuery(Especializacion.LISTAR_ESPECIALIZACIONES);
		List<Especializacion> lista = q.getResultList();
		return lista;
	}

	/**
	 * Registra una especializacionPersonal
	 * 
	 * @param e
	 *            especializacionPersonal que se desea registrar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void registrarEspecializacionPersonal(EspecializacionPersonal e) {
		EspecializacionPersonal buscado = buscarEspecializacionPersonal(e.getEspecializacion().getId(),
				e.getPersonal().getIdentificacion());
		if (buscado == null) {
			em.persist(e);
		} else {
			throw new ExcepcionNegocio("Esta persona ya se encuentra registrada con la misma especializacion");
		}
	}

	/**
	 * busca un personal con una especializacion
	 * @param numero el numero de la especializacion
	 * @param personal el personal al que se le va a buscar
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public EspecializacionPersonal buscarEspecializacionPersonal(int numero, String personal) {
		EspecializacionPersonalPK espe = new EspecializacionPersonalPK();
		espe.setEspecializacion(numero);
		espe.setPersonal(personal);
		return em.find(EspecializacionPersonal.class, espe);
	}

	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void editarEspecializacionPersonal(EspecializacionPersonal e) {
		em.merge(e);
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarEspecializacionPersonal(EspecializacionPersonal e) {
		em.remove(em.merge(e));
	}

}
