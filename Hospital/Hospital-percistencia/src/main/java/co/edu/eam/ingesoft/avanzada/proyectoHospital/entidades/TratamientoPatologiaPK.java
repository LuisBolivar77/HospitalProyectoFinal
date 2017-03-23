package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

public class TratamientoPatologiaPK {

	private int patologia;
	
	private int tratamiento;

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + patologia;
		result = prime * result + tratamiento;
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
		TratamientoPatologiaPK other = (TratamientoPatologiaPK) obj;
		if (patologia != other.patologia)
			return false;
		if (tratamiento != other.tratamiento)
			return false;
		return true;
	}
	
	
	
}
