package co.edu.eam.ingesoft.avanzada.negocio.beans;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Usuario;

public class UsuarioEJB {

	
	@PersistenceContext
	private EntityManager em;
	
	
	/**
	 * Busca un usuario por su nombre de usuario
	 * 
	 * @param user
	 *            nombre de usuario
	 * @return el usuario si lo encuentra, de lo contrario null
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Usuario buscarUsuario(String user) {
		Query q = em.createNamedQuery(Usuario.NOMBRE_USUARIO);
		q.setParameter(user, 1);
		List<Usuario> lista = q.getResultList();
		return lista.get(0);
	}
}
