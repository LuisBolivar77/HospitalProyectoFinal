package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import co.edu.eam.ingesoft.avanzada.proyectoHospital.enumeraciones.TipoDocumento;

@Entity
@Table(name = "PACIENTE")
public class Paciente extends Usuario implements Serializable {

	@ManyToOne
	@JoinColumn(name = "EPS_ID", nullable = false)
	private Eps eps;

	@Column(name = "USUARIO_ASIGNADO")
	private boolean usuarioAsignado;
	
	public Paciente() {
		// TODO Auto-generated constructor stub
	}

	public Paciente(int identificacion, TipoDocumento tipoDocumento, String usuario, String password, String nombre,
			String apellido, String email, int telefono, int celular, String direccion, Eps eps,
			boolean usuarioAsignado) {
		super(identificacion, tipoDocumento, usuario, password, nombre, apellido, email, telefono, celular, direccion);
		this.eps = eps;
		this.usuarioAsignado = usuarioAsignado;
	}

	public Eps getEps() {
		return eps;
	}

	public void setEps(Eps eps) {
		this.eps = eps;
	}

	public boolean isUsuarioAsignado() {
		return usuarioAsignado;
	}

	public void setUsuarioAsignado(boolean usuarioAsignado) {
		this.usuarioAsignado = usuarioAsignado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((eps == null) ? 0 : eps.hashCode());
		result = prime * result + (usuarioAsignado ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (eps == null) {
			if (other.eps != null)
				return false;
		} else if (!eps.equals(other.eps))
			return false;
		if (usuarioAsignado != other.usuarioAsignado)
			return false;
		return true;
	}

}
