package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_PATOLOGIA_PACIENTE")
@IdClass(PatologiaPacientePK.class)
public class PatologiaPaciente implements Serializable {

	@Id
	@JoinColumn(name="HISTORIAL_ID")
	@ManyToOne
	private Historial historial;
	
	@Id
	@JoinColumn(name="PATOLOGIA_ID")
	@ManyToOne
	private Patologia patologia;
	
	public PatologiaPaciente() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param historial
	 * @param patologia
	 */
	public PatologiaPaciente(Historial historial, Patologia patologia) {
		super();
		this.historial = historial;
		this.patologia = patologia;
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
	 * @return the patologia
	 */
	public Patologia getPatologia() {
		return patologia;
	}

	/**
	 * @param patologia the patologia to set
	 */
	public void setPatologia(Patologia patologia) {
		this.patologia = patologia;
	}	
	
}
