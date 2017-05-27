package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import co.edu.eam.ingesoft.avanzada.proyectoHospital.enumeraciones.TipoDocumento;

@Entity
@Table(name = "USUARIO")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
	@NamedQuery(name=Usuario.NOMBRE_USUARIO, query="SELECT u FROM Usuario u WHERE u.usuario = ?1"),
	@NamedQuery(name = Usuario.BUSCAR_USUARIO, query = "SELECT u FROM Usuario u "
				+ "WHERE u.usuario=?1 AND u.password=?2")
})
public class Usuario implements Serializable {

	/**
	 * Busca un usuario por su nombre de usuario ?1: nombre de usuario
	 */
	public static final String NOMBRE_USUARIO = "Usuario.nombreUsuario";

	/**
	 * Busca un usuario por su nombre de usuario y contrase�a ?1: Nombre de
	 * usuario ?2: Contrase�a
	 */
	public static final String BUSCAR_USUARIO = "Usuario.buscar";

	@Id
	@Column(name = "IDENTIFICACION", length = 20, nullable = false)
	protected String identificacion;

	@Column(name = "TIPO_IDENTIFICACION")
	@Enumerated(EnumType.STRING)
	protected TipoDocumento tipoDocumento;

	@Column(name = "USERNAME", length = 30, nullable = false, unique = true)
	protected String usuario;

	@Column(name = "CONTRASENIA", length = 30, nullable = false)
	protected String password;

	@Column(name = "NOMBRE", length = 30, nullable = false)
	protected String nombre;

	@Column(name = "APELLIDO", length = 30, nullable = false)
	protected String apellido;

	@Column(name = "EMAIL", length = 30, nullable = false)
	protected String email;

	@Column(name = "TELEFONO", length = 30, nullable = false)
	protected String telefono;

	@Column(name = "CELULAR", length = 30)
	protected String celular;

	@Column(name = "DIRECCION", length = 30)
	protected String direccion;

	@Column(name = "ROL", length = 30)
	protected String rol;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(String identificacion, TipoDocumento tipoDocumento, String usuario, String password, String nombre,
			String apellido, String email, String telefono, String celular, String direccion, String rol) {
		super();
		this.identificacion = identificacion;
		this.tipoDocumento = tipoDocumento;
		this.usuario = usuario;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.celular = celular;
		this.direccion = direccion;
		this.rol = rol;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * @param rol
	 *            the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

}
