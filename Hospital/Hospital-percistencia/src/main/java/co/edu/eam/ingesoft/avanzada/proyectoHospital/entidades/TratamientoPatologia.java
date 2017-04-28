package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(TratamientoPatologiaPK.class)
@Table(name="TRATAMIENTO_PATOLOGIA")
public class TratamientoPatologia implements Serializable {

	@Id
	@JoinColumn(name="PATOLOGIA_ID")
	@ManyToOne
	private Patologia patologia;
	
	@Id
	@JoinColumn(name="TRATAMIENTO_ID")
	@ManyToOne
	private Tratamiento tratamiento;
	
	public TratamientoPatologia() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param patologia
	 * @param tratamiento
	 */
	public TratamientoPatologia(Patologia patologia, Tratamiento tratamiento) {
		super();
		this.patologia = patologia;
		this.tratamiento = tratamiento;
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
