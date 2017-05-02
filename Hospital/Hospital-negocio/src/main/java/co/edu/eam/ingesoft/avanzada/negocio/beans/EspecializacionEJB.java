package co.edu.eam.ingesoft.avanzada.negocio.beans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Especializacion;

public class EspecializacionEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Busca una especializaci�n por su c�digo
	 * @param cod C�digo de la especializaci�n	
	 * @return la especializaci�n si la encuentra, de lo contrario null
	 */
	public Especializacion buscar(int cod){
		return em.find(Especializacion.class, cod);
	}
	
	/**
	 * Lista las especializaciones registradas
	 * @return las especializaciones
	 */
	public List<Especializacion> listar(){
		Query q = em.createNamedQuery(Especializacion.LISTAR_ESPECIALIZACIONES);
		List<Especializacion> lista = q.getResultList();
		return lista;
	}

}
