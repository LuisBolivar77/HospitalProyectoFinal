package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

public class EspecializacionPersonalPK implements Serializable {

	private int especializacion;
	
	private String personal;
	
	public EspecializacionPersonalPK() {
		// TODO Auto-generated constructor stub
	}

	
	public int getEspecializacion() {
		return especializacion;
	}


	public void setEspecializacion(int especializacion) {
		this.especializacion = especializacion;
	}


	public String getPersonal() {
		return personal;
	}


	public void setPersonal(String personal) {
		this.personal = personal;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + especializacion;
		result = prime * result + ((personal == null) ? 0 : personal.hashCode());
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
		EspecializacionPersonalPK other = (EspecializacionPersonalPK) obj;
		if (especializacion != other.especializacion)
			return false;
		if (personal == null) {
			if (other.personal != null)
				return false;
		} else if (!personal.equals(other.personal))
			return false;
		return true;
	}

	
	
	
}
