package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PATOLOGIA_PACIENTE")
@IdClass(PatologiaPacientePK.class)
public class PatologiaPaciente implements Serializable {

	@Id
	@JoinColumn(name = "PATOLOGIA_ID")
	@ManyToOne
	private Patologia patologia;

	@Id
	@ManyToOne
	@JoinColumn(name = "CITA_ID")
	private Cita cita;

	public PatologiaPaciente() {
		// TODO Auto-generated constructor stub
	}

	public PatologiaPaciente(Patologia patologia, Cita cita) {
		super();
		this.patologia = patologia;
		this.cita = cita;
	}

	public Patologia getPatologia() {
		return patologia;
	}

	public void setPatologia(Patologia patologia) {
		this.patologia = patologia;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cita == null) ? 0 : cita.hashCode());
		result = prime * result + ((patologia == null) ? 0 : patologia.hashCode());
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
		PatologiaPaciente other = (PatologiaPaciente) obj;
		if (cita == null) {
			if (other.cita != null)
				return false;
		} else if (!cita.equals(other.cita))
			return false;
		if (patologia == null) {
			if (other.patologia != null)
				return false;
		} else if (!patologia.equals(other.patologia))
			return false;
		return true;
	}

}
