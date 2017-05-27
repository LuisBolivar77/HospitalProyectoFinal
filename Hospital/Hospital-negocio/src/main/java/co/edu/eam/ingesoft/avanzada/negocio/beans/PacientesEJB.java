package co.edu.eam.ingesoft.avanzada.negocio.beans;

import java.util.ArrayList;
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
import co.edu.eam.ingesoft.avanzada.proyectoHospital.enumeraciones.TipoDocumento;

@LocalBean
@Stateless
public class PacientesEJB {

	@PersistenceContext
	private EntityManager em;

	@EJB
	UsuarioEJB usuarioEJB;
	
	@EJB
	EpsEJB epsEJB;

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
	 * Lista los usuarios que han solicitado un nombre de usuario
	 * @return la lista de usuarios solicitantes
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Paciente> solicitudesUsuarios (){
		Query q = em.createNativeQuery("SELECT u.IDENTIFICACION, u.TIPO_IDENTIFICACION, u.USERNAME, u.CONTRASENIA,"
				+ " u.NOMBRE, u.APELLIDO, u.EMAIL, u.TELEFONO, u.CELULAR, u.DIRECCION, u.ROL, p.EPS_ID "
				+ " FROM PACIENTE p JOIN USUARIO u "
				+ "ON p.IDENTIFICACION = u.IDENTIFICACION JOIN EPS e "
				+ "ON e.ID = p.EPS_ID WHERE p.USUARIO_ASIGNADO=0");
		List<Object[] > lista = q.getResultList();
		
		List<Paciente> pacientes = new ArrayList<Paciente>();
		
		for (Object[] o : lista) {
			
			Paciente u = new Paciente();
			
			u.setIdentificacion(o[0].toString());
			String tp = o[1].toString();
			if (tp.equals(TipoDocumento.Cedula)){
				u.setTipoDocumento(TipoDocumento.Cedula);
			} else if (tp.equals(TipoDocumento.CedulaExtranjeria)) {
				u.setTipoDocumento(TipoDocumento.CedulaExtranjeria);
			} else if (tp.equals(TipoDocumento.Pasaporte)){
				u.setTipoDocumento(TipoDocumento.Pasaporte);
			} else if (tp.equals(TipoDocumento.TarjetaIdentidad)){
				u.setTipoDocumento(TipoDocumento.TarjetaIdentidad);
			}		
			u.setUsuario(o[2].toString());
			u.setPassword(o[3].toString());
			u.setNombre(o[4].toString());
			u.setApellido(o[5].toString());
			u.setEmail(o[6].toString());
			u.setTelefono(o[7].toString());
			u.setCelular(o[8].toString());
			u.setDireccion(o[9].toString());
			u.setRol(o[10].toString());
			
			Eps eps = epsEJB.buscarEps(Integer.parseInt(o[11].toString()));
			u.setEps(eps);
			u.setUsuarioAsignado(false);
			
			pacientes.add(u);
			
		}
		
		return pacientes;
		
	}

	/**
	 * busca un paciente si esta registrado o no en la base de datos
	 * gg
	 * @param id
	 *            la identificacion por la que se le buscara
	 * @return el paciente
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Paciente buscarPaciente(String id) {
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
}
