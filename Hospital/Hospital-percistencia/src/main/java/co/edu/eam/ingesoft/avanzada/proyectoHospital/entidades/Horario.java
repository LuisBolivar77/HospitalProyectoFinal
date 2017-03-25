package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_HORARIO")
public class Horario implements Serializable{
	
	@Id
	@Column(name="FECHA_HORA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHora;
	
	@Column(name="HORA_FIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaFin;
	
	@ManyToOne
	@JoinColumn(name="PERSONAL_MEDICO")
	private PersonalMedico personalMedico;
	
	public Horario() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param fecha_hora
	 * @param horaFin
	 * @param personalMedico
	 */
	public Horario(Date fecha_hora, Time horaFin, PersonalMedico personalMedico) {
		super();
		this.fechaHora = fechaHora;
		this.horaFin = horaFin;
		this.personalMedico = personalMedico;
	}

	/**
	 * @return the fecha_hora
	 */
	public Date getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fecha_hora the fecha_hora to set
	 */
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * @return the horaFin
	 */
	public Date getHoraFin() {
		return horaFin;
	}

	/**
	 * @param horaFin the horaFin to set
	 */
	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
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

	

}
