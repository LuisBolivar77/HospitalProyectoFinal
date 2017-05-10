package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(EncargadoCirugiaPK.class)
@Table(name = "ENCARGADO_CIRUGIA")
public class EncargadoCirugia implements Serializable {

	@Id
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "CIRUGIA_ID", referencedColumnName = "CIRUGIA_ID"),
			@JoinColumn(name = "CITA_ID", referencedColumnName = "CITA_ID") })
	private CirugiaRealizar cirugia;

	@Id
	@ManyToOne
	@JoinColumn(name = "PERSONAL_MEDICO_ID")
	private PersonalMedico personalMedico;

	public EncargadoCirugia() {

	}

	public EncargadoCirugia(CirugiaRealizar cirugia, PersonalMedico personalMedico) {
		super();
		this.cirugia = cirugia;
		this.personalMedico = personalMedico;
	}

	public CirugiaRealizar getCirugia() {
		return cirugia;
	}

	public void setCirugia(CirugiaRealizar cirugia) {
		this.cirugia = cirugia;
	}

	public PersonalMedico getPersonalMedico() {
		return personalMedico;
	}

	public void setPersonalMedico(PersonalMedico personalMedico) {
		this.personalMedico = personalMedico;
	}

}
