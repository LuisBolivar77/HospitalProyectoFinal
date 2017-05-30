package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;
import java.util.Date;

public class HorarioMedicoPK  implements Serializable{

	private String diaSemana;
	
	private Date horaInicio;
	
	public HorarioMedicoPK() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the diaSemana
	 */
	public String getDiaSemana() {
		return diaSemana;
	}

	/**
	 * @param diaSemana the diaSemana to set
	 */
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	/**
	 * @return the horaInicio
	 */
	public Date getHoraInicio() {
		return horaInicio;
	}

	/**
	 * @param horaInicio the horaInicio to set
	 */
	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diaSemana == null) ? 0 : diaSemana.hashCode());
		result = prime * result + ((horaInicio == null) ? 0 : horaInicio.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HorarioMedicoPK other = (HorarioMedicoPK) obj;
		if (diaSemana == null) {
			if (other.diaSemana != null)
				return false;
		} else if (!diaSemana.equals(other.diaSemana))
			return false;
		if (horaInicio == null) {
			if (other.horaInicio != null)
				return false;
		} else if (!horaInicio.equals(other.horaInicio))
			return false;
		return true;
	}
	
	
	
}
