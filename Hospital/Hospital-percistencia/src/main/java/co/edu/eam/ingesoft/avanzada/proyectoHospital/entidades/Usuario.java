package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import co.edu.eam.ingesoft.avanzada.proyectoHospital.enumeraciones.TipoDocumento;

@Entity
@Table(name = "USUARIO")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
	@NamedQuery(name=Usuario.NOMBRE_USUARIO, query="SELECT u FROM Usuario u WHERE u.usuario=?1")
})
public class Usuario implements Serializable {
	
	/**
	 * Busca un usuario por su nombre de usuario
	 * ?1: nombre de usuario
	 */
	public static final String NOMBRE_USUARIO = "Usuario.nombreUsuario";

	@Id
	@Column(name = "IDENTIFICACION", length = 20, nullable = false)
	protected int identificacion;

	@Column(name = "TIPO_IDENTIFICACION")
	@Enumerated(EnumType.STRING)
	protected TipoDocumento tipoDocumento;

	@Column(name = "USER", length = 30, nullable = false, unique = true)
	protected String usuario;

	@Column(name = "PASSWORD", length = 30, nullable = false)
	protected String password;

	@Column(name = "NOMBRE", length = 30, nullable = false)
	protected String nombre;

	@Column(name = "APELLIDO", length = 30, nullable = false)
	protected String apellido;

	@Column(name = "EMAIL", length = 30, nullable = false)
	protected String email;

	@Column(name = "TELEFONO", length = 30, nullable = false)
	protected int telefono;

	@Column(name = "CELULAR", length = 30)
	protected int celular;

	@Column(name = "DIRECCION", length = 30)
	protected String direccion;
	
	@Column(name="ROL", length=30)
	protected String rol;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(int identificacion, TipoDocumento tipoDocumento, String usuario, String password, String nombre,
			String apellido, String email, int telefono, int celular, String direccion, String rol) {
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

	public int getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(int identificacion) {
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

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
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
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + celular;
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + identificacion;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + telefono;
		result = prime * result + ((tipoDocumento == null) ? 0 : tipoDocumento.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (celular != other.celular)
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (identificacion != other.identificacion)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (telefono != other.telefono)
			return false;
		if (tipoDocumento != other.tipoDocumento)
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	

}
