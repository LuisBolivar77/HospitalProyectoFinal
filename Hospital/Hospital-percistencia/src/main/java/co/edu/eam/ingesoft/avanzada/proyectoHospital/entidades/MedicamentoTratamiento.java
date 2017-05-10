package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MEDICAMENTO_TRATAMIENTO")
@IdClass(MedicamentoTratamientoPK.class)
public class MedicamentoTratamiento implements Serializable {

	@Id
	@JoinColumn(name="MEDICAMENTO_ID")
	@ManyToOne
	private Medicamento medicamento;
	
	@Id
	@JoinColumn(name="TRATAMIENTO_ID")
	@ManyToOne
	private Tratamiento tratamiento;
	
	public MedicamentoTratamiento() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param medicamento
	 * @param tratamiento
	 */
	public MedicamentoTratamiento(Medicamento medicamento, Tratamiento tratamiento) {
		super();
		this.medicamento = medicamento;
		this.tratamiento = tratamiento;
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
	 * @return the tratamiento
	 */
	public Tratamiento getTratamiento() {
		return tratamiento;
	}

	/**
	 * @param tratamiento the tratamiento to set
	 */
	public void setTratamiento(Tratamiento tratamiento) {
		this.tratamiento = tratamiento;
	}
	
	
	
}
