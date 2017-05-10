package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="ESPECIALIZACION_PERSONAL")
@Entity
@IdClass(EspecializacionPersonalPK.class)
public class EspecializacionPersonal implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name="ESPECIALIZACION_ID")
	private Especializacion especializacion;
	
	@Id
	@ManyToOne
	@JoinColumn(name="PERSONAL_MEDICO")
	private PersonalMedico personal;
	
	public EspecializacionPersonal() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param especializacion
	 * @param personal
	 */
	public EspecializacionPersonal(Especializacion especializacion, PersonalMedico personal) {
		super();
		this.especializacion = especializacion;
		this.personal = personal;
	}

	/**
	 * @return the especializacion
	 */
	public Especializacion getEspecializacion() {
		return especializacion;
	}

	/**
	 * @param especializacion the especializacion to set
	 */
	public void setEspecializacion(Especializacion especializacion) {
		this.especializacion = especializacion;
	}

	/**
	 * @return the personal
	 */
	public PersonalMedico getPersonal() {
		return personal;
	}

	/**
	 * @param personal the personal to set
	 */
	public void setPersonal(PersonalMedico personal) {
		this.personal = personal;
	}
	
	
	
}
