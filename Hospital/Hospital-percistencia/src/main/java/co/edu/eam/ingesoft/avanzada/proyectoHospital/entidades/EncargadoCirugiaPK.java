package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

public class EncargadoCirugiaPK implements Serializable {

	private CirugiaRealizarPK cirugia;

	private int personalMedico;

	public EncargadoCirugiaPK() {

	}

	
	public EncargadoCirugiaPK(CirugiaRealizarPK cirugia, int personalMedico) {
		super();
		this.cirugia = cirugia;
		this.personalMedico = personalMedico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cirugia == null) ? 0 : cirugia.hashCode());
		result = prime * result + personalMedico;
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
		EncargadoCirugiaPK other = (EncargadoCirugiaPK) obj;
		if (cirugia == null) {
			if (other.cirugia != null)
				return false;
		} else if (!cirugia.equals(other.cirugia))
			return false;
		if (personalMedico != other.personalMedico)
			return false;
		return true;
	}

}
