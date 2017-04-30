package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.negocio.beans.PersonalMedicoEJB;
import co.edu.eam.ingesoft.avanzada.negocio.exception.ExcepcionNegocio;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Especializacion;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.PersonalMedico;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.TipoPersonal;

@Named("controladorPersonal")
@ViewScoped
public class ControladorPersonalMedico implements Serializable {

	/**
	 * Número de identificación del usuario
	 */
	private int identificacion;

	/**
	 * Nombre del personal
	 */
	private String nombre;

	/**
	 * Apellido del usuario
	 */
	private String apellido;

	/**
	 * Dirección del usuario
	 */
	private String direccion;

	/**
	 * Teléfono del usuario
	 */
	private int telefono;

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
	 * Tipo de especialización seleccionado por el usuario
	 */
	private int tipoEspecializacionSel;

	/**
	 * Nombre de usuario del usuario
	 */
	private String username;

	/**
	 * Contraseña de usuario
	 */
	private String password;

	/**
	 * Número de celular del usuario
	 */
	private int celular;
	
	/**
	 * Correo electrónico del usuario
	 */
	private String email;

	/**
	 * EJB del personal médico
	 */
	private PersonalMedicoEJB personalEJB;

	/**
	 * Registra un personal médico en la base de datos
	 */
	public void registrar() {
		
		//Especializacion esp = 
		
		PersonalMedico p = new PersonalMedico();
		p.setApellido(apellido);
		p.setCelular(celular);
		p.setDireccion(direccion);
		p.setEmail(email);
		p.setIdentificacion(identificacion);
		p.setNombre(nombre);
		p.setPassword(password);
		p.setTelefono(telefono);
		p.setUsuario(username);
		try{
		personalEJB.registrar(p);
		} catch (ExcepcionNegocio e){
			Messages.addFlashGlobalInfo(e.getMessage());
		}
		
	}

	/**
	 * Limpia los campos del formulario de registro
	 */
	public void cancelar() {
		nombre = "";
		apellido = "";
		direccion = "";
		password = "";
		telefono = 0;
		username = "";
		celular=0;
		email="";
	}

	/**
	 * @return the identificacion
	 */
	public int getIdentificacion() {
		return identificacion;
	}

	/**
	 * @param identificacion
	 *            the identificacion to set
	 */
	public void setIdentificacion(int identificacion) {
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
	 * @param email the email to set
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
	public int getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono
	 *            the telefono to set
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the celular
	 */
	public int getCelular() {
		return celular;
	}

	/**
	 * @param celular
	 *            the celular to set
	 */
	public void setCelular(int celular) {
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
