package co.edu.eam.ingesoft.avanzada.negocio.beans;

import java.util.Date;
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
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Cita;
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
	public PersonalMedico buscar(String id) {
		return em.find(PersonalMedico.class, id);
	}
	
	/**
	 * Lista las citas que tiene un médico
	 * @param id Identificación del médico
	 * @return la lista de citas del médico
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Cita> listaCitasPersonal (String id){
		Query q = em.createNamedQuery(Cita.LISTAR_CITAS_PERSONAL);
		q.setParameter(1, id);
		List<Cita> lista = q.getResultList();
		return lista;
	}

	/**
	 * Lista las citas que tiene un médico en una fecha determinada
	 * @param idPersonal Identificación del médico
	 * @param fecha Fecha de las citas que se desea buscar
	 * @return la lista de citas para esa fecha
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Cita> listaCitasPersonalFecha (String idPersonal, Date fecha){
		Query q = em.createNamedQuery(Cita.LISTAR_CITAS_MEDICO_FECHA);
		q.setParameter(1, idPersonal);
		q.setParameter(2, fecha);
		List<Cita> lista = q.getResultList();
		return lista;
	}

}
