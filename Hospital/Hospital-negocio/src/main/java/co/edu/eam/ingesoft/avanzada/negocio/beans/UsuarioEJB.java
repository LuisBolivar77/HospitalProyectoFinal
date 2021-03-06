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
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Usuario;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.enumeraciones.TipoDocumento;

@LocalBean
@Stateless
public class UsuarioEJB {

	@PersistenceContext
	private EntityManager em;
	
	
	/**
	 * Registra una patologia en la base de datos
	 * 
	 * @param p
	 *            Patologia que se desea registrar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void registrarUsuario(Usuario p) {
		Usuario usu = buscarUsuario(p.getIdentificacion());
		if (usu == null) {
			em.persist(p);
		} else {
			throw new ExcepcionNegocio("esta patologia ya se encuentra registrada");
		}
	}

	/**
	 * Busca un usuario por su nombre de usuario
	 * 
	 * @param user
	 *            nombre de usuario
	 * @return el usuario si lo encuentra, de lo contrario null
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Usuario buscarUsuario(String user) {
		Query q = em.createNativeQuery("SELECT u.IDENTIFICACION, u.TIPO_IDENTIFICACION, u.USERNAME, u.CONTRASENIA,"
				+ " u.NOMBRE, u.APELLIDO, u.EMAIL, u.TELEFONO, u.CELULAR, u.DIRECCION, u.ROL "
				+ "FROM USUARIO u WHERE u.USERNAME=?1");
		q.setParameter(1, user);
		List<Object[]> lista = q.getResultList();
		if (lista.size() == 0){
			return null;
		} 
		
		Object[] us = (Object[]) q.getSingleResult();
		Usuario u = new Usuario();
		u.setIdentificacion(us[0].toString());
		String tp = us[1].toString();
		if (tp.equals(TipoDocumento.Cedula)) {
			u.setTipoDocumento(TipoDocumento.Cedula);
		} else if (tp.equals(TipoDocumento.CedulaExtranjeria)) {
			u.setTipoDocumento(TipoDocumento.CedulaExtranjeria);
		} else if (tp.equals(TipoDocumento.Pasaporte)) {
			u.setTipoDocumento(TipoDocumento.Pasaporte);
		} else if (tp.equals(TipoDocumento.TarjetaIdentidad)) {
			u.setTipoDocumento(TipoDocumento.TarjetaIdentidad);
		}
		u.setUsuario(us[2].toString());
		u.setPassword(us[3].toString());
		u.setNombre(us[4].toString());
		u.setApellido(us[5].toString());
		u.setEmail(us[6].toString());
		u.setTelefono(us[7].toString());
		u.setCelular(us[8].toString());
		u.setDireccion(us[9].toString());
		u.setRol(us[10].toString());

		return u;
	}

	/**
	 * Busca un usuario por username y password
	 * 
	 * @param user
	 *            Nombre de usuario
	 * @param pass
	 *            Contrase�a
	 * @return el usuario si lo encuentra, de lo contrario null
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Usuario buscar(String user, String pass) {
		Query q = em.createNamedQuery(Usuario.BUSCAR_USUARIO);
		q.setParameter(1, user);
		q.setParameter(2, pass);
		List<Usuario> lista = q.getResultList();
		return lista.get(0);
	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	public Usuario buscarUsuarioLogIn(String user) {
		List<Usuario> us = em.createNamedQuery(Usuario.NOMBRE_USUARIO).setParameter(1, user).getResultList();
		if (us.isEmpty()) {
			return null;
		} else {
			return us.get(0);
		}
	}

}
