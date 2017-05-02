package co.edu.eam.ingesoft.avanzada.negocio.beans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.eam.ingesoft.avanzada.negocio.exception.ExcepcionNegocio;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.PersonalMedico;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.TipoPersonal;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Usuario;

public class PersonalMedicoEJB {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Registra un personal médico en la base de datos
	 * @param p Personal médico a registrar
	 */
	public void registrar(PersonalMedico p) {
		Usuario user = buscarUsuario(p.getUsuario());
		PersonalMedico perBus = buscar(p.getIdentificacion());
		if (perBus != null) {
			throw new ExcepcionNegocio("Este usario ya se encuentra registrado");
		} else if (user != null){
			throw new ExcepcionNegocio("Ya existe este nombre de usario");
		} else {
			em.persist(p);
		}
	}
	
	/**
	 * Busca el tipo de personal de un personal médico
	 * @param id código del tipo de personal
	 * @return el tipo de personal si lo encuentra, de lo contrario null
	 */
	public TipoPersonal buscarTipo (int id){
		return em.find(TipoPersonal.class, id);
	}
	
	/**
	 * Obtiene la lista de los tipos de personal registrados
	 * @return la lista 
	 */
	public List<TipoPersonal> listarTipos (){
		Query q = em.createNamedQuery(TipoPersonal.LISTAR_TIPOS);
		List<TipoPersonal> lista = q.getResultList();
		return lista;
	}
	
	/**
	 * Edita un personal médico
	 * @param p el personal médico a editar
	 */
	public void editar(PersonalMedico p) {
		em.merge(p);
	}
	
	/**
	 * Elimina un personal médico registrado
	 * @param per personal a eliminar
	 */
	public void eliminar(PersonalMedico per){
		em.remove(per);
	}

	/**
	 * Busca un personal médico en la base de datos
	 * 
	 * @param id
	 *            número de identificación del usuario
	 * @return el personal si lo encuentra, de lo contrario null
	 */
	public PersonalMedico buscar(int id) {
		return em.find(PersonalMedico.class, id);
	}

	/**
	 * Busca un usuario por su nombre de usuario
	 * 
	 * @param user
	 *            nombre de usuario
	 * @return el usuario si lo encuentra, de lo contrario null
	 */
	public Usuario buscarUsuario(String user) {
		Query q = em.createNamedQuery(Usuario.NOMBRE_USUARIO);
		q.setParameter(user, 1);
		List<Usuario> lista = q.getResultList();
		return lista.get(0);
	}

}
