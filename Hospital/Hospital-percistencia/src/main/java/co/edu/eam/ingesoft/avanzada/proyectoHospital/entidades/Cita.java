package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CITA")
public class Cita implements Serializable{

	@Id
	@Column(name="ID", nullable=false)
	private String id;
	
	@ManyToOne
	@JoinColumn(name="PACIENTE")
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name="PERSONAL_MEDICO")
	private PersonalMedico personalMedico;
	
	@ManyToOne
	@JoinColumn(name="CITA")
	private Cita cita;
	
	@ManyToOne
	@JoinColumn(name="TIPO_CITA")
	private TipoCita tipoCita;
	
	@JoinColumn(name="HORARIO")
	private Horario horario;
	
	@Column(name="ANOCTACIONES", nullable=false, length=200)
	private String anotaciones;
	
	
	public Cita() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param id
	 * @param paciente
	 * @param personalMedico
	 * @param cita
	 * @param tipoCita
	 * @param horario
	 * @param anotaciones
	 */
	public Cita(String id, Paciente paciente, PersonalMedico personalMedico, Cita cita, TipoCita tipoCita,
			Horario horario, String anotaciones) {
		super();
		this.id = id;
		this.paciente = paciente;
		this.personalMedico = personalMedico;
		this.cita = cita;
		this.tipoCita = tipoCita;
		this.horario = horario;
		this.anotaciones = anotaciones;
	}


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @return the paciente
	 */
	public Paciente getPaciente() {
		return paciente;
	}


	/**
	 * @param paciente the paciente to set
	 */
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}


	/**
	 * @return the personalMedico
	 */
	public PersonalMedico getPersonalMedico() {
		return personalMedico;
	}


	/**
	 * @param personalMedico the personalMedico to set
	 */
	public void setPersonalMedico(PersonalMedico personalMedico) {
		this.personalMedico = personalMedico;
	}


	/**
	 * @return the cita
	 */
	public Cita getCita() {
		return cita;
	}


	/**
	 * @param cita the cita to set
	 */
	public void setCita(Cita cita) {
		this.cita = cita;
	}


	/**
	 * @return the tipoCita
	 */
	public TipoCita getTipoCita() {
		return tipoCita;
	}


	/**
	 * @param tipoCita the tipoCita to set
	 */
	public void setTipoCita(TipoCita tipoCita) {
		this.tipoCita = tipoCita;
	}


	/**
	 * @return the horario
	 */
	public Horario getHorario() {
		return horario;
	}


	/**
	 * @param horario the horario to set
	 */
	public void setHorario(Horario horario) {
		this.horario = horario;
	}


	/**
	 * @return the anotaciones
	 */
	public String getAnotaciones() {
		return anotaciones;
	}


	/**
	 * @param anotaciones the anotaciones to set
	 */
	public void setAnotaciones(String anotaciones) {
		this.anotaciones = anotaciones;
	}

	
}
