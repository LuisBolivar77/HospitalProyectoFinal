package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.negocio.beans.EspecializacionEJB;
import co.edu.eam.ingesoft.avanzada.negocio.beans.PersonalMedicoEJB;
import co.edu.eam.ingesoft.avanzada.negocio.exception.ExcepcionNegocio;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Especializacion;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.PersonalMedico;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.TipoPersonal;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.enumeraciones.TipoDocumento;

@Named("controladorPersonal")
@ViewScoped
public class ControladorPersonalMedico implements Serializable {

	/**
	 * tipo documento seleccionado
	 */
	private TipoDocumento tipoSeleccionado;
	/**
	 * N�mero de identificaci�n del usuario
	 */
	private String identificacion;

	/**
	 * Nombre del personal
	 */
	private String nombre;

	/**
	 * Apellido del usuario
	 */
	private String apellido;

	/**
	 * Direcci�n del usuario
	 */
	private String direccion;

	/**
	 * Tel�fono del usuario
	 */
	private String telefono;

	/**
	 * Tipo de personal seleccionado por el usuario
	 */
	private int tipoPersonalSel;

	/**
	 * Lista de tipos de personal registrados
	 */
	private List<TipoPersonal> tiposPersonal;

	/**
	 * Lista de especializaciones registradas
	 */
	private List<Especializacion> especializaciones;

	/**
	 * Tipo de especializaci�n seleccionado por el usuario
	 */
	private int tipoEspecializacionSel;

	/**
	 * Nombre de usuario del usuario
	 */
	private String username;

	/**
	 * Contrase�a de usuario
	 */
	private String password;

	/**
	 * N�mero de celular del usuario
	 */
	private String celular;

	/**
	 * Correo electr�nico del usuario
	 */
	private String email;

	/**
	 * Personal que ha sido buscado
	 */
	private PersonalMedico personalEditar;

	/**
	 * Lsita del personal registrado
	 */
	private List<PersonalMedico> listaPersonal;

	/**
	 * EJB del personal m�dico
	 */
	@EJB
	private PersonalMedicoEJB personalEJB;

	/**
	 * EJB de especializaci�n
	 */
	@EJB
	private EspecializacionEJB especializacionEJB;

	@PostConstruct
	public void postContructor() {
		personalEditar = null;
		especializaciones = especializacionEJB.listar();
		tiposPersonal = personalEJB.listarTipos();
		// listaPersonal = personalEJB.listarPersonal();
	}

	public String redireccionarEditar(PersonalMedico per) {
		personalEditar = per;
		return "/paginas/seguro/RegistroPersonalMedico.xhtml?faces-redirect=true";
	}

	/**
	 * Identifica si se ha seleccionado la opci�n de editar
	 * 
	 * @return true si se seleccion� la opci�n editar, de lo contrario false
	 */
	public boolean isEditar() {
		return personalEditar != null;
	}

	/**
	 * Registra un personal m�dico en la base de datos
	 */
	public void registrar() {

		Especializacion esp = especializacionEJB.buscar(tipoEspecializacionSel);
		TipoPersonal tipo = personalEJB.buscarTipo(tipoPersonalSel);
		PersonalMedico per = new PersonalMedico(identificacion, tipoSeleccionado, username, password, nombre, apellido,
				email, telefono, celular, direccion, tipo, "medico");
		try {
			personalEJB.registrar(per);
			Messages.addFlashGlobalInfo("Registro exitoso");
		} catch (ExcepcionNegocio e) {
			Messages.addFlashGlobalError(e.getMessage());
		}

	}

	/**
	 * Busca un personal M�dico por su n�mero de identificaci�n
	 */
	public void buscar() {
		PersonalMedico per = personalEJB.buscar(identificacion);
		if (per != null) {
			personalEditar = per;
			nombre = per.getNombre();
			apellido = per.getApellido();
			direccion = per.getDireccion();
			email = per.getEmail();
			// tipoEspecializacionSel = per.getEspecializacion().getId();
			tipoPersonalSel = per.getTipoPersonal().getId();
			telefono = per.getTelefono();
			celular = per.getCelular();
			username = per.getUsuario();
			password = per.getPassword();
		} else {
			Messages.addFlashGlobalError("Este usuario no se encuentra registrado");
		}
	}

