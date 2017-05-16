package co.edu.eam.ingesoft.avanzada.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Usuario;

@LocalBean
@Stateless
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
		List<Usuario>us= em.createNamedQuery(Usuario.NOMBRE_USUARIO).setParameter(1, user).getResultList();
		if(us.isEmpty()){
			return null;
		}else{
			return us.get(0);
		}
	}
}
