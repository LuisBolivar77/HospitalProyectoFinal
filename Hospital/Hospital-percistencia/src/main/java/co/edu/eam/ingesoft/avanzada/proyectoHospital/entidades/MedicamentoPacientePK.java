package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

public class MedicamentoPacientePK implements Serializable {
	
	private int historial;
	
	private int medicamento;
	
	public MedicamentoPacientePK() {
		// TODO Auto-generated constructor stub
	}
	

	public MedicamentoPacientePK(int historial, int medicamento) {
		super();
		this.historial = historial;
		this.medicamento = medicamento;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + historial;
		result = prime * result + medicamento;
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
		MedicamentoPacientePK other = (MedicamentoPacientePK) obj;
		if (historial != other.historial)
			return false;
		if (medicamento != other.medicamento)
			return false;
		return true;
	}


	public int getHistorial() {
		return historial;
	}


	public void setHistorial(int historial) {
		this.historial = historial;
	}


	public int getMedicamento() {
		return medicamento;
	}


	public void setMedicamento(int medicamento) {
		this.medicamento = medicamento;
	}
	
	

}
