package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

public class MedicamentoPacientePK implements Serializable {
	
	private int medicamento;
	
	private int receta;
	
	public MedicamentoPacientePK() {
		// TODO Auto-generated constructor stub
	}

	public int getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(int medicamento) {
		this.medicamento = medicamento;
	}

	public int getReceta() {
		return receta;
	}

	public void setReceta(int receta) {
		this.receta = receta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + medicamento;
		result = prime * result + receta;
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
		MedicamentoPacientePK other = (MedicamentoPacientePK) obj;
		if (medicamento != other.medicamento)
			return false;
		if (receta != other.receta)
			return false;
		return true;
	}
	
	

}
