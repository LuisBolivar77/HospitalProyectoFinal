package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(MedicamentoPacientePK.class)
@Table(name="T_MEDICAMENTO_PACIENTE")
public class MedicamentoPaciente implements Serializable {

	@Id
	@JoinColumn(name="HISTORIAL_MEDICO_ID")
	@ManyToOne
	private Historial historial;
	
	@Id
	@JoinColumn(name="MEDICAMENTO_ID")
	@ManyToOne
	private Medicamento medicamento;
	
	@ManyToOne
	@JoinColumn(name="RECETA_ID")
	private Receta receta;
	
	public MedicamentoPaciente() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Método constructor
	 * @param historial Historial medico del paciente
	 * @param medicamento Medicamento del paciente
	 * @param receta Receta del paciente
	 */
	public MedicamentoPaciente(Historial historial, Medicamento medicamento, Receta receta) {
		super();
		this.historial = historial;
		this.medicamento = medicamento;
		this.receta = receta;
	}



	/**
	 * @return the historial
	 */
	public Historial getHistorial() {
		return historial;
	}

	/**
	 * @param historial the historial to set
	 */
	public void setHistorial(Historial historial) {
		this.historial = historial;
	}

	/**
	 * @return the medicamento
	 */
	public Medicamento getMedicamento() {
		return medicamento;
	}

	/**
	 * @param medicamento the medicamento to set
	 */
	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	/**
	 * @return the receta
	 */
	public Receta getReceta() {
		return receta;
	}

	/**
	 * @param receta the receta to set
	 */
	public void setReceta(Receta receta) {
		this.receta = receta;
	}
	
	
	
}
