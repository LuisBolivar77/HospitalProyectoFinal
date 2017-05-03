package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import co.edu.eam.ingesoft.avanzada.proyectoHospital.enumeraciones.TipoDocumento;

@Entity
@Table(name = "PERSONAL_MEDICO")
@NamedQueries({
	@NamedQuery(name=PersonalMedico.LISTAR_PERSONAL, query="SELECT p FROM PersonalMedico p")
})
public class PersonalMedico extends Usuario implements Serializable {
	
	/**
	 * Obtiene la lista del personal registrado
	 */
	public static final String LISTAR_PERSONAL = "PersonalMedico.listar";

	@ManyToOne
	@JoinColumn(name = "TIPO_PERSONAL_ID")
	private TipoPersonal tipoPersonal;

	@ManyToOne
	@JoinColumn(name = "ESPECIALIZACION_ID", nullable = true)
	private Especializacion especializacion;
	
	public PersonalMedico() {
		// TODO Auto-generated constructor stub
	}

	public PersonalMedico(int identificacion, TipoDocumento tipoDocumento, String usuario, String password,
			String nombre, String apellido, String email, int telefono, int celular, String direccion,
			TipoPersonal tipoPersonal, Especializacion especializacion) {
		super(identificacion, tipoDocumento, usuario, password, nombre, apellido, email, telefono, celular, direccion);
		this.tipoPersonal = tipoPersonal;
		this.especializacion = especializacion;
	}

	public TipoPersonal getTipoPersonal() {
		return tipoPersonal;
	}

	public void setTipoPersonal(TipoPersonal tipoPersonal) {
		this.tipoPersonal = tipoPersonal;
	}

	public Especializacion getEspecializacion() {
		return especializacion;
	}

	public void setEspecializacion(Especializacion especializacion) {
		this.especializacion = especializacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((especializacion == null) ? 0 : especializacion.hashCode());
		result = prime * result + ((tipoPersonal == null) ? 0 : tipoPersonal.hashCode());
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
		PersonalMedico other = (PersonalMedico) obj;
		if (especializacion == null) {
			if (other.especializacion != null)
				return false;
		} else if (!especializacion.equals(other.especializacion))
			return false;
		if (tipoPersonal == null) {
			if (other.tipoPersonal != null)
				return false;
		} else if (!tipoPersonal.equals(other.tipoPersonal))
			return false;
		return true;
	}

}
