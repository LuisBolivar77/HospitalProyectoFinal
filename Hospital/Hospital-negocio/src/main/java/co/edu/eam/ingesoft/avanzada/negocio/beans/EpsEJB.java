package co.edu.eam.ingesoft.avanzada.negocio.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Eps;

@LocalBean
@Stateless
public class EpsEJB {

	@PersistenceContext
	private EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Eps buscarEps (int cod){
		return em.find(Eps.class, cod);
	}
	
}
