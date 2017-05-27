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
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Eps;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Paciente;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Usuario;

@LocalBean
@Stateless
public class PacientesEJB {

	@PersistenceContext
	private EntityManager em;

	@EJB
	UsuarioEJB usuarioEJB;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void registrarPaciente(Paciente p) {

		Usuario usu = usuarioEJB.buscarUsuario(p.getIdentificacion() + "");
		Paciente pa = buscarPaciente(p.getIdentificacion());
		if (usu != null) {
			throw new ExcepcionNegocio("Ya existe este nombre de usario");
		} else if (pa != null) {
			throw new ExcepcionNegocio("Este paciente ya se encuentra registrado");
		}else{
			em.persist(p);
		}

	}

	/**
	 * busca un paciente si esta registrado o no en la base de datos
	 * 
	 * @param id
	 *            la identificacion por la que se le buscara
	 * @return el paciente
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Paciente buscarPaciente(int id) {
		return em.find(Paciente.class, id);
	}
	
	
	/**
	 * Edita un paciente
	 * @param p el paciente a editar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void editar(Paciente p) {
		em.merge(p);
	}
	
	/**
	 * Elimina un paciente registrado
	 * @param pa paciente a eliminar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminar(Paciente pa){
		em.remove(pa);
	}
	
	/**
	 * metodo que lista las eps
	 * @return la lista de eps
	 */
	public List<Eps>listarEps(){
	Query q = em.createNamedQuery(Eps.LISTAR_EPS);
	List<Eps> lista =  q.getResultList();
	return lista;
	}
	
//	public List<Paciente> listadoPeticionesRegistro (){
//		
//		Query q = em.createNativeQuery("", arg1)
//		
//		
//		
//		
//		
//	}
	
}
