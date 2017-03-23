package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

public class SintomaPatologiaPK {
	
	private int sintoma;
	
	private int patologia;

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + patologia;
		result = prime * result + sintoma;
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
		SintomaPatologiaPK other = (SintomaPatologiaPK) obj;
		if (patologia != other.patologia)
			return false;
		if (sintoma != other.sintoma)
			return false;
		return true;
	}	

}