	/**
	 * Elimina un personal
	 * 
	 * @param pm
	 *            personal que se desea eliminar
	 */
	public void eliminarPersonal(PersonalMedico pm) {
		personalEJB.eliminar(pm);
		Messages.addFlashGlobalInfo("Se ha eliminado exitosamente");
	}

	/**
	 * Edita un personal
	 * 
	 * @param per
	 *            Personal que se desea editar
	 */
	public void editarPersonal(PersonalMedico per) {

		Especializacion esp = especializacionEJB.buscar(tipoEspecializacionSel);
		TipoPersonal tipo = personalEJB.buscarTipo(tipoPersonalSel);

		personalEditar.setApellido(apellido);
		personalEditar.setCelular(celular);
		personalEditar.setDireccion(direccion);
		personalEditar.setEmail(email);
		personalEditar.setIdentificacion(identificacion);
		personalEditar.setNombre(nombre);
		personalEditar.setPassword(password);
		personalEditar.setTelefono(telefono);
		personalEditar.setUsuario(username);
		// personalEditar.setEspecializacion(esp);
		personalEditar.setTipoPersonal(tipo);

		personalEJB.editar(personalEditar);
		Messages.addFlashGlobalInfo("Se ha editado exitosamente");

	}

	/**
	 * Limpia los campos del formulario de registro
	 */
	public void cancelar() {
		nombre = "";
		apellido = "";
		direccion = "";
		password = "";
		telefono = "";
		username = "";
		celular = "";
		email = "";
	}

	public TipoDocumento[] getTipos() {
		return TipoDocumento.values();
	}

	/**
	 * @return the listaPersonal
	 */
	public List<PersonalMedico> getListaPersonal() {
		return listaPersonal;
	}

	/**
	 * @param listaPersonal
	 *            the listaPersonal to set
	 */
	public void setListaPersonal(List<PersonalMedico> listaPersonal) {
		this.listaPersonal = listaPersonal;
	}

	/**
	 * @return the identificacion
	 */
	public String getIdentificacion() {
		return identificacion;
	}

	/**
	 * @param identificacion
	 *            the identificacion to set
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public co.edu.eam.ingesoft.avanzada.proyectoHospital.enumeraciones.TipoDocumento getTipoSeleccionado() {
		return tipoSeleccionado;
	}

	public void setTipoSeleccionado(
			co.edu.eam.ingesoft.avanzada.proyectoHospital.enumeraciones.TipoDocumento tipoSeleccionado) {
		this.tipoSeleccionado = tipoSeleccionado;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido
	 *            the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono
	 *            the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * @param celular
	 *            the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * @return the tipoPersonalSel
	 */
	public int getTipoPersonalSel() {
		return tipoPersonalSel;
	}

	/**
	 * @param tipoPersonalSel
	 *            the tipoPersonalSel to set
	 */
	public void setTipoPersonalSel(int tipoPersonalSel) {
		this.tipoPersonalSel = tipoPersonalSel;
	}

	/**
	 * @return the tiposPersonal
	 */
	public List<TipoPersonal> getTiposPersonal() {
		return tiposPersonal;
	}

	/**
	 * @param tiposPersonal
	 *            the tiposPersonal to set
	 */
	public void setTiposPersonal(List<TipoPersonal> tiposPersonal) {
		this.tiposPersonal = tiposPersonal;
	}

	/**
	 * @return the especializaciones
	 */
	public List<Especializacion> getEspecializaciones() {
		return especializaciones;
	}

	/**
	 * @param especializaciones
	 *            the especializaciones to set
	 */
	public void setEspecializaciones(List<Especializacion> especializaciones) {
		this.especializaciones = especializaciones;
	}

	/**
	 * @return the tipoEspecializacionSel
	 */
	public int getTipoEspecializacionSel() {
		return tipoEspecializacionSel;
	}

	/**
	 * @param tipoEspecializacionSel
	 *            the tipoEspecializacionSel to set
	 */
	public void setTipoEspecializacionSel(int tipoEspecializacionSel) {
		this.tipoEspecializacionSel = tipoEspecializacionSel;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
