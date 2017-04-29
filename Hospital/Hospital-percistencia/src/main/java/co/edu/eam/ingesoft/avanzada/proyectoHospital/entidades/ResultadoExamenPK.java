package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

public class ResultadoExamenPK implements Serializable {

	private int examen;

	private int ordenMedica;

	public ResultadoExamenPK() {

	}

	public ResultadoExamenPK(int examen, int ordenMedica) {
		super();
		this.examen = examen;
		this.ordenMedica = ordenMedica;
	}

	public int getExamen() {
		return examen;
	}

	public void setExamen(int examen) {
		this.examen = examen;
	}

	public int getOrdenMedica() {
		return ordenMedica;
	}

	public void setOrdenMedica(int ordenMedica) {
		this.ordenMedica = ordenMedica;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + examen;
		result = prime * result + ordenMedica;
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
		ResultadoExamenPK other = (ResultadoExamenPK) obj;
		if (examen != other.examen)
			return false;
		if (ordenMedica != other.ordenMedica)
			return false;
		return true;
	}
	
	

}
