package co.edu.eam.ingesoft.avanzada.negocio.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.eam.ingesoft.avanzada.negocio.exception.ExcepcionNegocio;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.PersonalMedico;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.TipoPersonal;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Usuario;

@LocalBean
@Stateless
public class PersonalMedicoEJB {

	@PersistenceContext
	private EntityManager em;

	@EJB
	UsuarioEJB usuarioEJB;
	/**
	 * Registra un personal médico en la base de datos
	 * @param p Personal médico a registrar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void registrar(PersonalMedico p) {
		Usuario user = usuarioEJB.buscarUsuario(p.getUsuario());
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
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public TipoPersonal buscarTipo (int id){
		return em.find(TipoPersonal.class, id);
	}
	
	/**
	 * Obtiene la lista de personal médico reigstrado
	 * @return la lista de personal registrado
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<PersonalMedico> listarPersonal(){
		Query q = em.createNamedQuery(PersonalMedico.LISTAR_PERSONAL);
		List<PersonalMedico> lista = q.getResultList();
		return lista;
	}
	
	/**
	 * Obtiene la lista de los tipos de personal registrados
	 * @return la lista 
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<TipoPersonal> listarTipos (){
		Query q = em.createNamedQuery(TipoPersonal.LISTAR_TIPOS);
		List<TipoPersonal> lista = q.getResultList();
		return lista;
	}
	
	/**
	 * Edita un personal médico
	 * @param p el personal médico a editar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void editar(PersonalMedico p) {
		em.merge(p);
	}
	
	/**
	 * Elimina un personal médico registrado
	 * @param per personal a eliminar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
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
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public PersonalMedico buscar(int id) {
		return em.find(PersonalMedico.class, id);
	}



}
