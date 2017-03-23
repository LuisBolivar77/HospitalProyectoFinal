package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(SintomaPatologiaPK.class)
@Table(name="T_SINTOMA_PATOLOGIA")
public class SintomaPatologia implements Serializable{

	@Id
	@JoinColumn(name="SINTOMA_ID")
	@ManyToOne
	private Sintoma sintoma;
	
	@Id
	@JoinColumn(name="PATOLOGIA_ID")
	@ManyToOne
	private Patologia patologia;
	
	public SintomaPatologia() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param sintoma
	 * @param patologia
	 */
	public SintomaPatologia(Sintoma sintoma, Patologia patologia) {
		super();
		this.sintoma = sintoma;
		this.patologia = patologia;
	}

	/**
	 * @return the sintoma
	 */
	public Sintoma getSintoma() {
		return sintoma;
	}

	/**
	 * @param sintoma the sintoma to set
	 */
	public void setSintoma(Sintoma sintoma) {
		this.sintoma = sintoma;
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
