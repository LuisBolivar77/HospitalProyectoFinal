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
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Usuario;

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
	 * Personal que ha sido buscado
	 */
	private PersonalMedico buscado;

	/**
	 * EJB del personal médico
	 */
	@EJB
	private PersonalMedicoEJB personalEJB;
	
	/**
	 * EJB de especialización
	 */
	@EJB
	private EspecializacionEJB especializacionEJB;
	
	@PostConstruct
	public void postContructor (){
		buscado = null;
		especializaciones = especializacionEJB.listar();
		tiposPersonal = personalEJB.listarTipos();
	}
	

	/**
	 * Registra un personal médico en la base de datos
	 */
	public void registrar() {
		
		Especializacion esp = especializacionEJB.buscar(tipoEspecializacionSel);
		TipoPersonal tipo = personalEJB.buscarTipo(tipoPersonalSel);
		
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
		p.setEspecializacion(esp);
		p.setTipoPersonal(tipo);
		
		try{
		personalEJB.registrar(p);
		Messages.addFlashGlobalInfo("Registro exitoso");
		} catch (ExcepcionNegocio e){
			Messages.addFlashGlobalError(e.getMessage());
		}
		
	}
	
	/**
	 * Busca un personal Médico por su número de identificación
	 */
	public void buscar(){
		PersonalMedico per = personalEJB.buscar(identificacion);
		if (per != null){
			buscado = per;
			nombre = per.getNombre();
			apellido = per.getApellido();
			direccion = per.getDireccion();
			email = per.getEmail();
			tipoEspecializacionSel = per.getEspecializacion().getId();
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
	 * Permite editar el personal médico registrado
	 */
	public void editar(){
		if (buscado == null){
			Messages.addFlashGlobalError("Debe buscar antes de editar");
		} else {
			Especializacion esp = especializacionEJB.buscar(tipoEspecializacionSel);
			TipoPersonal tipo = personalEJB.buscarTipo(tipoPersonalSel);
			
			buscado.setApellido(apellido);
			buscado.setCelular(celular);
			buscado.setDireccion(direccion);
			buscado.setEmail(email);
			buscado.setIdentificacion(identificacion);
			buscado.setNombre(nombre);
			buscado.setPassword(password);
			buscado.setTelefono(telefono);
			buscado.setUsuario(username);
			buscado.setEspecializacion(esp);
			buscado.setTipoPersonal(tipo);
			
			personalEJB.editar(buscado);
			Messages.addFlashGlobalInfo("Se ha editado exitosamente");
			
		}
	}
	
	public void eliminar (){
		if (buscado == null){
			Messages.addFlashGlobalError("Debe buscar antes de eliminar");
		} else {
			personalEJB.eliminar(buscado);
			Messages.addFlashGlobalInfo("Se ha eliminado exitosamente");
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
